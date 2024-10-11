package code;

import java.util.*;

// This heuristic estimates the cost-to-goal as the number of incomplete bottles.

// A bottle is complete if it is empty, or if it contains layers of only one color. The puzzle cannot be solved
// unless all bottles are complete.

// In order to solve the puzzle, incomplete bottles must be completed, which naturally requires one or more
// moves to fulfill. To form an optimistic lower bound on the cost, we assume completing a bottle can be done in 1 move.
// This ensures that the heuristic is admissible.

// For a given state S, with bottles B:
// h(S) = length([b if !isComplete(b) for b in B]).

// ---------------------------------------------------------------------------------------------------------------------

// Examples:

//    Bottle_0                    Bottle_1                      Bottle_2
//    --------                    --------                      --------
//      'b'                         'b'                           'r'
//      'g'                         'b'                           'r'
//      'g'                         'g'                           'r'

// h = length([b if !isComplete(b) for b in [0, 1, 2]])
//   = length([0, 1])
//   = 2

// This puzzle cannot be solved in less than 2 moves.

// ---------------------------------------------------------------------------------------------------------------------


public class IncompleteBottlesHeuristic implements Heuristic {
    public boolean isComplete(Bottle bottle) {
        int numLayers = bottle.getSize();

        if (numLayers == 0) // An empty bottle is trivially complete
            return true;

        Character bottomMostLayer = bottle.getContent().get(0);  // Get the bottom-most layer

        for (int i = 0; i < numLayers; i++) {
            Character layer = bottle.getContent().get(i);

            if (layer != bottomMostLayer)   // If two layers do not match, the bottle is incomplete
                return false;
        }

        return true;
    }

    @Override
    public int evaluate(Node node) {
        List<Bottle> state = (List<Bottle>) node.getState();  // Extract the state from the node
        int res = 0;    // Initialize an accumulator

        for (Bottle bottle : state) {  // Iterate over each bottle
            if (!isComplete(bottle))    // Count the number of incomplete bottles
                res++;
        }
        return res;
    }
}
