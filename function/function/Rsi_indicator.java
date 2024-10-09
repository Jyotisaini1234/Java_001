
// import java.util.ArrayList;
// import java.util.List;

// public class Rsi_indicator {

// static Candlestick[] candles = getCandleSticks();
// static double[] gain_array = new double[candles.length];
// static double[] loss_array = new double[candles.length];
// public static final int RSI_PERIOD = 14;
   



// public static void main(String[] args, double avg_gain, double avg_loss) {

//     /**
//      * 1. Calculate change over closes
//      *
//      * */
//     for (int i = 0; i < candles.length; i++) {

//         double gain = 0;
//         double loss = 0;

//         if (i >= 1) {
//             double change = candles[i - 1].getClose() - candles[i].getClose();
//             gain_array[i] = change >= 0 ? change : 0.0d;
//             loss_array[i] = change < 0 ? (-1) * change : 0.0d;
//         }
//     }

//     /**
//      * 2. Calculate AVG gain
//      *
//      *  According to trading view they use this -->  avgGain = rma(gain, 14)
//      *  Where
//      *  RMA = alpha * source + (1-alpha) * RMA[1]
//      *  alpha = 1/length
//      */

//     double alpha = 1.0 / RSI_PERIOD;
//     RMA rma_gain = new RMA(alpha);
//     RMA rma_loss = new RMA(alpha);


//    /*
//    TODO HOW EXACTLY TO IMPLEMENT THE ABOVE RMA?
//     what is exactly meant by source ? and RMA[1] is this the previous value that was calculated?
//     */


//     /**
//      *  4. Calculate relative strength
//      * */
//     double RS = avg_gain / avg_loss;

//     /**
//      * 5.  Calculate RSI
//      * */
//     double rsi = 100 - (100 / (1 + RS));


//     /**
//      * The last 4 calculated rsi values should be:
//      * 7 nov 2021 --> 59.68
//      * 8 nov 2021 --> 67.65
//      * 9 nov 2021 --> 65.75
//      * 10 nov 2021 --> 59.33
//      */
//     System.out.println("RSI: " + rsi);

// }




// static class RMA {
//     private double alpha;
//     private Double oldValue;

//     public RMA(double alpha) {
//         this.alpha = alpha;
//     }

//     public double average(double value) {
//         if (oldValue == null) {
//             oldValue = value;
//             return value;
//         }

//         double newValue = oldValue + alpha * (value - oldValue);

//         return newValue;
//     }}






//     /**
//      * This is just for you to have a working sample instantly
//      * The sample data i pulled from the binance api is the
//      * 1D BINANCE BTCUSDT pair from 2021-10-20T02:00 TO 2021-11-10T01:00.
//      */
//     static Candlestick[] getCandleSticks() {

//         String[] data =
//                 {"1628.699951171875","1639.3499755859375","1610.050048828125",
//                 "1599.699951171875","1594.4000244140625","1597.5","1568.300048828125"
//                 ,"1590.9000244140625","1599.4000244140625","1600.6500244140625","1585.300048828125","1608.9000244140625"
//                 ,"1637.300048828125","1644.0999755859375"

//         };


//         List<Candlestick>list = new ArrayList<>();

//         for (String s: data) {
//             Candlestick c  = new Candlestick();
//             String[] sArr = s.split(",");

//             c.setOpenTime(Long.valueOf(sArr[0]));
//             c.setOpen(sArr[1]);
//             c.setHigh(sArr[2]);
//             c.setLow(sArr[3]);
//             c.setClose(sArr[4]);
//             c.setCloseTime(Long.valueOf(sArr[5]));
//             list.add(c);
//         }
//         return  list.stream().toArray(Candlestick[]::new);
//     }
// }


import java.util.ArrayList;
import java.util.List;

public class Rsi_indicator {

    static Candlestick[] candles = getCandleSticks();
    static double[] gain_array = new double[candles.length];
    static double[] loss_array = new double[candles.length];
    public static final int RSI_PERIOD = 14;

    public static void main(String[] args) {
        double avg_gain = 0; // Initialize avg_gain
        double avg_loss = 0; // Initialize avg_loss

        // 1. Calculate change over closes
        for (int i = 0; i < candles.length; i++) {
            double gain = 0;
            double loss = 0;

            if (i >= 1) {
                double change = candles[i - 1].getClose() - candles[i].getClose();
                gain_array[i] = change >= 0 ? change : 0.0d;
                loss_array[i] = change < 0 ? (-1) * change : 0.0d;
            }
        }

        // 2. Calculate AVG gain
        double alpha = 1.0 / RSI_PERIOD;
        RMA rma_gain = new RMA(alpha);
        RMA rma_loss = new RMA(alpha);

        // TODO: Implement RMA logic here

        // 4. Calculate relative strength
        double RS = avg_gain / avg_loss;

        // 5. Calculate RSI
        double rsi = 100 - (100 / (1 + RS));

        // Output RSI
        System.out.println("RSI: " + rsi);
    }

    static class RMA {
        private double alpha;
        private Double oldValue;

        public RMA(double alpha) {
            this.alpha = alpha;
        }

        public double average(double value) {
            if (oldValue == null) {
                oldValue = value;
                return value;
            }

            double newValue = oldValue + alpha * (value - oldValue);
            oldValue = newValue; // Update oldValue
            return newValue;
        }
    }

    // Sample Candlestick data
    static Candlestick[] getCandleSticks() {
        String[] data = {
            "1628.699951171875", "1639.3499755859375", "1610.050048828125",
            "1599.699951171875", "1594.4000244140625", "1597.5",
            "1568.300048828125", "1590.9000244140625", "1599.4000244140625",
            "1600.6500244140625", "1585.300048828125", "1608.9000244140625",
            "1637.300048828125", "1644.0999755859375"
        };

        List<Candlestick> list = new ArrayList<>();
        for (String s : data) {
            Candlestick c = new Candlestick();
            // Assuming Candlestick has appropriate methods to set values
            c.setOpenTime(System.currentTimeMillis()); // You might want to adjust this
            c.setOpen(Double.parseDouble(s)); // Sample values for open, high, low, close
            c.setHigh(Double.parseDouble(s)); // Same as above
            c.setLow(Double.parseDouble(s)); // Same as above
            c.setClose(Double.parseDouble(s)); // Same as above
            c.setCloseTime(System.currentTimeMillis()); // You might want to adjust this
            list.add(c);
        }
        return list.toArray(new Candlestick[0]);
    }
}
