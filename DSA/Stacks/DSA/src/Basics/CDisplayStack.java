package Basics;

import java.util.Stack;

public class CDisplayStack {
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        st1.push(10);
        st1.push(20);
        st1.push(30);
        st1.push(40);
        st1.push(50);
        System.out.println(st1);                     //[10, 20, 30, 40, 50

//        There are 2 methods to display a stack
//        1. Using another stack
//        2. Using an array


        //        1. Using another stack
        Stack<Integer> st2 = new Stack<>();

        // Putting all the elements onto the st2 stack
        while(st1.size() > 0) {
            st2.push(st1.pop());
        }

        //Taking out each element from st2 stack, displaying it, putting it back onto the st1
        while(st2.size() > 0) {
            System.out.print(st2.peek() + " ");          // 10 20 30 40 50
            st1.push(st2.pop());
        }



        //        2. Using an array

//        Here, we are storing the size of st1 stack into a variable, because each time, when we will pop
//        element from the stack, size of st1 stack will get decrease, which will affect the for loop
//        Hence, instead of giving st1.size() in the for loop, we will be using that variable, which is holding st1 stack's size
        int n = st1.size();
        int[] nums = new int[n];

        for(int i=n-1; i>=0; i--) {
            nums[i] = st1.pop();
        }

        for(int i=0; i<n; i++) {
            System.out.print(nums[i] + " ");          // 10 20 30 40 50
            st1.push(nums[i]);
        }

        System.out.println(st1);
    }
}
