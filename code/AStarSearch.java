package code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarSearch implements SearchStrategy {
    PriorityQueue<Node> pq;

    // Necessary if Design #2 is to be used, otherwise remove.
    int heuristicId;

    // Design choice #1: `Heuristic` is an interface that declares a method: `evaluate(Node) -> int`
    // To be implemented by specific classes that provide different behaviors for `evaluate`

    // An alternative design choice, #2, is to define separate methods `someHeuristicMethod_1/2(Node) -> int` in class
    // `AStarSearch` each corresponding to a specific heuristic behavior. Then, a wrapper method `evaluate(Node) -> int`
    // will conditionally call one of them based on `AStarSearch.heuristicId`

    // The interface design is preferred in case the same heuristics will be shared with `GreedySearch`, seeing as
    // heuristic behaviors are defined in external files, they can be easily shared between `GreedySearch` and
    // `AStarSearch` without needing to duplicate the methods as is the case if Design #2 is followed.
    Heuristic heuristic;

    // Comparator function (anonymous) responsible for defining the order of insertion into `pq`
    Comparator<Node> comparator;

    // changed arg `int heuristic` to `heuristic*Id*` to avoid confusing with newly added instance variable of same name
    public AStarSearch(int heuristicId) {
        if (heuristicId == 1) {
            // Placeholder code until heuristic classes have been designed
            // once fixed, will look something like the following:
            // this.heuristic = new SomeHeuristicClass_1();
            heuristic = null;
        } else {
            // this.heuristic = new SomeHeuristicClass_2();
            heuristic = null;
        }

        // Nodes are compared using f(n) = h(n) + g(n)
        comparator = (n1, n2) -> Integer.compare(
                heuristic.evaluate(n1) + n1.getPathCost(), heuristic.evaluate(n2) + n2.getPathCost());

        // Initialize pq using the above comparator
        pq = new PriorityQueue<>(comparator);
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
