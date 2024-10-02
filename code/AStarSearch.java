package code;

import java.util.PriorityQueue;

public class AStarSearch implements SearchStrategy {
    PriorityQueue<Node> pq;

    public AStarSearch(int heuristic){
        if(heuristic==1){

        }
        else{

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
