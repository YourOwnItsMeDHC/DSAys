package Basics;

public class ILinkedListImplementation {
    public static void main(String[] args) {
        Stack st = new Stack();

        System.out.println(st.isEmpty());      // true

        st.push(10);                        // 10 has been pushed
        st.push(20);                        // 20 has been pushed
        st.push(30);                        // 30 has been pushed
        st.push(40);                        // 40 has been pushed
        st.push(50);                        // 50 has been pushed
        st.push(60);

        System.out.println(st.peek());         // 60

        st.pop();                              // 60 popped out

        System.out.println(st.size());         // 5

        System.out.println(st.isEmpty());      // false

        st.displayReverse();                   // 50 40 30 20 10

        st.display();                          // 10 20 30 40 50
    }

    // User defined data type
    public static class Node {
        int val;
        Node next;
        Node(int x) {
            this.val = x;
        }
    }

    //User defined data structure
    public static class Stack {
        Node head = null;
        int size = 0;

        /*     PUSH
        LL :  10 -> 20 -> null
               ^
               |
              head

        Insert 30 -

        node = 30
        LL :  10 -> 20 -> null
               ^
               |
              head

        head points to 30, so, now 30 will be first element
        i.e. head = node
        LL :   30  10 -> 20 -> null
               ^
               |
              head

        But, now, how 30 will point to 10, Hence, it is the wrong way


        Correct way :

        node = 30
        LL :  10 -> 20 -> null
               ^
               |
              head

        Point our node to head
        node.next = head
        LL :   30 -> 10 -> 20 -> null
                      ^
                      |
                     head

        Now, point head to our node, because head should always point to the first node
        LL :   30 -> 10 -> 20 -> null
                ^
                |
               head
         */

        void push(int x) {
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
            size++;

            System.out.println(x + " has been pushed");
        }


        /*     POP
           LL :   30 -> 10 -> 20 -> null
                  ^
                  |
                head

          Just, simply move head to the next node
          head = head.next
          LL :   30 -> 10 -> 20 -> null
                        ^
                        |
                       head

          Now, 30 has no link to any node, hence, 30 will be considered as deleted or pop out
                ______
          LL :  | 30 |         10 -> 20 -> null
                ______          ^
                 POP            |
                               head
        */

        void pop() {
            if(head == null) {
                System.out.println("Stack is empty!");
                return;
            }
            System.out.println(head.val + " popped out");
            head = head.next;
            size--;
        }

        int peek() {
            if(head == null) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return head.val;
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            if(size == 0) {
                return true;
            }
            return false;
        }

        /*

        LL :  null
               ^
               |
              head
        Stack : []

        Node = 10
        LL :   10 -> null
               ^
               |
              head
        Stack : [10]

        Node = 20
        LL :  20 -> 10 -> null
               ^
               |
              head
        Stack : [10 20]

        Node = 30
        LL :   30 -> 20 -> 10 -> null
               ^
               |
              head
        Stack : [10 20 30]

        Here, below, "displayReverse()" will print 30 20 10, because, here we are iterating over our LL
        But, we should get 10 20 30, because, here I am displaying my stack
        So, it should display my stack, in the same order, in which order it has been inserted i.e. 10 20 30


         */
        void displayReverse() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        void displayRecur(Node h) {
            if(h == null) {
                return;
            }
            int top = h.val;
            displayRecur(h.next);

            System.out.print(top + " ");
        }
        void display() {
            displayRecur(head);
            System.out.println();
        }

    }
}
