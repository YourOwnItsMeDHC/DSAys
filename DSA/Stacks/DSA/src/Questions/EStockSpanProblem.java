/*
Question : https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

Article [Must See] : https://www.prepbytes.com/blog/stacks/the-stock-span-problem/
 */

package Questions;
import java.util.Arrays;
import java.util.Stack;

public class EStockSpanProblem {
    public static void main(String[] args) {
        int[] arr1 = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Array : " + Arrays.toString(arr1));
        System.out.println("Previous Greater Element : " + Arrays.toString(pge(arr1)));
        System.out.println("Stock Span : " + Arrays.toString(stockSpan(arr1)));

        int[] arr2 = {10, 4, 5, 90, 120, 80};
        System.out.println("Array : " + Arrays.toString(arr2));
        System.out.println("Previous Greater Element : " + Arrays.toString(stockSpan(arr2)));
    }

    /*

    Array : [100, 80, 60, 70, 60, 75, 85]
    Previous Greater Element : [-1, 100, 80, 80, 70, 80, 100]
    Stock Span : [1, 1, 1, 2, 1, 4, 6]
    Array : [10, 4, 5, 90, 120, 80]
    Previous Greater Element : [1, 1, 2, 4, 5, 1]
     */







    public static int[] pge(int[] nums) {
        Stack<Integer> st = new Stack<Integer>();
        int[] res = new int[nums.length];

        res[0] = -1;
        st.push(nums[0]);

        for(int i=1; i<nums.length; i++) {
            while(st.size() > 0 && st.peek() < nums[i]) {
                st.pop();
            }
            if(st.size() == 0) {
                res[i] = -1;
            }
            else {
                res[i] = st.peek();
            }

            st.push(nums[i]);
        }
        return res;
    }




    /*
    Instead of pushing PGE, I will be pushing index of that element
    So, I can compare span of the stock i.e number of days, current stock has been the greatest,
    which will be basically current stock's index - PGE's index

    So, here onto the stack I will be maintaining indices and not value
    Because, I want number of days, which I could get from these indices only.
    Or, if I could push bothe i.e value along with their index using "Pair class"
    Pair class : https://www.geeksforgeeks.org/pair-class-in-java/
     */
    public static int[] stockSpan(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];

        res[0] = 1;
        st.push(0);

        for(int i=1; i<nums.length; i++) {
            while (st.size() > 0 && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = i+1;
            } else {
                res[i] = i - st.peek();
            }
            st.push(i);
        }
        return res;
    }

}


/*

import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static int[] getStockSpan(int price[], int n){

        // Initialize an empty stack.
        // This stack will be used to store the indexes.
        Stack<Integer> st = new Stack<>();

        // 'span' array will store the final answer.
        int span[] = new int[n];

        // Add index of first price to the stack.
        st.push(0);

        // Set 'span[0]' as 1 because there is no price to its left.
        span[0] = 1;

        // Iterate over the `price` array to find the span of each price.
        for(int i = 1;i<n;i++){

            // Find the next greater price to the left.
            while(!st.isEmpty() && price[st.peek()] <= price[i]){
                st.pop();
            }

            // Case 1: If there is no greater price to the left, it means the current price is the greatest so far.
            if(st.isEmpty()){
                span[i] = i + 1;
            }

            // Case 2: Else find the number of consecutive days from the current day to the day which has the next greater price.
            else{
                span[i] = i - st.peek();
            }

            // Push the index of the current price to the stack.
            st.push(i);
        }

        // Return the span array.
        return span;
    }

    public static void main(String[] args) {
        int price[] = new int[]{90, 40, 20, 30, 80, 60, 100};
        int span[] = getStockSpan(price, price.length);
        for(int s : span){
            System.out.print(s+" ");
        }
    }
}

 */
