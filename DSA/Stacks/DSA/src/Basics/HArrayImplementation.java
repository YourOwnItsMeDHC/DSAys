package Basics;

public class HArrayImplementation {
    public static void main(String[] args) {
        Stack st = new Stack();

        System.out.println(st.capacity());     // 5
        System.out.println(st.isEmpty());      // true

        st.push(10);                        // 10 has been pushed
        st.push(20);                        // 20 has been pushed
        st.push(30);                        // 30 has been pushed
        st.push(40);                        // 40 has been pushed
        st.push(50);                        // 50 has been pushed

        System.out.println(st.isFull());       // true

        st.push(60);                        // Stack is full, not able to push 60

        System.out.println(st.peek());         // 50

        st.pop();                              // 50 has been pushed

        st.display();                          // 10 20 30 40

        st.size();                             // Size : 5

        System.out.println(st.isEmpty());      // false

        System.out.println(st.isFull());       // false

        System.out.println(st.capacity());     // 5

    }

    public static class Stack {
        private int[] arr = new int[5];
        private int idx = 0;

        void push(int x) {
            if(isFull()) {
                System.out.println("Stack is full, not able to push " + x);
                return;
            }
            arr[idx] = x;
            idx++;
            System.out.println(x + " has been pushed");
        }

        int peek() {
            if(idx == 0) {
                System.out.println("Stack is empty");
                return -1;
            }
            return arr[idx-1];
        }

        void pop() {
            if(idx == 0) {
                System.out.println("Stack is empty, nothing to pop");
                return;
            }
            int top = arr[idx-1];
            arr[idx-1] = 0;
            idx--;
            System.out.println(top + " has been popped");
//            return top;
        }

        void display() {
            for(int i=0; i<=idx-1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        //If there is only element, then idx will pointing to index 0, but, the size is idx+1 = 0+1 = 1
        // Hence, size is idx+1
//        int size() {
//            return idx+1;
//        }

        void size() {
            System.out.println("Size : " + arr.length);
        }

        boolean isEmpty() {
            if(idx == 0) {
                return true;
            }
            else {
                return false;
            }
        }

        boolean isFull() {
            if(idx == arr.length) {
                return true;
            }
            else {
                return false;
            }
        }

        int capacity() {
            return arr.length;
        }
    }
}
