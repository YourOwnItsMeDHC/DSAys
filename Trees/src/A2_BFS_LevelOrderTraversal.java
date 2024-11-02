//              1
//          /        \
//        2           3
//      /   \       /   \
//     4    5      6     7
//    / \  /  \   / \   / \
//   8  9 10  11 12 13 14 15

import java.util.LinkedList;
import java.util.Queue;

public class A2_BFS_LevelOrderTraversal {
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

        bfs_levelOrderTraversal(tree.root);



    }

    public static void bfs_levelOrderTraversal(Node node) {
        if(node == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
    }
}
