package BSTds;

public class MaxSumBST {

    static class Node {
       int data;
       Node left, right;
       Node(int d) { data = d; left = right = null; }
    }

    static class Info {
      boolean isBST;
      int sum, min, max;
      Info(boolean isBST, int sum, int min, int max) {
          this.isBST = isBST;
          this.sum = sum;
          this.min = min;
          this.max = max;
      }
    }

    static int maxSum = 0;

    public static Info helper(Node root) {
        if (root == null)
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info left = helper(root.left);
        Info right = helper(root.right);

        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int currSum = left.sum + right.sum + root.data;
            maxSum = Math.max(maxSum, currSum);
            return new Info(true, currSum,
                            Math.min(root.data, left.min),
                            Math.max(root.data, right.max));
        }

        return new Info(false, 0, 0, 0);
    }

    public static int maxSumBST(Node root) {
        helper(root);
        return maxSum;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);
        root.right.right = new Node(3);

        System.out.println("Maximum Sum BST in Tree: " + maxSumBST(root));
    }
}
