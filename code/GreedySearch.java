package code;

import java.util.*;

public class GreedySearch extends BestFirstSearch {
    // Changed arg `int heuristic` to `heuristic*Id*` to avoid confusing with newly added instance variable of same name
    public GreedySearch(int heuristicId) {
        super(heuristicId);
    }

    // Nodes are compared using f(n) = h(n)
    @Override
    public Comparator<Node> makeComparator() {
        return (n1, n2) -> Integer.compare(heuristic.evaluate(n1), heuristic.evaluate(n2));
    }
}
