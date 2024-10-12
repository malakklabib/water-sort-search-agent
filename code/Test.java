package code;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Bottle> state = new ArrayList<>();

        /*
//        Example 1
//        ---------
//
//        e   b   e   e
//        g   r   b   e
//        r   g   r   e
//        r   g   b   r


        Bottle b0 = new Bottle(4);
        Bottle b1 = new Bottle(4);
        Bottle b2 = new Bottle(4);
        Bottle b3 = new Bottle(4);

        b0.push('r');
        b0.push('r');
        b0.push('g');

        b1.push('g');
        b1.push('g');
        b1.push('r');
        b1.push('b');

        b2.push('b');
        b2.push('r');
        b2.push('b');

        b3.push('r');

        state.add(b0);
        state.add(b1);
        state.add(b2);
        state.add(b3);

         */


        /*

//        Example 2
//        ---------
//        e   e   e   e
//        e   r   e   e
//        r   g   r   e
//        r   g   b   r

        Bottle b0 = new Bottle(4);
        Bottle b1 = new Bottle(4);
        Bottle b2 = new Bottle(4);
        Bottle b3 = new Bottle(4);

        b0.push('r');
        b0.push('r');

        b1.push('g');
        b1.push('g');
        b1.push('r');

        b2.push('b');
        b2.push('r');

        b3.push('r');

        state.add(b0);
        state.add(b1);
        state.add(b2);
        state.add(b3);

         */


        /*

//        Example 3
//        ---------
//        e   e   e   e
//        e   e   e   e
//        r   e   e   e
//        r   r   g   b

        Bottle b0 = new Bottle(4);
        Bottle b1 = new Bottle(4);
        Bottle b2 = new Bottle(4);
        Bottle b3 = new Bottle(4);

        b0.push('r');
        b0.push('r');

        b1.push('r');

        b2.push('g');

        b3.push('b');

        state.add(b0);
        state.add(b1);
        state.add(b2);
        state.add(b3);

         */

        /*

//        Example 4
//        ---------
//        r   b   g   y
//        r   b   g   y
//        r   b   g   y
//        r   b   g   y

        Bottle b0 = new Bottle(4);
        Bottle b1 = new Bottle(4);
        Bottle b2 = new Bottle(4);
        Bottle b3 = new Bottle(4);

        b0.push('r');
        b0.push('r');
        b0.push('r');
        b0.push('r');

        b1.push('b');
        b1.push('b');
        b1.push('b');
        b1.push('b');

        b2.push('g');
        b2.push('g');
        b2.push('g');
        b2.push('g');

        b3.push('y');
        b3.push('y');
        b3.push('y');
        b3.push('y');

        state.add(b0);
        state.add(b1);
        state.add(b2);
        state.add(b3);

         */

        Node node = new Node(state, null, "", 0, 0);
        MostSeparatedColorHeuristic h = new MostSeparatedColorHeuristic();

        int val = h.evaluate(node);
    }
}
