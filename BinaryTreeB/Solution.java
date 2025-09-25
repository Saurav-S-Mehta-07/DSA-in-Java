package Java.BinaryTreeB;


public class Solution {
    static class TreeNode {
     int val;
     TreeNode left, right;
     TreeNode(int x) { val = x; }
    }
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // get max gain from left and right (ignore negatives)
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // path passing through this node
        int pathSum = node.val + leftGain + rightGain;

        // update global maximum
        maxSum = Math.max(maxSum, pathSum);

        // return max gain to parent
        return node.val + Math.max(leftGain, rightGain);
    }

    // Main for testing
    public static void main(String[] args) {
        // Example 1: 
        //       4
        //      / \
        //     2   7
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);

        Solution sol1 = new Solution();
        System.out.println("Max Path Sum (Example 1): " + sol1.maxPathSum(root1)); // 13

        // Example 2:
        //          -10
        //          /  \
        //        9     20
        //             /  \
        //            15   7
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);

        Solution sol2 = new Solution();
        System.out.println("Max Path Sum (Example 2): " + sol2.maxPathSum(root2)); // 42
    }
}
