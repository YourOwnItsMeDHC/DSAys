package Basics;

import java.util.Stack;

public class GReverseStack {
    public static void main(String[] args) {

        // using extra 2 stacks
        Stack<Integer> st1 = new Stack<>();
        st1.push(10);
        st1.push(20);
        st1.push(30);
        st1.push(40);
        st1.push(50);

        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        System.out.println("St1 : " + st1);
        System.out.println("St2 : " + st2);
        System.out.println("St3 : " + st3);
        System.out.println("=-=-=--=-=--=-====-==-==-=-=-=--=--=");

        while(st1.size() > 0) {
            st2.push(st1.pop());
        }

        System.out.println("St1 : " + st1);
        System.out.println("St2 : " + st2);
        System.out.println("St3 : " + st3);
        System.out.println("=-=-=--=-=--=-====-==-==-=-=-=--=--=");

        while(st2.size() > 0) {
            st3.push(st2.pop());
        }

        System.out.println("St1 : " + st1);
        System.out.println("St2 : " + st2);
        System.out.println("St3 : " + st3);
        System.out.println("=-=-=--=-=--=-====-==-==-=-=-=--=--=");

        while(st3.size() > 0) {
            st1.push(st3.pop());
        }

        System.out.println("St1 : " + st1);
        System.out.println("St2 : " + st2);
        System.out.println("St3 : " + st3);
        System.out.println("=-=-=--=-=--=-====-==-==-=-=-=--=--=");


/*

St1 : [10, 20, 30, 40, 50]
St2 : []
St3 : []
=-=-=--=-=--=-====-==-==-=-=-=--=--=
St1 : []
St2 : [50, 40, 30, 20, 10]
St3 : []
=-=-=--=-=--=-====-==-==-=-=-=--=--=
St1 : []
St2 : []
St3 : [10, 20, 30, 40, 50]
=-=-=--=-=--=-====-==-==-=-=-=--=--=
St1 : [50, 40, 30, 20, 10]
St2 : []
St3 : []
=-=-=--=-=--=-====-==-==-=-=-=--=--=

 */


        System.out.println("Before Reverse - st1 : " + st1);    // Before Reverse - st1 : [50, 40, 30, 20, 10]
        reverse(st1);
        System.out.println("After Reverse - st1 : " + st1);     // After Reverse - st1 : [10, 20, 30, 40, 50]
    }

    public static void reverse(Stack<Integer> st) {
        // If there is only one element in the stack, then reverse of that one element,
        // will be that particular one element only, hence, just simply return, at these point
        if(st.size() == 1) {
            return;
        }

        int top = st.pop();

        reverse(st);

        // If I will be simply pushing "top" element onto the stack, in return,
        // I will be getting elements wit that same order of elements only.
        // Hence, I will be pushing it from bottom, So, I will be getting reverse of the stack
        pushAtBottom(st, top);
    }

    public static void pushAtBottom(Stack<Integer> st, int ele) {
        if(st.size() == 0) {
            st.push(ele);
            return;
        }
        int top = st.pop();
        pushAtBottom(st, ele);
        st.push(top);
    }
}
