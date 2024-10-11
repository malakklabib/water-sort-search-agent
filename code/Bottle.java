package code;

import java.util.ArrayList;
public class Bottle {
    private ArrayList<Character> content;
    private int top = -1;

    public Bottle(){
        content = new ArrayList<>();
    }
    public Bottle(ArrayList<Character> content){
        this.content = content;
    }

    public Character peek(){
        if(top == -1)
            return 'e';

        return content.get(top);
    }

    public void push(Character c){
        if(c == 'e')
            content.add('e');
        else {
            top++;
            content.set(top, c);
        }
    }

    public Character pop(){
        Character c = peek();
        content.set(top, 'e');
        top--;
        return c;
    }

    public boolean isEmpty(){
        return peek() == 'e';
    }

    public boolean isFull(){
        return top+1 == content.size();
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
        ArrayList<Character> newContent = (ArrayList<Character>) content.clone();
        return new Bottle(newContent);
    }

    public ArrayList<Character> getContent() {
        return content;
    }

    public int getSize() {
        return top + 1;
    }

    public Character getBottomLayer(){
        return content.get(0);
    }

}
