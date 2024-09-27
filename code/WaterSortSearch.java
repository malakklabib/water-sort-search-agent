package code;

import java.util.*;

public class WaterSortSearch extends GenericSearch {
    public static String solve(String initialState, String strategy, boolean visualize) throws Exception {
        WaterSortSearch waterSortSearch = new WaterSortSearch();
        Node goalNode = waterSortSearch.search(initialState, strategy);
        // backtrack using goalNode and save operands to a string plan,
        // sum up total cost and save to pathCost,
        // count num of nodes expanded during search and save to nodesExpanded
        return null;
    }

    @Override
    public List<Stack<Character>> getInitialState(String problem) {
        String[] params = problem.split(";");
        int numBottles = Integer.parseInt(params[0]);
        int bottleCapacity = Integer.parseInt(params[1]);

        List<Stack<Character>> bottles = new ArrayList<>();
        for(int i = 2; i < numBottles+2; i++){
            String[] colors = params[i].split(",");
            Stack<Character> bottle = new Stack<>();
            for(int j = bottleCapacity-1; j >= 0; j--){
                char color = colors[j].charAt(0);
                bottle.push(color);
            }
            bottles.add(bottle);
        }
        return bottles;
    }

    @Override
    public boolean isGoalState(Object state) {
        return false;
    }
    @Override
    public List<Node> expand(Node node) {
        return null;
    }

    @Override
    public Node search(String problem, String strategy) throws Exception {
        List<Stack<Character>> initState = getInitialState(problem);
        Node root =  new Node(initState, null, null, 0, 0);
        return switch (strategy) {
            case "BF" -> bfs(root);
            case "DF" -> dfs(root);
            case "ID" -> ids(root);
            case "UC" -> ucs(root);
            case "GR1", "GR2" -> greedy(root, Character.getNumericValue(strategy.charAt(2)));
            case "AS1", "AS2" -> as(root, Character.getNumericValue(strategy.charAt(2)));
            default -> throw new Exception("Undefined strategy type.");
        };
    }

    public Node bfs(Node root){
        return null;
    }

    public Node dfs(Node root){
        return null;
    }

    public Node ids(Node root){
        return null;
    }

    public Node ucs(Node root){
        return null;
    }

    public Node greedy(Node root, int heuristic){
        return null;
    }

    public Node as(Node root, int heuristic){
        return null;
    }
}
