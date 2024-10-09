
public class RSICalculator {

    public static double calculateRSI(double[] array, int period) {
        double avGainUpPeriods = 0;
        double avLossDownPeriods = 0;
        int gainCount = 0;
        int lossCount = 0;
        double previousObservation = array[0];

        for (int i = 1; i < array.length; i++) {
            if (previousObservation < array[i]) { // if gain
                double gain = array[i] - previousObservation;
                gainCount++;
                avGainUpPeriods += gain;
            } else if (previousObservation > array[i]) { // if loss
                double loss = previousObservation - array[i];
                lossCount++;
                avLossDownPeriods += loss;
            }
            previousObservation = array[i];
        }

        // Avoid division by zero
        avGainUpPeriods = (gainCount > 0) ? avGainUpPeriods / gainCount : 0;
        avLossDownPeriods = (lossCount > 0) ? avLossDownPeriods / lossCount : 0;

        // Calculate relative strength
        double relativeStrength = (avLossDownPeriods != 0) 
                                  ? avGainUpPeriods / avLossDownPeriods 
                                  : 0; // Prevent division by zero

        // Calculate RSI
        double relativeStrengthIndex = 100 - (100 / (1 + relativeStrength));

        // PRINT RESULT
        return relativeStrengthIndex;
    }

    public static void main(String[] args) {
        double[] priceArray = {1628.699951171875,1639.3499755859375,1610.050048828125,1599.699951171875,1594.4000244140625,1597.5,1568.300048828125,1590.9000244140625,1599.4000244140625,1600.6500244140625,1585.300048828125,1608.9000244140625,1637.300048828125,1644.0999755859375}; // Sample data
        int period = 14; // Example period
        double rsi = calculateRSI(priceArray, period);
        System.out.println("RSI: " + rsi);
    }
}
