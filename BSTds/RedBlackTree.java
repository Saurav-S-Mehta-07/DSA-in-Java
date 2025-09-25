package BSTds;

import java.io.*;

public class RedBlackTree {
    public Node root; // root node

    public RedBlackTree() {
        root = null;
    }

    class Node {
        int data;
        Node left, right, parent;
        char colour; // 'R' or 'B'

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.colour = 'R'; // new node always red
        }
    }

    // Left rotation
    Node rotateLeft(Node node) {
        Node x = node.right;
        Node y = x.left;

        x.left = node;
        node.right = y;

        node.parent = x;
        if (y != null) y.parent = node;

        return x;
    }

    // Right rotation
    Node rotateRight(Node node) {
        Node x = node.left;
        Node y = x.right;

        x.right = node;
        node.left = y;

        node.parent = x;
        if (y != null) y.parent = node;

        return x;
    }

    // Flags for rotation cases
    boolean ll = false;
    boolean rr = false;
    boolean lr = false;
    boolean rl = false;

    // Insertion helper
    Node insertHelp(Node root, int data) {
        boolean f = false;

        if (root == null)
            return new Node(data);
        else if (data < root.data) {
            root.left = insertHelp(root.left, data);
            root.left.parent = root;

            if (root != this.root) {
                if (root.colour == 'R' && root.left.colour == 'R')
                    f = true;
            }
        } else {
            root.right = insertHelp(root.right, data);
            root.right.parent = root;

            if (root != this.root) {
                if (root.colour == 'R' && root.right.colour == 'R')
                    f = true;
            }
        }

        // Rotations
        if (this.ll) {
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
            this.ll = false;
        } else if (this.rr) {
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            this.rr = false;
        } else if (this.rl) {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
            this.rl = false;
        } else if (this.lr) {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            this.lr = false;
        }

        // Red-Red conflict fixing
        if (f) {
            if (root.parent.right == root) {
                if (root.parent.left == null || root.parent.left.colour == 'B') {
                    if (root.left != null && root.left.colour == 'R')
                        this.rl = true;
                    else if (root.right != null && root.right.colour == 'R')
                        this.ll = true;
                } else {
                    root.parent.left.colour = 'B';
                    root.colour = 'B';
                    if (root.parent != this.root)
                        root.parent.colour = 'R';
                }
            } else {
                if (root.parent.right == null || root.parent.right.colour == 'B') {
                    if (root.left != null && root.left.colour == 'R')
                        this.rr = true;
                    else if (root.right != null && root.right.colour == 'R')
                        this.lr = true;
                } else {
                    root.parent.right.colour = 'B';
                    root.colour = 'B';
                    if (root.parent != this.root)
                        root.parent.colour = 'R';
                }
            }
            f = false;
        }
        return root;
    }

    // Insert function
    public void insert(int data) {
        if (this.root == null) {
            this.root = new Node(data);
            this.root.colour = 'B'; // root is always black
        } else
            this.root = insertHelp(this.root, data);
    }

    // Inorder traversal
    void inorderTraversalHelper(Node node) {
        if (node != null) {
            inorderTraversalHelper(node.left);
            System.out.printf("%d(%c) ", node.data, node.colour);
            inorderTraversalHelper(node.right);
        }
    }

    public void inorderTraversal() {
        inorderTraversalHelper(this.root);
        System.out.println();
    }

    // Print tree structure
    void printTreeHelper(Node root, int space) {
        int i;
        if (root != null) {
            space += 10;
            printTreeHelper(root.right, space);
            System.out.printf("\n");
            for (i = 10; i < space; i++) {
                System.out.printf(" ");
            }
            System.out.printf("%d(%c)\n", root.data, root.colour);
            printTreeHelper(root.left, space);
        }
    }

    public void printTree() {
        printTreeHelper(this.root, 0);
    }

    // Driver
    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree();
        int[] arr = {1, 4, 6, 3, 5, 7, 8, 2, 9};

        for (int i = 0; i < arr.length; i++) {
            t.insert(arr[i]);
            System.out.print("Inorder: ");
            t.inorderTraversal();
        }

        System.out.println("\nFinal Tree:");
        t.printTree();
    }
}
