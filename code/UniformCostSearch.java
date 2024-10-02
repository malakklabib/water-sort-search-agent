package code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UniformCostSearch implements SearchStrategy {
    private PriorityQueue<Node> pq;

    public UniformCostSearch(){
        pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getPathCost() - o2.getPathCost();
            }
        });
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
