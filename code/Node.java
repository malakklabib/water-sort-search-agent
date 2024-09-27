package code;

public class Node{
    private Object state;
    private Node parent;
    private String operator;
    private int depth;
    private int pathCost;

    public Node(Object state, Node parent, String operator, int depth, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.operator = operator;
        this.depth = depth;
        this.pathCost = pathCost;
    }

    public Object getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }
    public String getOperator() {
        return operator;
    }

    public int getDepth() {
        return depth;
    }

    public int getPathCost() {
        return pathCost;
    }
}
