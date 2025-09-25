package BSTds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Java.Backtracking.nQueen;

public class merge2bst {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left= this.right = null;
        }
    }



     public static void levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }


     public static void inorder(Node root, ArrayList<Integer> inorderArr){
        if(root == null){
            return;
        }
        inorder(root.left, inorderArr);
        inorderArr.add(root.data);
        inorder(root.right, inorderArr);
    }
    public static Node makeBst(ArrayList<Integer> finalSorted, int si,int ei){
        if(si>ei){
            return null;
        }
        // int mid = si + (ei-si)/2;
        int mid = si+ (ei-si+1)/2;
        Node root = new Node(finalSorted.get(mid));
        root.left = makeBst( finalSorted, si, mid-1);
        root.right = makeBst( finalSorted, mid+1, ei);
        return root;
    }

    public static void mergeInorder(ArrayList<Integer> finalSorted, ArrayList<Integer> inorder1, ArrayList<Integer> inorder2){
         int i=0,j=0;
        while (i<inorder1.size() && j<inorder2.size()) {
            if(inorder1.get(i)>inorder2.get(j)){
                finalSorted.add(inorder2.get(j));
                j++;
            }else{
                finalSorted.add(inorder1.get(i));
                i++;
            }
        }
        while(i<inorder1.size()){
            finalSorted.add(inorder1.get(i));
            i++;
        }
        while(j<inorder2.size()){
            finalSorted.add(inorder2.get(j));
            j++;
        }

    }

    public static Node mergeBst(Node bst1, Node bst2){
        ArrayList<Integer> inorder1 = new ArrayList<>();
        ArrayList<Integer> inorder2 = new ArrayList<>();
        ArrayList<Integer> finalSorted = new ArrayList<>();
        inorder(bst1, inorder1);
        inorder(bst2, inorder2);
        mergeInorder(finalSorted, inorder1, inorder2);
        Node root = makeBst(finalSorted, 0, finalSorted.size()-1);
        return root;
    }

    public static void main(String args[]){
       Node bst1 = new Node(2);
       bst1.left= new Node(1);
       bst1.right = new Node(4);

       Node bst2 = new Node(9);
       bst2.left = new Node(3);
       bst2.right = new Node(12);

       Node root = mergeBst(bst1, bst2);

       levelOrder(root);
   }
}
