package code;

import java.util.Objects;

public class Node{
    private Object state;
    private Node parent;
    private String action;
    private int depth;
    private int pathCost;
    private static int maxDepth;


    public Node(Object state, Node parent, String action, int depth, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.depth = depth;
        this.pathCost = pathCost;
    }

    public static int getMaxDepth() {
        return maxDepth;
    }

    public static void setMaxDepth(int maxDepth) {
        Node.maxDepth = maxDepth;
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

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Node node = (Node) obj;
//        return state == node.state;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(state);
//    }
}
