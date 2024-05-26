package Basics;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }


    public void insertFirst(int val) {
        Node node = new Node(val);

        node.next = head;
        head = node;

        // If tail is pointing to null, it means last pointer is pointing to nothing i.e. null,
        // which means LL is empty, the node which we are inserting is the very first element or node,
        // Hence, both, head and tail, has to point these newly added node,
        // Because, now here we do have only one node in the Linked List
        if(tail == null) {
            tail = node;
        }
        size += 1;
    }

    public void insertLast(int val) {
        // If tail is pointing to null, it means last pointer is pointing to nothing i.e. null,
        // which means LL is empty, the node which we are inserting is the very first element or node,
        if(tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insert(int val, int index) {
        if(index == 0) {
            insertFirst(val);
            return;
        }
        if(index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        // Now temp reference pointer is pointing at index 0, which by default is pointed by head as well
        for(int i=1; i<index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size +=1 ;
    }




//    Insert a specific node provided with the value and the index where it has to be
    public void insertRecur(int val, int index) {
        // At the last recursion call, it will say that head will point to which specific node
        head = insertRecur(val, index, head);
        // Here, the third argument is passed as head node, because, I will stgart my recursion call from head itself
    }

    public Node insertRecur(int val, int index, Node node) {
        if(index == 0) {
            // I am now at a position where my node has to be there, so whatever node which was there already will ahead
            // Hence that already present node will be the next node of my node
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        // After insertion of a specif node, recursion all is going back again
        // Saying that I have a node which is next to you, means, I am you next node
        node.next = insertRecur(val, index-1, node.next);
        return node;
    }

    public int deleteFirst() {
        // Getting val, just to return it i.e. which node I have deleted
        int value = head.val;
        head = head.next;

        // Might possible that LL is already empty
        if(head == null) {
            tail = null;
        }
        size -=1;
        return value;
    }

    public int deleteLastD() {
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        int value = temp.next.val;

        temp.next = null;
        size -= 1;
        return value;
    }

    public Node get(int index) {
        Node node = head;
        for(int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }

   public int delete(int index) {
        if(index == 0) {
            return deleteFirst();
        }
        if(index == size-1) {
            return deleteLastD();
        }
        Node prev = get(index-1);
        int value = prev.next.val;
        prev.next = prev.next.next;
        size -= 1;
        return value;
   }

   public int deleteLast() {
        if(size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int value = tail.val;
        tail = secondLast;
        tail.next = null;
        size -= 1;
        return value;
   }

   public Node find(int val) {
        Node node = head;
        while(node != null) {
            if(node.val == val) {
                return node;
            }
            node = node.next;
        }
        return null;
   }

    public void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int sizeOfLL(Node head) {
        Node temp = head;
        int count = -0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    // 148. Sort List - Recursive bubble sort approach-2 (check other 3 approaches as well)
    public void sortList() {
        bubbleSort(size-1, 0);
    }

    public Node getNode(int index) {
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void bubbleSort(int iteration, int index) {
        if(iteration == 0) {
            return;
        }
        if(index < iteration) {
            Node first = getNode(index);
            Node second = getNode(index + 1);
            Node prev = getNode(index - 1);

            if(first.val < second.val) {
                if(first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }
                else if(second == tail) {
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                }
                else {
                    prev.next = first.next;
                    first.next = second.next;
                    second.next = first;
                }
            }

            bubbleSort(iteration, index+1);
        }
        else {
            bubbleSort(iteration-1, 0);
        }
    }

}
