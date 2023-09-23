// Notes : https://www.interviewkickstart.com/learn/how-to-reverse-a-stack-using-recursion

package Basics;
import java.util.Stack;
public class DDisplayStackRecursively {
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        st1.push(10);
        st1.push(20);
        st1.push(30);
        st1.push(40);
        st1.push(50);
        System.out.println(st1);                     //[10, 20, 30, 40, 50

        displayReverseRecur(st1);                    // 50 40 30 20 10

        System.out.println("Now st1 is : " + st1);   //Now st1 is : [10, 20, 30, 40, 50]

        displayRecur(st1);                           // 10 20 30 40 50

        System.out.println("Now st1 is : " + st1);   //Now st1 is : [10, 20, 30, 40, 50]
    }


    public static void displayReverseRecur(Stack<Integer> st) {
        if(st.size() == 0) {
            return;
        }

        int top = st.pop();
        System.out.print(top + " ");

        displayReverseRecur(st);

        st.push(top);
    }


    public static void displayRecur(Stack<Integer> st) {
        if(st.size() == 0) {
            return;
        }

        int top = st.pop();
        displayRecur(st);
        System.out.print(top + " ");
    }
}


/*
Solution Steps:

1. Create a recursive function called rec to reverse the input stack.
2. In recursion, pop the top element of the stack and hold it in the recursive function call stack until the
   input stack is empty.
3. While going back in the recursion, push the held element in the recursion call stack at the bottom of the
   input stack.
 */
