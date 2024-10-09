
import java.util.ArrayList;
import java.util.List;

// import java.util.Arrays;

// public class RSICalculatorNew {

//     public static void main(String[] args) {
//         double[] closeValues = {1626.95, 1626.95, 1641.80, 1645.45, 1636.95};
//         double rsiLengthInput = 14; // Typically, RSI is calculated over 14 periods
//         double previousRMAUp = 1633.227; // Previous RMA values for up and down
//         double previousRMADown = 0; // For the initial example

//         double[] changes = new double[closeValues.length - 1];

//         // Calculate the changes in closing prices
//         for (int i = 1; i < closeValues.length; i++) {
//             changes[i - 1] = closeValues[i] - closeValues[i - 1];
//         }

//         // Calculate up and down values using RMA
//         double up = previousRMAUp;
//         double down = previousRMADown;

//         for (double change : changes) {
//             if (change > 0) {
//                 up = (up * (rsiLengthInput - 1) + change) / rsiLengthInput; // RMA for gains
//             } else {
//                 down = (down * (rsiLengthInput - 1) - change) / rsiLengthInput; // RMA for losses
//             }
//         }

//         // Calculate RSI
//         double rsi;
//         if (down == 0) {
//             rsi = 100;
//         } else if (up == 0) {
//             rsi = 0;
//         } else {
//             rsi = 100 - (100 / (1 + (up / down)));
//         }

//         // Print results
//         System.out.printf("Up Value: %.3f%n", up);
//         System.out.printf("Down Value: %.3f%n", down);
//         System.out.printf("RSI: %.2f%n", rsi);
//     }
// }

public class RSICalculatorNew {

    // Example function to calculate RSI using the previous RMA value
    public double calculateRSI(List<Double> closeValues, int rsiLengthInput, double previousRMA) {
        if (closeValues.size() < rsiLengthInput) {
            throw new IllegalArgumentException("Not enough data to calculate RSI");
        }

        List<Double> gains = new ArrayList<>();
        List<Double> losses = new ArrayList<>();

        // Calculate gains and losses
        for (int i = 1; i < closeValues.size(); i++) {
            double change = closeValues.get(i) - closeValues.get(i - 1);
            gains.add(Math.max(change, 0));  // Upward change
            losses.add(Math.abs(Math.min(change, 0))); // Downward change
        }

        // Calculate RMA for gains and losses using the previous RMA value (1,633.227)
        double upRMA = calculateRMA(gains, rsiLengthInput, previousRMA);
        double downRMA = calculateRMA(losses, rsiLengthInput, previousRMA);

        // Calculate RSI
        if (downRMA == 0) {
            return 100;
        } else if (upRMA == 0) {
            return 0;
        } else {
            return 100 - (100 / (1 + upRMA / downRMA));
        }
    }

    // Function to calculate RMA with the previous RMA value
    public double calculateRMA(List<Double> values, int period, double previousRMA) {
        if (values.size() < period) {
            throw new IllegalArgumentException("Not enough values to calculate RMA");
        }

        // Initialize the first RMA as the previous RMA (1,633.227)
        double rma = previousRMA;

        // Update the RMA based on the new values
        for (int i = period; i < values.size(); i++) {
            rma = ((rma * (period - 1)) + values.get(i)) / period;
        }

        return rma;
    }

    public static void main(String[] args) {
        // Example usage
        List<Double> closeValues = List.of(1633.227, 1626.95, 1637.35, 1641.8, 1645.45, 1636.95);
        int rsiLengthInput = 5;
        double previousRMA = 1633.227;

        RSICalculatorNew rsiService = new RSICalculatorNew();
        double rsi = rsiService.calculateRSI(closeValues, rsiLengthInput, previousRMA);
        System.out.println("Calculated RSI: " + rsi);
    }
}
