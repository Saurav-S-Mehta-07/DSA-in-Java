package BSTds;

import java.util.LinkedList;
import java.util.Queue;

public class sortArrToBST {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //sorted array to balanced bst
    public static Node createBst(int arr[], int s, int e){
        if(s>e){
            return null;
        }
        int mid = s + (e-s)/2;
        Node newNode = new Node(arr[mid]);
        newNode.left= createBst(arr, s, mid-1);
        newNode.right = createBst(arr, mid+1, e);
        return newNode;
    }

    public static void main(String args[]){
        int arr[] = {3,5,6,8,10,11,12};
        Node root = createBst(arr,0,arr.length-1);
        inorder(root);
        System.out.println();
        preorder(root);
    }
}
