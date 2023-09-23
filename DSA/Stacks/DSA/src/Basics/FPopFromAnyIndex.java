package Basics;

import java.util.Stack;

public class FPopFromAnyIndex {
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        st1.push(10);
        st1.push(20);
        st1.push(30);
        st1.push(40);
        st1.push(50);

        System.out.println(st1);            //[10, 20, 30, 40, 50]

        // Pop from bottom
        Stack<Integer> st2 = new Stack<>();

//        To delete form bottom, there should be at least 1 element, hence, st1.size() > 1, then pop that one element
        while(st1.size() > 1) {
            st2.push(st1.pop());
        }
        st1.pop();

        while(st2.size() > 0) {
            st1.push(st2.pop());
        }

        System.out.println(st1);         // [20, 30, 40, 50]
//                                            0   1   2   3



        // Pop from index 2
//        To delete from index 2 i.e. 0 1 2 ==> i.e. we have to delete 3rd element,
//        which means there should be that 3rd element, hence, st1.size() > 3
        while(st1.size() > 3) {
            st2.push(st1.pop());
        }
        st1.pop();

        while(st2.size() > 0) {
            st1.push(st2.pop());
        }

        System.out.println(st1);       // [20, 30, 50]
//                                          0   1   2

        popRecur(st1, 1);

        System.out.println(st1);       // // [20, 50]
    }





    public static void popRecur(Stack<Integer> st, int index) {
        // st.size() == index+1 , because, if index is 0 i.e. bottom, then to delete from bottom, in the stack
        // there should be atleast one element, which means stack size should be, atleast 1
        //Hence, edge case ==> Index : 0 ==> Index+1 = 0+1 = 1 ==> Stack size
        if(st.size() == index+1) {
            st.pop();
            return;
        }

        int top = st.pop();
        popRecur(st, index);

        // When our element has got popped out, then we will start pushing our rest of the popped element
        st.push(top);
    }
}
