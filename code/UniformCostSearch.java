package code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UniformCostSearch implements SearchStrategy {
    private PriorityQueue<Node> pq;

    public UniformCostSearch(){
        pq = new PriorityQueue<>(Comparator.comparingInt(Node::getPathCost));
    }

    @Override
    public void add(Node node) {
        pq.add(node);
    }

    @Override
    public Node remove() {
        return pq.remove();
    }

    @Override
    public boolean isEmpty() {
        return pq.isEmpty();
    }
}
