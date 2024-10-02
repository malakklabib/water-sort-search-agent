package code;

import java.util.PriorityQueue;

public class GreedySearch implements SearchStrategy {
    PriorityQueue<Node> pq;

    public GreedySearch(int heuristic){
        if(heuristic==1){
            //implement comparable
        }
        else{
            //implement another type of comparable
        }
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
