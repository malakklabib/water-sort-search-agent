package code;

import java.util.*;

public class WaterSortSearch extends GenericSearch {
    private int bottleCapacity;

    public static String solve(String initialState, String strategy, boolean visualize) throws Exception {
        WaterSortSearch waterSortSearch = new WaterSortSearch();
        Node goalNode;
        if (strategy.equals("ID")) {
            int depth = 0;
            while (true) {
                goalNode = waterSortSearch.search(initialState, strategy, depth);
                if (goalNode != null)
                    break;
                depth++;
            }
        } else {
            goalNode = waterSortSearch.search(initialState, strategy, null);
        }
        // backtrack using goalNode and save operands to a string plan,
        // sum up total cost and save to pathCost,
        // count num of nodes expanded during search and save to nodesExpanded
        return null;
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
                bottle.push(color);
            }
            bottles.add(bottle);
        }
        return bottles;
    }

    @Override
    public boolean isGoalState(Object state) {
        List<Stack<Character>> currState = (List<Stack<Character>>) state;
        for (Stack<Character> bottle : currState) {
            if (!bottle.isEmpty() && !containsSameColor(bottle))
                return false;
        }
        return true;
    }

    private boolean containsSameColor(Stack<Character> bottle) {
        Character color = bottle.peek();
        for (Character c : bottle) {
            if (!color.equals(c))
                return false;
        }
        return true;
    }

    @Override
    public List<Node> expand(Node node) {
        List<Stack<Character>> currState = (List<Stack<Character>>) node.getState();
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < currState.size(); i++) {
            if (currState.get(i).isEmpty())
                continue;

            for (int j = 0; j != i && j < currState.size(); j++) {
                if (currState.get(j).size() == bottleCapacity)
                    continue;

                int layersPoured = 0;
                List<Stack<Character>> newState = copyState(currState);
                Stack<Character> iBottle = newState.get(i), jBottle = newState.get(j);
                while (!iBottle.isEmpty() && (jBottle.isEmpty() || jBottle.peek().equals(iBottle.peek()))) {
                    Character color = newState.get(i).pop();
                    newState.get(j).push(color);
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
    public SearchStrategy makeQueue(String strategy, Integer cutoff) throws Exception {
        return switch (strategy) {
            case "BF" -> new BreadthFirstSearch();
            case "DF" -> new DepthFirstSearch();
            case "ID" -> new DepthLimitedSearch(cutoff);
            case "UC" -> new UniformCostSearch();
            case "GR1", "GR2" -> new GreedySearch(Character.getNumericValue(strategy.charAt(2)));
            case "AS1", "AS2" -> new AStarSearch(Character.getNumericValue(strategy.charAt(2)));
            default -> throw new Exception("Undefined strategy type.");
        };
    }
}
