/*
Two Approaches :
Brute Force - using nested loops
Using stack - Efficient solution
 */

package Questions;
import java.util.Arrays;
import java.util.Stack;

public class DNextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 8, 6, 3, 4};

        System.out.println("Using Nested Loop : " + Arrays.toString(ngeForLoop(arr)));
        System.out.println("Using Stack : " + Arrays.toString(ngeStack(arr)));

//        Using Nested Loop : [3, 8, 8, 8, -1, -1, 4, -1]
//        Using Stack : [3, 8, 8, 8, -1, -1, 4, -1]
    }



    /*
    [ 1, 3, 2, 1, 8, 6, 3, 4 ]
                        ⬆  ⬆
                       n-2 n-1
    Next greater e;ement for the last index will be -1,
    because it is the last element , and there is nothing remaining to compare

    If there is NGE, we will take that

    And, if there is no NGE, then we will, just simply put -1 there
    So, here initially we will be creating a res array with default values -1, only
     */
    public static int[] ngeForLoop(int[] nums) {
        int[] res = new int[nums.length];

        // https://www.geeksforgeeks.org/arrays-fill-java-examples/
        // Arrays.fill(int[] a, int from_Index, int to_Index, int val)
        Arrays.fill(res, 0, res.length, -1);

        for(int i=0; i<=nums.length-2; i++) {
            for (int j= i+1; j <= nums.length-1; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
    }

    /*

    Algorithm Analysis
    Time Complexity: Since there is two loop present which in worse case scenario runs for n times
    (i.e the size of the given array) .

    we get the time complexity as : O(n)*O(n) = O(n²).

    Space Complexity = O(n) (as we are storing the res in NGE array).
     */






    public static int[] ngeStack(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];

        // NGE of last element is -1 only
        res[res.length-1] = -1;

        // Here, we will be iterating from last element to the first element, towards left side
        // So, here the greater element, which I am having is, these last element only i.e. 4
        // Hence, I will be pushing that onto the stack
        st.push(nums[nums.length-1]);

        // Here, I will be using a method : POP --> GET ANSWER --> PUSH

        // I will be comparing my current element with th element which are at peek
        // I will keep on popping until I find NGE of the current element                  ===> POP
        // If while these process, stack got empty, then I will consider that there is no NGE
        // So, I wil just simply put -1 in res array, and here,                             ===> GET ANSWER
        // My current element might be NGE for some another element for which iteration is still left
        // Hence, I will be pushing my current element as well                              ===> PUSH

        // I will be comparing my current element with th element which are at peek
        // I will keep on popping until I find NGE of the current element                   ===> POP
        // If I found NGE for current element, I will just simply put that NGE in res array ===> GET ANSWER
        // My current element might be NGE for some another element for which iteration is still left
        // Hence, I will be pushing my current element as well                              ===> PUSH

        /*
        Intution : arr = [10,2,1,5,8,7,11] , NGE = [-1,-1,-1,-1,-1,-1,-1] ,
        stack = st (Initialize the NGE with -1 and initially st is empty). Iteration starts from right side .

        11 -> -1 (as this is the right most element ) .push the current element to stack :
        Now st = [11] & NGE = [-1,-1,-1,-1,-1,-1,-1]

        7 ->11 (when iterating through the stack the top element is greater than current element
        so we assign NGE as 11 & push the current element.)

        st = [7,11] & NGE = [-1,-1,-1,-1,-1,11,-1]

        8 ->11 (when iterating through the stack we pop the top element which is 7
        as it is smaller and this pop elements until we find greater element than 8.)

        st = [8,11] & NGE = [-1,-1,-1,-1,11,11,-1]

        5->8 : st = [5,8,11] & NGE = [-1,-1,-1,8,11,11,-1]

        1->5 : st = [1,5,8,11] & NGE = [-1,-1,5,8,11,11,-1]

        2->5 : st = [2,5,8,11] & NGE = [-1,5,5,8,11,11,-1]

        10->11 : st = [10,11] & NGE = [11,5,5,8,11,11,-1]
         */


        for(int i=nums.length-2; i>=0; i--) {
            while(st.size() > 0 && st.peek() < nums[i]) {
                st.pop();
            }
            if(st.size() == 0) {
                res[i] = -1;
            }
            else {                  // st.peek() > nums[i]
                res[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return res;
    }
}

/*
while(st.size() > 0 && st.peek() < nums[i]) {
    st.pop();
}

Above, it will check first, it if it empty i.e size is 0
Then, it's obvious that another condition matter
It won't execute that while loop, further



while(st.peek() < nums[i] && st.size() > 0) {
    st.pop();
}

Above, it will check first, that top element of the stack is greater than the current element or not
But, before these we should check that whether there is SOMETHING in the stack or not

If there is nothing in the stack
Suppose st.size = 0, then there is nothing
What are we comparing, then here, it won;t be false, instead it will throw an EmptyStackException
 */

/*
Algorithm Analysis
Time Complexity: The time complexity for this approach is O(n)
as elements are only pushed only one time in the stack ,
so there is no repeated iteration for the elements of array.
Also ,in the worst case scenario ,every element is processed at maximum of 4 times only
(in terms of push and and pop operation of the stack).(Think!)

Space Complexity = O(n) (as we are storing the res in NGE array).
 */
