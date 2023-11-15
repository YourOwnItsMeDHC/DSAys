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

    public void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
