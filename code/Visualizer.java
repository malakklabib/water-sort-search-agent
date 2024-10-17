package code;

import java.util.ArrayList;
import java.util.List;

public class Visualizer {
    public static void display(List<Bottle> state, int depth) {
        Integer numBottles = state.size();
        int numDashes = 5 * numBottles + 3 * (numBottles - 1) - 10 - numBottles.toString().length();

        System.out.println("-".repeat(numDashes / 2) + " depth = " + depth + " " + "-".repeat(numDashes / 2));

        // Get bottle string representations
        List<String[]> bottleStrings = new ArrayList<>();
        for (Bottle bottle : state) {
            bottleStrings.add(bottle.toStringArray());
        }

        // Print each row across all bottles
        for (int row = 0; row < bottleStrings.get(0).length; row++) {
            for (String[] bottle : bottleStrings) {
                System.out.print(bottle[row] + "   "); // Print each bottle row side by side with spacing
            }
            System.out.println(); // New line after each row
        }
    }
}
