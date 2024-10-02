package code;

import java.util.Stack;

public class DepthFirstSearch implements SearchStrategy {
    private Stack<Node> stack;

    public DepthFirstSearch(){
        stack = new Stack<>();
    }

    @Override
    public void add(Node node) {
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
