package code;

import java.util.*;

public abstract class BestFirstSearch implements SearchStrategy {
    private PriorityQueue<Node> pq;

    private Heuristic heuristic; // `Heuristic` is an interface that declares a method: `evaluate(Node) -> int`
    // To be implemented by specific classes that provide different behaviors for `evaluate`

    // Changed arg `int heuristic` to `heuristic*Id*` to avoid confusing with newly added instance variable of same name
    public BestFirstSearch(int heuristicId) {
        if (heuristicId == 1) {
            heuristic = new MisplacedLayersHeuristic();
        } else {
            heuristic = new MostSeparatedColorHeuristic();
            // OR
//             heuristic = new IncompleteBottlesHeuristic();
        }

        pq = new PriorityQueue<>(makeComparator());   // Initialize pq using the above comparator
    }

    @Override
    public void add(Node node) {
        pq.add(node);
    }

    @Override
    public Node remove() {
        return pq.remove();
    }

    @Override
    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public abstract Comparator<Node> makeComparator();

    public Heuristic getHeuristic() {
        return heuristic;
    }
}
