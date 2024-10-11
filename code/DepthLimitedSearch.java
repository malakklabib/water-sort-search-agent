package code;

import java.util.Stack;

public class DepthLimitedSearch implements SearchStrategy {
    private Stack<Node> stack;
    private static int cutoff = -1;

    public DepthLimitedSearch(){
        stack = new Stack<>();
        DepthLimitedSearch.cutoff++;
    }

    public static int getCutoff() {
        return cutoff;
    }

    public static void setCutoff(int cutoff) {
        DepthLimitedSearch.cutoff = cutoff;
    }

    @Override
    public void add(Node node) {
        if(node.getDepth() > cutoff)
            return;
        stack.push(node);
    }

    @Override
    public Node remove() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
