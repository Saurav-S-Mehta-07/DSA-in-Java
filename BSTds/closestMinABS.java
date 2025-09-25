package BSTds;

import Java.Arrays.staircaseSearch;

public class closestMinABS {

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

    //approach 1-> tc O(n) sc O(n)

    static int kc = Integer.MAX_VALUE;
    public static void  findClosestMinAbs(Node root, int k){
        if(root == null){
            return;
        }
        if(root.data == k){
            kc = 0;
            return;
        }
        if(k<root.data){
            kc = Math.min(Math.abs(root.data-k), kc);
            findClosestMinAbs(root.left, k);
        }
        else if(k>root.data){
            kc = Math.min(Math.abs(root.data-k), kc);
            findClosestMinAbs(root.right, k);
        }
    }

    //aproach 2 -> iterative way tc O(n) sc O(1)
    public static int findMinAbs(Node root, int k){
        int kc = Integer.MAX_VALUE;
        Node ptr = root;
        while(ptr!=null){
            kc = Math.min(Math.abs(ptr.data-k),kc);
            if(ptr.data > k){
                ptr = ptr.left;
            }else if(ptr.data<k){
                ptr = ptr.right;
            }else{
                return 0;
            }
        }
        return kc;
    }

    public static void inoder(Node root){
        if(root == null) return;
        inoder(root.left);
        System.out.print(root.data + " ");
        inoder(root.right);
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

        findClosestMinAbs(root, k);
        System.out.println(kc);
        System.out.println();
        System.out.println(findMinAbs(root, k));

    }
}
