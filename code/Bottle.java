package code;

import java.util.Objects;
import java.util.Stack;

public class Bottle {
    private Stack<Character> content;
    private int bottleCapacity;

    public Bottle(int bottleCapacity) {
        content = new Stack<>();
        this.bottleCapacity = bottleCapacity;
    }

    public Bottle(Stack<Character> content, int bottleCapacity) {
        this.content = content;
        this.bottleCapacity = bottleCapacity;
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

    public boolean containsSameColor() {
        Character color = peek();
        for (Character c : content) {
            if (!color.equals(c))
                return false;
        }
        return true;
    }

    public Bottle clone() {
        return new Bottle((Stack<Character>) content.clone(), bottleCapacity);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔═══════╗\n"); // Top of the bottle

        for (int i = content.size() - 1; i >= 0; i--) { // Reverse to show top of the bottle at the top
            sb.append("║   ").append(content.get(i)).append("   ║\n"); // Add each color inside the bottle
        }

        // Add empty spaces for unfilled parts of the bottle (assume max height is 4 for this example)
        for (int i = 0; i < 4 - content.size(); i++) {
            sb.append("║       ║\n");
        }

        sb.append("╚═══════╝"); // Bottom of the bottle
        return sb.toString();
    }

}
