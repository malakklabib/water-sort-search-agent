package code;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch implements SearchStrategy {
    private Queue<Node> queue;
    public BreadthFirstSearch(){
        queue = new LinkedList<>();
    }
    @Override
    public void add(Node node) {
        queue.add(node);
    }

    @Override
    public Node remove() {
        return queue.remove();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
