package Java.BinaryTreeB;

import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SolutionDuplicate {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {
        if (node == null) return "#";

        // serialize left and right subtrees
        String left = serialize(node.left);
        String right = serialize(node.right);
        // create serialization string for current subtree
        String serial = node.val + "," + left + "," + right;

        // store frequency in map
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        // only add once when count reaches 2
        if (map.get(serial) == 2) {
            result.add(node);
        }

        return serial;
    }

    // For testing
    public static void main(String[] args) {
        /*
              1
             / \
            4   3
           /   / \
          3   4   3
             /
            3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left.left = new TreeNode(3);

        SolutionDuplicate sol = new SolutionDuplicate();
        List<TreeNode> duplicates = sol.findDuplicateSubtrees(root);

        // print duplicate subtree roots
        for (TreeNode node : duplicates) {
            System.out.print(node.val + " ");
        }
    }
}
