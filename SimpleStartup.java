package Java_001;
public class SimpleStartup {
    private int[] locationCells;
    private int numOfHits = 0;

    // Method to set the location cells
    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    // Method to check a user's guess
    public String checkYourself(int guess) {
        String result = "Miss";

        for (int cell : locationCells) {
            if (guess == cell) {
                result = "Hit";
                numOfHits++;
                break;
            }
        }

        if (numOfHits == locationCells.length) {
            result = "Kill";
        }

        System.out.println(result);
        return result;
    }
}

