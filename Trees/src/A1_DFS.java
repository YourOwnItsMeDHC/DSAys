//             1
//         /        \
//        2           3
//      /   \       /   \
//     4    5      6     7
//    / \  /  \   / \   / \
//   8  9 10  11 12 13 14 15

public class A1_DFS {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.addRoot(1);

        tree.leftChild(tree.root, 2);
        tree.rightChild(tree.root, 3);
        tree.leftChild(tree.root.left, 4);
        tree.rightChild(tree.root.left, 5);
        tree.leftChild(tree.root.left.left, 8);
        tree.rightChild(tree.root.left.left, 9);
        tree.leftChild(tree.root.left.right, 10);
        tree.rightChild(tree.root.left.right, 11);

        tree.leftChild(tree.root.right, 6);
        tree.rightChild(tree.root.right, 7);
        tree.leftChild(tree.root.right.left, 12);
        tree.rightChild(tree.root.right.left, 13);
        tree.leftChild(tree.root.right.right, 14);
        tree.rightChild(tree.root.right.right, 15);

        // Display the tree in a landscape format
        System.out.println("Tree structure:");
        tree.printTree(tree.root, "", false);

        // Perform traversals
        System.out.println("\nPre-order traversal:");
        preOrder(tree.root);
        System.out.println("\n===========================================================");
        System.out.println("In-order traversal:");
        inOrder(tree.root);
        System.out.println("\n===========================================================");
        System.out.println("Post-order traversal:");
        postOrder(tree.root);


    }

    public static void preOrder(Node node) {
        if(node == null) return;

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
}
