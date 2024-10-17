package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Bottle {
    private Stack<Character> content;
    private int bottleCapacity;

    static int globalId = 0;
    int id;

    public Bottle(int bottleCapacity) {
        content = new Stack<>();
        this.bottleCapacity = bottleCapacity;
        this.id = globalId;
        globalId++;
    }

    public Bottle(Stack<Character> content, int bottleCapacity, int id) {
        this.content = content;
        this.bottleCapacity = bottleCapacity;
        this.id = id;
    }

    public Character peek() {
        return content.peek();
    }

    public void push(Character c) {
        content.push(c);
    }

    public Character pop() {
        return content.pop();
    }

    public boolean isEmpty() {
        return content.isEmpty();
    }

    public boolean isFull() {
        return bottleCapacity == content.size();
    }

    public static int getGlobalId() {
        return globalId;
    }

    public static void setGlobalId(int globalId) {
        Bottle.globalId = globalId;
    }
    
    public boolean containsSameColor() {
        Character color = peek();
        for (Character c : content) {
            if (!color.equals(c))
                return false;
        }
        return true;
    }

    public Bottle clone() {
        return new Bottle((Stack<Character>) content.clone(), bottleCapacity, this.id);
    }

    public Stack<Character> getContent() {
        return content;
    }

    public int getSize() {
        return content.size();
    }

    public Character getBottomLayer() {
        return content.get(0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bottle bottle = (Bottle) obj;
        return bottleCapacity == bottle.bottleCapacity && content.equals(bottle.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottleCapacity, content);
    }

//    top = 1
//    2 per layer - 1
//    bottom 1
//    id 1

    public String[] toStringArray() {
        String[] bottleRows = new String[bottleCapacity * 2 + 2]; // Each row includes the bottle frame, content, and id

        int index = 0;
        bottleRows[index++] = "╔═══╗"; // Top of the bottle

        for (int i = 0; i < bottleCapacity - content.size(); i++) {
            bottleRows[index++] = "║   ║"; // Empty layer
            if (i < bottleCapacity - 1)
                bottleRows[index++] = "╟───╢"; // Horizontal break
        }

        for (int i = content.size() - 1; i >= 0; i--) { // Filled part of the bottle
            bottleRows[index++] = "║ " + content.get(i) + " ║";
            if (i > 0)
                bottleRows[index++] = "╟───╢"; // Horizontal break
        }

        bottleRows[index++] = "╚═══╝"; // Bottom of the bottle
        bottleRows[index] = String.format("  %s  ", id); // Bottle ID

        return bottleRows; // Return array of strings representing the bottle
    }

//    public ArrayList<String> toStringArray() {
//        ArrayList<String> bottleRows = new ArrayList<String>(); // Each row includes the bottle frame, content, and id
//
//        bottleRows.add("╔═══╗"); // Top of the bottle
//
//        for (int i = 0; i < bottleCapacity - content.size(); i++) {
//            bottleRows.add("║   ║"); // Empty layer
//            if (i < bottleCapacity - 1)
//                bottleRows.add("╟───╢"); // Horizontal break
//        }
//
//        for (int i = content.size() - 1; i >= 0; i--) { // Filled part of the bottle
//            bottleRows.add("║ " + content.get(i) + " ║");
//            if (i > 0)
//                bottleRows.add("╟───╢"); // Horizontal break
//        }
//
//        bottleRows.add("╚═══╝"); // Bottom of the bottle
//        bottleRows.add(String.format("  %s  ", id)); // Bottle ID
//
//        return bottleRows; // Return array of strings representing the bottle
//    }

}
