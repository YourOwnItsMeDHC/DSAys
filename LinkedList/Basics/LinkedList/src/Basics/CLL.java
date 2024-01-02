package Basics;

public class CLL {
    private Node head;
    private Node tail;
    private int size;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    private class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }


    // In CLL, insert at first and last, will be the same, because here the linked list is circular
    public void insert(int value) {
        Node node = new Node(value);

        // Inserting node at the very first position, when CLL is empty
        if(head == null) {
            head = node;
            tail = node;
            return;
        }

        // Insert at last
        tail.next = node;
        node.next = head;
        tail = node;

        size++;
    }

    public void display() {
        Node temp = head;

        do {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        while(temp != head);

        System.out.print("HEAD");
    }

    public void delete(int value) {
        Node node = head;

        // CLL is empty
        if(node == null) {
            return;
        }

        // Here, still, our node is pointing to the head i.e the very first node
        if(node.val == value) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            if(node.next.val == value) {
               node.next = node.next.next;
               break;
            }
            node = node.next;
        }
        while(node != head);
    }

}
