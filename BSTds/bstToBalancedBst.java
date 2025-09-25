package BSTds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bstToBalancedBst {

    static class  Node {
       int data;
       Node left;
       Node right;
       Node(int data){
        this.data = data;
       }
        
    }

    public static Node createBst(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = createBst(root.left, val);
        }else if(root.data<val){
            root.right = createBst(root.right, val);
        }
        return root;
    } 

    //level order Traversal
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
    
    
    //bst to balanced bst
    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBst(ArrayList<Integer> inorder, int si, int ei){
        if(si>ei){
            return null;
        }
        int mid = si + (ei-si)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBst(inorder, si, mid-1);
        root.right = createBst(inorder, mid+1, ei);
        return root;
    }
    public static Node balancedBST(Node root){
          //inorder seq
          ArrayList<Integer> inorder = new ArrayList<>();
          getInorder(root, inorder);
          //sorted inorder => balanced bst
          root = createBst(inorder, 0, inorder.size()-1);
          return root;
    }
    public static void main(String args[]){
       int arr[] = {8,6,5,3,10,11,12};
       Node root = null;
       for(int i = 0; i<arr.length; i++){
          root = createBst(root, arr[i]);
       }

       root = balancedBST(root);
       levelOrder(root);
    }
}
