package Hashing;
import java.util.*;

public class TopBottomView {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    static class Pair {
        Node node;
        int axis;
        Pair(Node node, int axis) { this.node = node; this.axis = axis; }
    }

    // Top View using BFS
    public static int[] topView(Node root) {
        if (root == null) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int min = 0, max = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int axis = p.axis;

            if (!map.containsKey(axis)) { // first node at axis → top view
                map.put(axis, node.data);
            }

            if (node.left != null) q.add(new Pair(node.left, axis - 1));
            if (node.right != null) q.add(new Pair(node.right, axis + 1));

            min = Math.min(min, axis);
            max = Math.max(max, axis);
        }

        int[] res = new int[max - min + 1];
        for (int i = min; i <= max; i++) res[i - min] = map.get(i);
        return res;
    }

    // Bottom View using BFS
    public static int[] bottomView(Node root) {
        if (root == null) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int min = 0, max = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int axis = p.axis;

            map.put(axis, node.data); // overwrite each time → bottom view

            if (node.left != null) q.add(new Pair(node.left, axis - 1));
            if (node.right != null) q.add(new Pair(node.right, axis + 1));

            min = Math.min(min, axis);
            max = Math.max(max, axis);
        }

        int[] res = new int[max - min + 1];
        for (int i = min; i <= max; i++) res[i - min] = map.get(i);
        return res;
    }

    // Test
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);

        System.out.println("Top View:    " + Arrays.toString(topView(root)));
        System.out.println("Bottom View: " + Arrays.toString(bottomView(root)));
    }
}
