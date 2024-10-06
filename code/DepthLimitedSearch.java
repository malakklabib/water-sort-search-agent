package code;

import java.util.Stack;

public class DepthLimitedSearch implements SearchStrategy {
    private Stack<Node> stack;
    private Integer cutoff;

    public DepthLimitedSearch(Integer cutoff){
        stack = new Stack<>();
        this.cutoff = cutoff;
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
