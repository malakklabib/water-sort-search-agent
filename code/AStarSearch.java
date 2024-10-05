package code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarSearch implements SearchStrategy {
    PriorityQueue<Node> pq;

    Heuristic heuristic; // `Heuristic` is an interface that declares a method: `evaluate(Node) -> int`
    // To be implemented by specific classes that provide different behaviors for `evaluate`

    Comparator<Node> comparator; // Comparator function responsible for defining the order of insertion into `pq`

    // changed arg `int heuristic` to `heuristic*Id*` to avoid confusing with newly added instance variable of same name
    public AStarSearch(int heuristicId) {
        if (heuristicId == 1) {
            heuristic = new MisplacedLayersHeuristic();
        } else {
            heuristic = new MostSeparatedColorHeuristic();
            // OR
            // heuristic = new IncompleteBottlesHeuristic();
        }

        // Nodes are compared using f(n) = h(n) + g(n)
        comparator = (n1, n2) -> Integer.compare(
                heuristic.evaluate(n1) + n1.getPathCost(), heuristic.evaluate(n2) + n2.getPathCost());

        pq = new PriorityQueue<>(comparator);   // Initialize pq using the above comparator

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
}
