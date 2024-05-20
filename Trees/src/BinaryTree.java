// Representation -
// https://www.geeksforgeeks.org/introduction-to-binary-tree-data-structure-and-algorithm-tutorials/
public class BinaryTree {
    Node root;
    public BinaryTree() {
        this.root = null;
    }
    public BinaryTree(int data) {
        this.root = new Node(data);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
