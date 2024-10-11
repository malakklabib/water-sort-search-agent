package code;

import java.util.*;
import java.util.stream.Collectors;

public class WaterSortSearch extends GenericSearch {

    public static String solve(String initialState, String strategy, boolean visualize) throws Exception {
        WaterSortSearch waterSortSearch = new WaterSortSearch();
        DepthLimitedSearch.setCutoff(-1);
        Node.setMaxDepth(0);

        Node goalNode;
        goalNode = waterSortSearch.search(initialState, strategy);

        if(goalNode == null)
            return "NOSOLUTION";

        List<String> actions = new ArrayList<>();
        getPlan(actions, goalNode);

        String plan = String.join(",", actions);
        String pathCost = String.valueOf(goalNode.getPathCost());
        String expandedNodes = String.valueOf(waterSortSearch.getExpandedNodes());

        return plan + ";" + pathCost + ";" + expandedNodes;
    }

    private static void getPlan(List<String> actions, Node node){
        if(node.getParent()==null)
            return;

        actions.add(0, node.getAction());
        getPlan(actions, node.getParent());
    }

    @Override
    public List<Bottle> getInitialState(String problem) {
        String[] params = problem.split(";");
        int numBottles = Integer.parseInt(params[0]);
        int bottleCapacity = Integer.parseInt(params[1]);

        List<Bottle> bottles = new ArrayList<>();
        for (int i = 2; i < numBottles + 2; i++) {
            String[] colors = params[i].split(",");
            Bottle bottle = new Bottle(bottleCapacity);
            for (int j = bottleCapacity - 1; j >= 0; j--) {
                char color = colors[j].charAt(0);
                if(color!='e')
                    bottle.push(color);
            }
            bottles.add(bottle);
        }
        return bottles;
    }

    @Override
    public boolean isGoalState(Object state) {
        List<Bottle> currState = (List<Bottle>) state;
        for (Bottle bottle : currState) {
            if (!bottle.isEmpty() && !bottle.containsSameColor())
                return false;
        }
        return true;
    }

    @Override
    public List<Node> expand(Node node) {
        List<Bottle> currState = (List<Bottle>) node.getState();
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < currState.size(); i++) {
            if (currState.get(i).isEmpty())
                continue;

            for (int j = 0; j < currState.size(); j++) {
                if(j == i || currState.get(j).isFull())
                    continue;

                int layersPoured = 0;
                List<Bottle> newState = currState.stream().map(Bottle::clone).collect(Collectors.toList());
                Bottle iBottle = newState.get(i), jBottle = newState.get(j);
                while (!iBottle.isEmpty() && (jBottle.isEmpty() || jBottle.peek().equals(iBottle.peek()))) {
                    Character color = iBottle.pop();
                    jBottle.push(color);
                    layersPoured++;
                }

                if (layersPoured > 0) {
                    String action = "pour_" + i + "_" + j;
                    int newDepth = node.getDepth() + 1;
                    int newCost = node.getPathCost() + layersPoured;
                    Node child = new Node(newState, node, action, newDepth, newCost);
                    children.add(child);
                }
            }
        }
        return children;
    }

    @Override
    public SearchStrategy makeQueue(String strategy) throws Exception {
        return switch (strategy) {
            case "BF" -> new BreadthFirstSearch();
            case "DF" -> new DepthFirstSearch();
            case "ID" -> new DepthLimitedSearch();
            case "UC" -> new UniformCostSearch();
            case "GR1", "GR2" -> new GreedySearch(Character.getNumericValue(strategy.charAt(2)));
            case "AS1", "AS2" -> new AStarSearch(Character.getNumericValue(strategy.charAt(2)));
            default -> throw new Exception("Undefined strategy type.");
        };
    }
}
