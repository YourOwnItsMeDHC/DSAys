package Questions;

import java.util.Stack;

public class BMinBracketsRemovedForBalancedSequence {
    public static void main(String[] args) {
        String str = "{{{{}}";
        System.out.println(removedBracketsCount(str));          // 2
    }
    public static int removedBracketsCount(String s) {

        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(')');
            }
            else if(ch == '[') {
                stack.push(']');
            }
            else if(ch == '{') {
                stack.push('}');
            }
            else if(stack.isEmpty() || stack.pop() != ch) {
                count += 1;
            }
        }

        count += stack.size();
        return count;

    }
}
