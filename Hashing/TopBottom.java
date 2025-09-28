package Hashing;
import java.util.*;

public class TopBottom {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // Helper class to track min and max axis
    static class Axis {
        int min = 0, max = 0;
    }

    // Top view using preorder (root-left-right)
    public static void topViewPreorder(Node node, int axis, Map<Integer, Integer> map, Axis bounds) {
        if (node == null) return;


        bounds.min = Math.min(bounds.min, axis);
        bounds.max = Math.max(bounds.max, axis);

        topViewPreorder(node.left, axis - 1, map, bounds);
        topViewPreorder(node.right, axis + 1, map, bounds);
        map.put(axis, node.data);
    }

    // Bottom view using preorder (root-left-right)
    public static void bottomViewPreorder(Node node, int axis, Map<Integer, Integer> map, Axis bounds) {
        if (node == null) return;

        bounds.min = Math.min(bounds.min, axis);
        bounds.max = Math.max(bounds.max, axis);

        bottomViewPreorder(node.left, axis - 1, map, bounds);
        bottomViewPreorder(node.right, axis + 1, map, bounds);
        if(!map.containsKey(axis)){
            map.put(axis, node.data);
        }
    }

    // Convert map to array using min/max axis
    public static int[] mapToArray(Map<Integer, Integer> map, Axis bounds) {
        int[] arr = new int[bounds.max - bounds.min + 1];
        for (int i = bounds.min; i <= bounds.max; i++) {
            arr[i - bounds.min] = map.get(i);
        }
        return arr;
    }

    // Test
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left= new Node(2);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        // root.left = new Node(2);
        // root.left.left = new Node(3);
        // root.left.right = new Node(4);
        // root.left.right.left = new Node(5);
        // root.left.right.right = new Node(6);
        // root.right = new Node(7);
        // root.right.right = new Node(8);

        // Top View
        Map<Integer, Integer> topMap = new HashMap<>();
        Axis topBounds = new Axis();
        topViewPreorder(root, 0, topMap, topBounds);
        System.out.println("Top View:    " + Arrays.toString(mapToArray(topMap, topBounds)));

        // Bottom View
        Map<Integer, Integer> bottomMap = new HashMap<>();
        Axis bottomBounds = new Axis();
        bottomViewPreorder(root, 0, bottomMap, bottomBounds);
        System.out.println("Bottom View: " + Arrays.toString(mapToArray(bottomMap, bottomBounds)));
    }
}
