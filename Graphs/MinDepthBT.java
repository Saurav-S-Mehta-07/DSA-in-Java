
//find minimum depth of a binary tree -> bfs traversal

package Graphs;
import java.util.*;

public class MinDepthBT {

    public static class Node {
        int data;
        Node left, right;
    }

    public static class qItem {
        Node node;
        int depth;

        public qItem(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static int minDepth(Node root) {
        if (root == null) return 0;

        Queue<qItem> q = new LinkedList<>();
        q.add(new qItem(root, 1));

        while (!q.isEmpty()) {
            qItem qi = q.poll();
            Node node = qi.node;
            int depth = qi.depth;

            if (node.left == null && node.right == null) {
                return depth;
            }

            if (node.left != null) {
                q.add(new qItem(node.left, depth + 1));
            }

            if (node.right != null) {
                q.add(new qItem(node.right, depth + 1));
            }
        }

        return 0;
    }

    public static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);

        System.out.println("Minimum Depth: " + minDepth(root));
    }
}
