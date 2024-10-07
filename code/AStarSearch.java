package code;

import java.util.*;

public class AStarSearch extends BestFirstSearch {

    // Changed arg `int heuristic` to `heuristic*Id*` to avoid confusing with newly added instance variable of same name
    public AStarSearch(int heuristicId) {
        super(heuristicId);
    }

    // Nodes are compared using f(n) = h(n) + g(n)
    @Override
    public Comparator<Node> makeComparator() {
        return (n1, n2) -> Integer.compare(
                getHeuristic().evaluate(n1) + n1.getPathCost(), getHeuristic().evaluate(n2) + n2.getPathCost());
    }

}
