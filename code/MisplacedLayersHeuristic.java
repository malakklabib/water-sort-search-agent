package code;

import java.util.*;

// This heuristic estimates the cost-to-goal as the total number of "misplaced layers" across the bottles.

// A layer is said to be misplaced if it does not form a contiguous homogenous block with the bottom-most layer.
// The intuition is that for the puzzle to be solved, each (non-empty) bottle must be filled with the same color,
// hence, any layer that does not conform with the bottom-most layer would unavoidably need to be moved to sort
// the bottles correctly.

// In order to solve the puzzle, these misplaced layers would need to be moved to their correct final positions,
// which in most cases would take more than one move to fulfill. To form an optimistic lower bound on the cost,
// we assume moving each misplaced layer to its target position would be fulfilled with (1) move. This ensures that
// the heuristic is admissible.

// For a given state S, with bottles B:
// h(S) = sum([numMisplaced(b) for b in B]).

// ---------------------------------------------------------------------------------------------------------------------

// Examples:

//    Bottle_0                    Bottle_1                Bottle_2 (no cutoff)
//    --------                    --------                --------------------
//      'b' *                       'b' *                         'r'
//      'g' ^ cutoff                'b' *                         'r'
//      'g'                         'g' ^ cutoff                  'r'

// Misplaced Layers are marked with an asterisk.

// h = sum([numMisplaced(0), numMisplaced(1), numMisplaced(2)])
//   = sum([1, 2, 0])
//   = 3

// This puzzle cannot be solved in less than 3 moves.

// ---------------------------------------------------------------------------------------------------------------------


public class MisplacedLayersHeuristic implements Heuristic {
    public int numMisplaced(Bottle bottle) {
        int numLayers = bottle.getSize();  // Number of non-empty layers in the bottle

        if (numLayers == 0) return 0;

        Character bottomMostLayer = bottle.getBottomLayer();  // Get the color of the bottom-most layer

        int cutoff = -1;    // The index at which the contiguous bottom-most block is split.
        // All layers thereafter are considered misplaced.

        for (int i = 0; i < numLayers; i++) // Determine cutoff
            if (bottle.getContent().get(i) != bottomMostLayer) {
                cutoff = i;
                break;
            }

        if (cutoff == -1) return 0; // The bottle contains only one color and nothing is misplaced.

        return numLayers - cutoff;  // Accumulate he number of misplaced layers
    }

    @Override
    public int evaluate(Node node) {
        List<Bottle> state = (List<Bottle>) node.getState();  // Extract the state from the node
        int res = 0;    // Initialize an accumulator

        for (Bottle bottle : state)   // Iterate over each bottle
            res += numMisplaced(bottle);    // Accumulate the number of misplaced layers

        return res;
    }

}
