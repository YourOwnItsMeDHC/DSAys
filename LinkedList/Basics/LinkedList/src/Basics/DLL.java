package Basics;

public class DLL {
    private Node head;
    private int size;
    private class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);

        node.next = head;
        node.prev = null;

        // If head is pointing to null, then it is obvious, that, prev will also be null, because there is nothing in the DLL
        // Hence, we have to point the prev pointer of head to the newly created node, only if there is something in th head
        // Then, only our newly created node will be previous of head or someone

        // If there is nothing in the head, the our newly created node will be previous of what ??? Nothing
        // Here, in these case, our newly created node is the very first node, so we will direct point
        // our head to these newly created node

        if(head != null) {
            head.prev = node;
        }
        head = node;
        size++;
    }
}
