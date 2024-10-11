package code;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class GenericSearch {
    public abstract Object getInitialState(String problem);
    public abstract boolean isGoalState(Object state);
    public abstract List<Node> expand(Node node);
    public Node search(String problem, String strategy, Integer cutoff) throws Exception{
        Set<Object> seen = new HashSet<>();
        Object initState = getInitialState(problem);
        Node root =  new Node(initState, null, null, 0, 0);
        SearchStrategy queue = makeQueue(strategy, cutoff);
        queue.add(root);

        while(!queue.isEmpty()){
            Node currNode = queue.remove();
            Object currState = currNode.getState();

            if(isGoalState(currState))
                return currNode;

            seen.add(currState);

            for(Node child : expand(currNode)){
                if(!seen.contains(child))
                    queue.add(child);
            }
        }
        return null;
    }

    public abstract SearchStrategy makeQueue(String strategy, Integer cutoff) throws Exception;
}
