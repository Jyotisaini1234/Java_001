import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApiClient {
    private double currentPrice;
    private boolean getPriceSuccessful = false;

    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        apiClient.updatePrice();
    }

    public void updatePrice() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(this::getPrices);
    }

    private void getPrices() {
        while (true) {
            try {
                String response = makeRequest("https://api1.binance.com/api/v3/ticker/price?symbol=BTCUSDT");
                JSONObject json = new JSONObject(response);
                currentPrice = json.getDouble("price");
                getPriceSuccessful = true;
                System.out.println("Current Price: " + currentPrice);
            } catch (Exception e) {
                System.out.println("Get_Prices Error: " + e.getMessage());
                getPriceSuccessful = false;
            }
        }
    }

    private String makeRequest(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public void getRsi(String coinPair, String interval) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> initiateRsi(coinPair, interval));
    }

    private void initiateRsi(String coinPair, String interval) {
        double[] allKlinesClose = new double[1000];
        int klineNum = 0;
        int gap = 10;

        while (true) {
            klineNum = getKlines(coinPair, interval, allKlinesClose, 1000);
            if (klineNum <= 0) {
                System.out.println("Cannot retrieve data. Please check your internet connection.");
            } else {
                break;
            }

            System.out.println("Will try again in " + gap + " seconds");
            sleep(gap);

            gap = Math.min(gap * 2, 40);
        }

        System.out.println("!!!!!!!!!!!!!GOT klines successfully");

        double[] changeClosesUp = new double[klineNum - 1];
        double[] changeClosesDown = new double[klineNum - 1];

        System.out.println("Getting change_calc");
        changeCalc(allKlinesClose, changeClosesUp, changeClosesDown, klineNum);
        System.out.println("change_calc done");

        double[] rmaUp = new double[klineNum - 14];
        double[] rmaDown = new double[klineNum - 14];

        System.out.println("Getting rma_calc");
        rmaCalc(changeClosesUp, rmaUp, klineNum - 1, 14);
        rmaCalc(changeClosesDown, rmaDown, klineNum - 1, 14);
        System.out.println("rma_calc done");

        double[] rsi = new double[klineNum - 14];
        rsiCalc(rmaUp, rmaDown, rsi, klineNum - 14, 14);

        for (int i = 0; i < klineNum - 14; i++) {
            System.out.println(coinPair + " RSI" + i + "=" + rsi[i]);
        }
        System.out.println("Executing update_rsi");
        updateRsi(coinPair, interval, rmaUp[klineNum - 15], rmaDown[klineNum - 15], 14);
    }

    private int getKlines(String symbol, String interval, double[] allKlinesClose, int size) {
        String urlString = "https://api1.binance.com/api/v3/klines?symbol=" + symbol + "&interval=" + interval + "&limit=" + size;

        try {
            String response = makeRequest(urlString);
            JSONArray jsonArray = new JSONArray(response);

            int i = 0;
            for (int j = 0; j < jsonArray.length(); j++) {
                String close = jsonArray.getJSONArray(j).getString(4);
                allKlinesClose[i] = Double.parseDouble(close);
                i++;
                if (i == size) break;
            }

            return i;
        } catch (Exception e) {
            System.out.println("#######################get_klines ERROR: " + e.getMessage());
            return 0;
        }
    }

    private void changeCalc(double[] array, double[] arrayUp, double[] arrayDown, int size) {
        for (int i = 1; i < size; i++) {
            double temp = array[i] - array[i - 1];

            if (temp < 0) {
                arrayDown[i - 1] = -temp;
                arrayUp[i - 1] = 0;
            } else {
                arrayUp[i - 1] = temp;
                arrayDown[i - 1] = 0;
            }
        }
    }

    private void rmaCalc(double[] changeArray, double[] rmaArray, int changeArraySize, int period) {
        double sma = 0;

        for (int i = 0; i < period; i++) {
            sma += changeArray[i];
        }
        sma /= period;

        double alpha = 1.0 / period;
        rmaArray[0] = sma;

        for (int i = period; i < changeArraySize; i++) {
            double rma = alpha * changeArray[i] + (1 - alpha) * rmaArray[i - period];
            rmaArray[i - period + 1] = rma;
        }
    }

    private void rsiCalc(double[] rmaUp, double[] rmaDown, double[] rsiArray, int rmaSize, int period) {
        for (int i = 0; i < rmaSize; i++) {
            double rsi = 100 - (100 / (1 + rmaUp[i] / rmaDown[i]));
            rsiArray[i] = rsi;
        }
    }

    private void updateRsi(String coinPair, String interval, double rmaUpPrev, double rmaDownPrev, int period) {
        sleep(2000); // Let the price update

        double[] allKlinesClose = new double[2];
        int klineNum = 0;
        int gap = 10;

        while (true) {
            klineNum = getKlines(coinPair, interval, allKlinesClose, 2);
            if (klineNum <= 0) {
                System.out.println("update_rsi: Cannot retrieve data. Please check your internet connection.");
            } else {
                break;
            }

            System.out.println("update_rsi: will try again in " + gap + " seconds");
            sleep(gap);

            gap = Math.min(gap * 2, 3600);
        }

        System.out.println("update_rsi: get_klines done");
        double close = allKlinesClose[1];
        double closePrev = allKlinesClose[0];

        long lastCandleCloseTime = lastCandleClose(interval);

        if (lastCandleCloseTime == 0) {
            System.out.println("rsi_calc_new: INVALID INTERVAL");
            System.exit(0);
        }

        while (true) {
            if (getPriceSuccessful) {
                close = currentPrice;

                double change = close - closePrev;
                double changeDown = (change < 0) ? -change : 0;
                double changeUp = (change >= 0) ? change : 0;

                double alpha = 1.0 / period;
                double rmaUp = alpha * changeUp + (1 - alpha) * rmaUpPrev;
                double rmaDown = alpha * changeDown + (1 - alpha) * rmaDownPrev;
                double rsi = 100 - (100 / (1 + rmaUp / rmaDown));
                System.out.println("#### " + coinPair + " RSI=" + rsi);

                if (getTimestamp() >= lastCandleCloseTime) {
                    System.out.println("Candle Closed");
                    lastCandleCloseTime = lastCandleClose(interval);

                    klineNum = 0;

                    while (true) {
                        klineNum = getKlines(coinPair, interval, allKlinesClose, 2);

                        if (klineNum <= 0) {
                            System.out.println("Could not retrieve data");
                            if (getTimestamp() <= (lastCandleCloseTime - 10000)) {
                                sleep(10);
                            } else {
                                getRsi(coinPair, interval);
                                return;
                            }
                        } else {
                            break;
                        }
                    }

                    double closePrevPrev = closePrev;
                    closePrev = allKlinesClose[0];

                    rmaUpPrev = rmaUp;
                    rmaDownPrev = rmaDown;

                    System.out.println("First Close: " + closePrevPrev + ", Second Close: " + closePrev);
                }
            }
            sleep(1);
        }
    }

    private long lastCandleClose(String interval) {
        // Implement this method to return the last candle close timestamp based on the given interval
        return 0; // Placeholder
    }

    private long getTimestamp() {
        return System.currentTimeMillis();
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
    }
}
