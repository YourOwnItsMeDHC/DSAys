package Basics;

import java.util.Stack;

public class EPushAtAnyIndex {
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        st1.push(10);
        st1.push(20);
        st1.push(30);
        st1.push(40);
        st1.push(50);

        System.out.println(st1);            //[10, 20, 30, 40, 50]

        // Push at bottom
        Stack<Integer> st2 = new Stack<>();

        while(st1.size() > 0) {
            st2.push(st1.pop());
        }
        st1.push(56);               // Pushing element 56 at bottom

        while(st2.size() > 0) {
            st1.push(st2.pop());
        }

        System.out.println(st1);         // [56, 10, 20, 30, 40, 50]



        // Push at index 3 i.e. push 85 and move 40 ahead
        while(st1.size() > 3) {
            st2.push(st1.pop());
        }
        st1.push(85);

        while(st2.size() > 0) {
            st1.push(st2.pop());
        }

        System.out.println(st1);         // [56, 10, 20, 85, 30, 40, 50]
                                         //   0   1   2   3   4  5    6



        pushRecur(st1, 5, 999);     // [56, 10, 20, 85, 30, 999, 40, 50]

        System.out.println(st1);
    }








    public static void pushRecur(Stack<Integer> st, int index, int element) {
        if(st.size() == index) {
            //Here, now there is no need to pop, simply push element
            st.push(element);
            return;
        }

        int top = st.pop();
        pushRecur(st, index, element);

        // When our element has got pushed in appropriate index, then we will start pushing our popped element
        st.push(top);
    }
}
