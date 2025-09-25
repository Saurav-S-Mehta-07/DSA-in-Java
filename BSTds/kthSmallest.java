package BSTds;

import Java.Arrays.staircaseSearch;

public class kthSmallest {
     static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node insert(Node root, int data){
       if(root == null){
        return new Node(data);
       }

       if(data<root.data){
        root.left = insert(root.left, data);
       }
       else{
        root.right = insert(root.right, data);
       }
       return root;
    }

    
    static int el = 1;
    public static void kthSmallestEl(Node root, int k){
 
        if(root == null || el>k){
            return;
        }
        kthSmallestEl(root.left, k);
        if(el==k){
            System.out.println(root.data);
        }
        el++;
        kthSmallestEl(root.right, k);
    }

     public static void main(String args[]){
        Node root = null;
        root = insert(root, 8);
        insert(root, 5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 11);
        insert(root, 20);

        int k = 5;

        kthSmallestEl( root, k);

    }
}
