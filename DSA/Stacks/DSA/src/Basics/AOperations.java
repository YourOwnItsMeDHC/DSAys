package Basics;

import java.util.Stack;

public class AOperations {
    public static void main(String[] args) {
        System.out.println("Hey everyone your own it's me Deepak");

        Stack<Integer> st = new Stack<>();

        System.out.println(st.isEmpty());     //true

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println(st);            //[10, 20, 30, 40, 50]

        // It won't delete top element, it will just return or display that top element
        System.out.println(st.peek());     //50

        System.out.println(st);            //[10, 20, 30, 40, 50]

//        st.pop();

        System.out.println(st);            //[10, 20, 30, 40]

        System.out.println("Size is : " + st.size());     //Size is : 4


        st.push(60);
        st.push(70);
        st.push(80);
        st.push(90);
        st.push(100);

        System.out.println(st);   //[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]






        //Get element from a particular index
        //Assume, index starts from 1
        //Run a while loop until size of the stack is greater than that particular index
        //When while loop will terminate, our element will be at the top
        //Here, I just want to know that top element, I don't want to do any operation with it
        //Hence, I would be doing st.peek() here
        while(st.size() > 6) {
            st.pop();
        }
        System.out.println(st.peek());   //60

        //Problem with these, is, that, size is getting change in real
        //Here, we won't be able to get that stack elements, which was there in the stack, before we did that
        // pop operation in our st stack, because we did pop it
        System.out.println(st);           //[10, 20, 30, 40, 50, 60]


        System.out.println(st.isEmpty());     //false





        //Get nth element, but I want my stack as it iss
        Stack<Integer> st1 = new Stack<>();
        st1.push(10);
        st1.push(20);
        st1.push(30);
        st1.push(40);
        st1.push(50);
        System.out.println(st1);                     //[10, 20, 30, 40, 50]

        Stack<Integer> st2 = new Stack<>();
        System.out.println(st2);                     //[]


        while(st1.size() > 3) {
            st2.push(st1.pop());
        }

        System.out.println(st1.peek());              //30
        System.out.println(st1);                     //[10, 20, 30]      - Affected stack

        System.out.println(st2);                     //[50, 40]          - Elements which were removed during operation

        //Pushing popped element again back to our st1
        while(st2.size() > 0) {
            st1.push(st2.pop());
        }

        System.out.println(st1);                     //[10, 20, 30, 40, 50]
    }
}
