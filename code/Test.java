package code;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
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

//        Node node = new Node(state, null, "", 0, 0);
//        MostSeparatedColorHeuristic h = new MostSeparatedColorHeuristic();
//
//        int val = h.evaluate(node);

        // 10;4;b,p,g,p;b,o,p,r;p,o,g,p;g,o,p,y;p,y,b,o;r,c,b,c;y,r,r,g;c,b,p,b;y,b,b,c;e,e,e,e;e,e,e,e    --> optimal 41
//        String problem = "16;6;h,h,p,t,y,o;o,b,m,z,z,g;a,o,h,s,y,m;n,k,y,r,m,r;p,n,t,r,o,t;e,t,e,m,n,g;p,p,s,p,k,n;r,e,k,e,z,k;t,z,m,s,s,b;b,b,h,m,t,g;z,y,g,y,k,r;z,p,g,h,b,o;a,n,s,y,b,o;s,k,n,r,g,h;e,e,e,e,e,e;e,e,e,e,e,e;";
        // "5;4;r,b,r,g;y,g,b,y;b,y,g,r;e,e,e,e;e,e,e,e;" --> OPTIMAL 10 --> BFS OPTIMAL
        //7;4;r,g,b,y;p,o,g,r;y,b,o,p;e,e,e,e;r,p,o,b;e,e,e,e;e,e,e,e;";  // --> 12
        String problem = "10;4;b,p,g,p;b,o,p,r;p,o,g,p;g,o,p,y;p,y,b,o;r,c,b,c;y,r,r,g;c,b,p,b;y,b,b,c;e,e,e,e;e,e,e,e;";
        String solution = WaterSortSearch.solve(problem, "GR1", false);
        System.out.println(solution);




    }
}
