package Basics;

public class DLL {
//    private Node head;
    Node head;
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

    public void insertLast(int val) {
        Node node = new Node(val);

        node.next = null;

        // It means, the node which is getting is inserted is the very first node in DLL
        if(head == null) {
            node.prev = null;
            head = node;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        // Now, here, temp is pointing to the last node


        temp.next = node;
        node.prev = temp;
        size++;

        System.out.println(node.val + " is inserted after " + temp.val);
    }

    public int findNodeValue(int index) {
        Node temp = head;
        for(int i=1; i<=index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public Node findNode(int index) {
        Node temp = head;
        for(int i=1; i<=index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void insertIndex(int index, int val) {
        Node node = new Node(val);

        if(index == 0) {
            insertFirst(val);
            return;
        }
        if(index == size) {
            insertLast(val);
            return;
        }

        Node prevNode = findNode(index-1);

        node.prev = prevNode;
        node.next = prevNode.next;

        prevNode.next.prev = node;
        prevNode.next = node;
        size++;
    }

    // Find a node, which is having the provided value, and return the index of it
    public int find(int value) {
        Node temp = head;
        int i= 0;
        while(temp != null) {
            if(temp.val == value) {
                System.out.println("Node with value " + value + " is present at the index : " + i);
                return temp.val;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("No node found with the value " + value);
        return -1;
    }

    public Node findNodeByValue(int value) {
        Node temp = head;
        while(temp != null) {
            if(temp.val == value) {
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("No node found with the value " + value);
        return null;
    }

    // Insert a node after a specific node(for which value is provided)
    public void insertAfter(int after, int value) {
        Node prevNode = findNodeByValue(after);
        if(prevNode == null) {
            System.out.println("Specified node " + after + " not found, after which I do wanna insert");
            return;
        }

        Node node = new Node(value);

        node.next = prevNode.next;
        prevNode.next = node;

        node.prev = prevNode;

        // Checking whether is there any next node
        // If there is no next node, that means, we are inserting at the last position
        // Then, it's obvious, that, we don't need to do previous of the node's next, because node.next is null only
        // If above is not the case, then only I will be doing the below things
        if(node.next != null) {
            node.next.prev = node;
        }
        size++;
    }

    public void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("END");
    }

    // In below method, to display in reverse order, I have passed "head" node as the parameter
    // It will wor only, if head is not defined as private
    //Because, in our main class when we do call 'displayRevD", I have to pass "head" node as the argument
    // So, in order to make "head" node accessible even in that main class, I should not keep "head" node as private in DLL.java
    public void displayRevD(Node head) {
        Node temp = head;

        if(temp == null) {
            System.out.print("END<-");
            return;
        }

        displayRevD(temp.next);
        System.out.print(temp.val + "<-");
    }

    // Display in reverse order, using 2 while loops
    // Firstly, go from first to last node, take reference of that last node
    // Then, come back again to the start position, while displaying each node
    public void display2WhileLoop() {
        Node temp = head;
        Node last = null;

        while(temp != null) {
            last = temp;
            temp = temp.next;
        }

        System.out.println("Print in reverse : ");
        while(last != null) {
            System.out.print(last.val + "->");
            last = last.prev;
        }
        System.out.print("START");
    }
}
