package code;

public class Node{
    private Object state;
    private Node parent;
    private String action;
    private int depth;
    private int pathCost;

    public Node(Object state, Node parent, String action, int depth, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.depth = depth;
        this.pathCost = pathCost;
    }

    public Object getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }
    public String getAction() {
        return action;
    }

    public int getDepth() {
        return depth;
    }

    public int getPathCost() {
        return pathCost;
    }
}
