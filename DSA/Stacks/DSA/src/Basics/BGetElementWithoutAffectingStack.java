package Basics;

import java.util.Stack;

public class BGetElementWithoutAffectingStack {
    public static void main(String[] args) {
        //Get nth element, but I want my stack as it is
        Stack<Integer> st1 = new Stack<>();
        st1.push(10);
        st1.push(20);
        st1.push(30);
        st1.push(40);
        st1.push(50);
        System.out.println(st1);                     //[10, 20, 30, 40, 50]

        Stack<Integer> st2 = new Stack<>();
        System.out.println(st2);                     //[]

        // Element which are at 3rd position
        while(st1.size() > 3) {
            st2.push(st1.pop());
        }

        System.out.println(st1.peek());          //30
        System.out.println(st1);                 //[10, 20, 30]  - Affected stack

        System.out.println(st2);                 //[50, 40]      - Elements which were removed during operation

        //Pushing popped element again back to our st1
        while(st2.size() > 0) {
            st1.push(st2.pop());
        }

        System.out.println(st1);                     //[10, 20, 30, 40, 50]
    }
}




/*

[10, 20, 30, 40, 50]
[]
30
[10, 20, 30]
[50, 40]
[10, 20, 30, 40, 50]

 */
