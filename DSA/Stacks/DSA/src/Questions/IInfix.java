/*
Input  : "9+5-6*4/6"    (Expression as a string)
Output :  10

Solution :
We will create 2 stacks - One for values(operands), and another one for operators

Iterating over string expression
----- If number encountered, Simply push it onto val stack
----- If operator encountered
      ----- Check whether op stack is empty
            ----- YES ==> Push that operator, irrespective of it's precedence or priority
            ----- NO  ===> Check whether top operator in the op stack has equal or greater priority
                           than my current operator which I did encounter while traversing the string
                           ----- YES ==> Then firstly, I need to take care of that high priority operator
                                         which is at the top of the stack
                                         Here we will follow BODMAS rule
                                         * and / has same priority (Go from left to right)
                                         + and - has same priority (Go from left to right)
                                         ----- If encountered operator is + or -, then all + - * / has equal
                                               and greater priority than it
                                               After solving these pop used operator and push encountered operator
                                         ----- If encountered operator is * or /,
                                           ==> and if top operator in op stack there is * or / ,
                                               which means it has equal and greater priority than it
                                               After solving these pop used operator and push encountered operator
                                           ==> and if top operator in op stack there is + or -
                                               which has lesser priority than * or /, so here I don't need to do
                                               any further work, just simply push encountered operator
                           ----- NO ==> It means my current operator which I did encounter has higher priority
                                        So, it should be at the top of the op stack
                                        Hence, push my current operator which I did encounter

After iteration over the string expression
----- I will check until there is only one element in our val stack ==>  while(val.size() > 1)
      ----- I will pop 2 numbers from val stack and one operator from op stack, and do arithmetic operation on it

Now, I am left with only one element in the val stack, which is our result
----- Return ==> val.peek() or val.pop()
 */


package Questions;
import java.util.Stack;
public class IInfix {
    public static void main(String[] args) {
        String str = "9+5-6*4/6";
        System.out.println("Answer : " + infix(str));
    }
    public static int infix(String str) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            // Ascii value of character '0' is 48 and character '9' is 57

            if(ascii >= 48 && ascii <= 57) {
                int value = ascii - 48;
                val.push(value);
            }
            else if(op.size() == 0) {
                op.push(ch);
            }
            else {
                if(ch == '+' || ch == '-') {
                    int val2 = val.pop();
                    int val1 = val.pop();

                    if(op.peek() == '+') val.push(val1 + val2);
                    if(op.peek() == '-') val.push(val1 - val2);
                    if(op.peek() == '*') val.push(val1 * val2);
                    if(op.peek() == '/') val.push(val1 / val2);

                    op.pop();
                    op.push(ch);
                }
                else if(ch == '*' || ch == '/') {
                    if(op.peek() == '*' || op.peek() == '/') {
                        int val2 = val.pop();
                        int val1 = val.pop();

                        if(op.peek() == '*') val.push(val1 * val2);
                        if(op.peek() == '/') val.push(val1 / val2);

                        op.pop();
                        op.push(ch);
                    }
                    else {
                        op.push(ch);
                    }
                }
            }
        }

        // Because, at the last we should be having at least one value in our "val" stack
        // Which wil be our final answer after all the calculations
        while(val.size() > 1) {
            int val2 = val.pop();
            int val1 = val.pop();

            if(op.peek() == '+') val.push(val1 + val2);
            if(op.peek() == '-') val.push(val1 - val2);
            if(op.peek() == '*') val.push(val1 * val2);
            if(op.peek() == '/') val.push(val1 / val2);

            op.pop();
        }
        return val.pop();
    }




}
