package code;

import java.util.*;

public abstract class GenericSearch {
    private int expandedNodes = 0;

    public abstract Object getInitialState(String problem);

    public abstract boolean isGoalState(Object state);

    public abstract List<Node> expand(Node node);

    public Node baseSearch(String problem, String strategy) throws Exception {
        Bottle.setGlobalId(0);

//        Set<Object> seen = new HashSet<>();
        Map<Object, Integer> seen = new HashMap<>();
        Object initState = getInitialState(problem);
        Node root = new Node(initState, null, null, 0, 0);
        SearchStrategy queue = makeQueue(strategy);
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();
            Object currState = currNode.getState();

            if (isGoalState(currState))
                return currNode;

            Node.setMaxDepth(Math.max(currNode.getDepth(), Node.getMaxDepth()));
            seen.put(currState, currNode.getPathCost());
            expandedNodes++;

            for (Node child : expand(currNode)) {
                if (!seen.containsKey(child.getState()) || seen.get(child.getState()) > child.getPathCost())
                    queue.add(child);
            }
        }
        return null;
    }

    public Node search(String problem, String strategy) throws Exception {
        Node goalNode;
        if (strategy.equals("ID"))
            do {
                goalNode = this.baseSearch(problem, strategy);
            } while (goalNode == null && DepthLimitedSearch.getCutoff() <= Node.getMaxDepth());
        else
            goalNode = this.baseSearch(problem, strategy);

        return goalNode;
    }

    public abstract SearchStrategy makeQueue(String strategy) throws Exception;

    public int getExpandedNodes() {
        return expandedNodes;
    }
}
