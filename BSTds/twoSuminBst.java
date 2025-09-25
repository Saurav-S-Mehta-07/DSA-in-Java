package BSTds;

import java.util.ArrayList;

public class twoSuminBst {

    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data  = data;
            this.left = this.right = null;
        }
    }

    public static Node insert(Node root, int data){
        if(root == null){
            return new Node(data);
        }else{
            if(root.data > data){
                root.left = insert(root.left, data);
            }
            else{
                root.right = insert(root.right, data);
            }
        }
        return root;
    }

    public static void inorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public static void findPair(Node root, int x){
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        int i = 0, j = arr.size()-1;
        boolean found = false;
        while(i<=j){
            int sum = arr.get(i) + arr.get(j);
            if(sum == x){
                System.out.println("(" + arr.get(i)+","+arr.get(j)+")"+" ");
                found = true;
                i++;
                j--;
            }
            else if(sum<x){
                i++;
            }
            else{
                j--;
            }
        }
        if(!found){
           System.out.println("no pair exists");
        }
    }

    public static void main(String args[]){
        int x = 16;

        Node root = null;
        root = insert(root, 10);
        root = insert(root, 6);
        root = insert(root, 3);
        root = insert(root, 8);
        root = insert(root, 15);
        root = insert(root, 11);
        root = insert(root, 18);

        findPair(root, x);

    }
}
