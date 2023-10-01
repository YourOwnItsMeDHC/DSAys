// Q : Remove consecutive subsequences
// Given a sequence of numbers. Remove all the consecutive subsequences of length greater than or equal to 2
// that contains the same element

// Input  : 1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 2
// Output : [1, 3, 5, 2]

package Questions;

import java.util.Arrays;
import java.util.Stack;

public class CRemoveConsecutiveSubsequences {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 2};

        int[] ans = remove(nums);

        System.out.println("Array after removing consecutive subsequences : " + Arrays.toString(ans));
    }

    public static int[] remove(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            if(st.size() == 0 || st.peek() != arr[i]) {
                st.push(arr[i]);
            }
            else if(st.peek() == arr[i]) {
                if(i == arr.length-1 || arr[i] != arr[i+1]) {
                    st.pop();
                }
            }
        }

        int[] res = new int[st.size()];
        for(int i=res.length-1; i>=0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
