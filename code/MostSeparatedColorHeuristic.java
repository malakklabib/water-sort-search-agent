package code;

import java.util.*;

// This heuristic estimates the cost-to-goal as the number of the most separated layers of one color minus one.
// Separated layers are layers of the same color that are found in distinct bottles. The most separated color is
// the color with layers spread across the most bottles.

// For the puzzle to be solved, all layers of one color must be consolidated together. To form an optimistic lower bound
// on the cost to a goal, we estimate the number of separated layers of ONE color to be the number of moves needed to sort
// the puzzle. Since we consider only one color, and consider that consolidating n separated layers takes n - 1 moves when
// practically it might take one or more moves, we ensure that the heuristic is admissible.

// In order to determine which color is used to calculate the heuristic (note that any of them would be admissible), we use
// the colors that is most separated, i.e., would require the most moves, to form a more dominant (tighter) lower bound.

// For a given state S, with bottles containing colors C:
// h(S) = max([numberOfBottlesContaining(c) for c in C]) - 1.

// ---------------------------------------------------------------------------------------------------------------------

// Example:

//    Bottle_0                    Bottle_1                      Bottle_2
//    --------                    --------                      --------
//      'b'                         'b'                           'r'
//      'b'                         'r'                           'r'
//      'g'                         'g'                           'g'

// h = max([numberOfBottlesContaining('r'), numberOfBottlesContaining('g'), numberOfBottlesContaining('b')]) - 1
//   = max([2, 3, 2]) - 1
//   = 2

// This puzzle cannot be solved in less than 2 moves.

// ---------------------------------------------------------------------------------------------------------------------

public class MostSeparatedColorHeuristic implements Heuristic {
    // Maps each color to the bottles (IDs) it is present in
    HashMap<Character, HashSet<Integer>> membership = new HashMap<>();

    // Updates `membership` for a certain bottle
    public void computeMembershipPerBottle(Bottle bottle, int bottleId) {
        HashSet<Integer> bottleIds; // A set is used to avoid duplicate IDs
        for (Character layer : bottle.getContent()) {
            if (membership.containsKey(layer)) {    // An entry for this color already exists
                // Get the set containing the IDs of the bottle of which this color is a member
                bottleIds = membership.get(layer);
            } else {
                // This color was not encountered before
                bottleIds = new HashSet<>();    // Initialize an empty set
                membership.put(layer, bottleIds);   // Add an entry for this color in `membership`
            }
            bottleIds.add(bottleId);    // Add the ID of the bottle at hand to the set of IDs of the color at hand
        }
    }

    // Repeat `computeMembershipPerBottle()` for all bottles
    public void computeMemberships(List<Bottle> state) {
        for (int i = 0; i < state.size(); i++) {
            Bottle bottle = state.get(i);
            computeMembershipPerBottle(bottle, i);
        }
    }

    @Override
    public int evaluate(Node node) {
        List<Bottle> state = (List<Bottle>) node.getState();  // Extract the state from the node

        computeMemberships(state);  // Compute the memberships

        // Get the pair <Color, BottleIDs> corresponding to the most separated color, i.e., the one with the
        // longest `BottleIDs` by computing the maximum amongst BottleIDs according to length
        Map.Entry<Character, HashSet<Integer>> longestPair = Collections.max(membership.entrySet(),
                (e1, e2) -> Integer.compare(e1.getValue().size(), e2.getValue().size()));

        Character mostSeparatedColor = longestPair.getKey();    // Get the most separated color
        int numSeparations = longestPair.getValue().size();  // Get the number of bottles it is spread across

        return numSeparations - 1;
    }
}
