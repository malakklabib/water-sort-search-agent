package code;

import java.util.*;
public class dummy {

    public static void main(String[] args) {
        Stack<Character> b1 = new Stack<Character>();
        Stack<Character> b2 = new Stack<Character>();
        Stack<Character> b3 = new Stack<Character>();
        Stack<Character> b4 = new Stack<Character>();

        b1.push('a');
        b1.push('b');
        b4.push('a');
        b4.push('b');

        b2.push('c');
        b2.push('d');
        b3.push('c');
        b3.push('d');

        HashSet<Stack<Character>> h1 = new HashSet<>();
        HashSet<Stack<Character>> h2 = new HashSet<>();

        h1.add(b1);
        h1.add(b2);

        h2.add(b3);
        h2.add(b4);

        HashSet<HashSet<Stack<Character>>> seen = new HashSet<>();
        seen.add(h1);

        System.out.println(seen.contains(h2));

//        Bottle b1 = new Bottle(2);
//        Bottle b2 = new Bottle(2);
//        Bottle b3 = new Bottle(2);
//        Bottle b4 = new Bottle(2);
//
//        b1.push('a');
//        b1.push('b');
//        b4.push('a');
//        b4.push('b');
//
//        b2.push('c');
//        b2.push('d');
//        b3.push('c');
//        b3.push('d');
//
//        List<Bottle> currState1 = new ArrayList<>();
//        List<Bottle> currState2 = new ArrayList<>();
//
//        currState1.add(b1);
//        currState1.add(b2);
//
//        currState2.add(b4);
//        currState2.add(b3);
//
//        HashSet<List<Bottle>> seen = new HashSet<>();
//
//        seen.add(currState1);
//
//        System.out.println(seen.contains(currState2));


    }
}
