package code;

import java.util.List;

public abstract class GenericSearch {
    public abstract Object getInitialState(String problem);
    public abstract boolean isGoalState(Object state);
    public abstract List<Node> expand(Node node);
    public abstract Node search(String problem, String strategy) throws Exception; //returns goal node
}
