package code;

import java.util.*;

public class WaterSortSearch extends GenericSearch {
    private int bottleCapacity;

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
    public List<Stack<Character>> getInitialState(String problem) {
        String[] params = problem.split(";");
        int numBottles = Integer.parseInt(params[0]);
        bottleCapacity = Integer.parseInt(params[1]);

        List<Stack<Character>> bottles = new ArrayList<>();
        for (int i = 2; i < numBottles + 2; i++) {
            String[] colors = params[i].split(",");
            Stack<Character> bottle = new Stack<>();
            for (int j = bottleCapacity - 1; j >= 0; j--) {
                char color = colors[j].charAt(0);
                push(bottle, color);
            }
            bottles.add(bottle);
        }
        return bottles;
    }

    @Override
    public boolean isGoalState(Object state) {
        List<Stack<Character>> currState = (List<Stack<Character>>) state;
        for (Stack<Character> bottle : currState) {
            if (!isEmpty(bottle) && !containsSameColor(bottle))
                return false;
        }
        return true;
    }

    private boolean containsSameColor(Stack<Character> bottle) {
        Character color = peek(bottle);
        for (Character c : bottle) {
            if (!color.equals(c))
                return false;
        }
        return true;
    }

    public boolean isEmpty(Stack<Character> bottle){
        return (bottle.get(0) == 'e');
    }

    public Character peek(Stack<Character> bottle){
        int nonEmptyLayers = getNonEmptyLayers(bottle);
        return bottle.get(nonEmptyLayers - 1);
    }

    public Character pop(Stack<Character> bottle){
        int nonEmptyLayers = getNonEmptyLayers(bottle);
        return bottle.set(nonEmptyLayers - 1,'e');
    }

    public void push(Stack<Character> bottle, Character color){
        int nonEmptyLayers = getNonEmptyLayers(bottle);
        bottle.set(nonEmptyLayers,color);
    }

    public int getNonEmptyLayers(Stack<Character> bottle){
        int nonEmptyLayers = 0;  // Number of non-empty layers in the bottle

        for (Character layer : bottle) {
            if (layer == 'e') break;    // All layers following an empty layer are also empty and require no processing.
            nonEmptyLayers++;
        }

        return nonEmptyLayers;
    }

    @Override
    public List<Node> expand(Node node) {
        List<Stack<Character>> currState = (List<Stack<Character>>) node.getState();
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < currState.size(); i++) {
            if (isEmpty(currState.get(i)))
                continue;

            for (int j = 0; j < currState.size(); j++) {
                if(j == i)
                    continue;
                int nonEmptyLayers = getNonEmptyLayers(currState.get(j));
                if (nonEmptyLayers == bottleCapacity)
                    continue;

                int layersPoured = 0;
                List<Stack<Character>> newState = copyState(currState);
                Stack<Character> iBottle = newState.get(i), jBottle = newState.get(j);
                while (!isEmpty(iBottle) && (isEmpty(jBottle) || peek(jBottle).equals(peek(iBottle)))) {
                    Character color = pop(newState.get(i));
                    push(newState.get(i), 'e');
                    push(newState.get(i), color);
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

    private List<Stack<Character>> copyState(List<Stack<Character>> state) {
        List<Stack<Character>> newState = new Stack<>();

        for (Stack<Character> bottle : state)
            newState.add((Stack<Character>) bottle.clone());

        return newState;
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
