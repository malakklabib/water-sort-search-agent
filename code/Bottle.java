package code;

import java.util.Stack;

public class Bottle {
    private Stack<Character> content;
    private int bottleCapacity;

    public Bottle(int bottleCapacity){
        content = new Stack<>();
        this.bottleCapacity = bottleCapacity;
    }

    public Bottle(Stack<Character> content, int bottleCapacity){
        this.content = content;
        this.bottleCapacity = bottleCapacity;
    }

    public Character peek(){
        return content.peek();
    }

    public void push(Character c){
        content.push(c);
    }

    public Character pop() {
        return content.pop();
    }

    public boolean isEmpty(){
        return content.isEmpty();
    }

    public boolean isFull(){
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

    public Bottle clone(){
        return new Bottle((Stack<Character>) content.clone(), bottleCapacity);
    }

    public Stack<Character> getContent() {
        return content;
    }

    public int getSize() {
        return content.size();
    }

    public Character getBottomLayer(){
        return content.get(0);
    }

}
