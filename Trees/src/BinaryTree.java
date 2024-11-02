// Representation -
// https://www.geeksforgeeks.org/introduction-to-binary-tree-data-structure-and-algorithm-tutorials/
public class BinaryTree {
    Node root;
    public BinaryTree() {
    }

    public void addRoot(int value) {
        root = new Node(value);
    }

    public void leftChild(Node node, int value) {
        node.left = new Node(value);
    }

    public void rightChild(Node node, int value) {
        node.right = new Node(value);
    }

    // Display the tree in a landscape ASCII format
    public void printTree(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.value);
            printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

}

class Node {
    int value;
    Node left, right;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
