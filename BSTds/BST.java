package BSTds;
import java.util.*;
public class BST{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        }
        else{
            //right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(" "+ root.data);
        inorder(root.right);
    }



    //search a BST
    public static boolean searchBST(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        else if(root.data>key){
            return searchBST(root.left, key);
        }
        else if(root.data < key){
            return searchBST(root.right, key);
        }
        return false;
    }

    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }else if(root.data>val){
           root.left = delete(root.left, val);
        }else{//voila
          //case1 - leaf node
          if(root.left == null && root.right == null){
            return null;
          }    

          //case 2- single child
          if(root.left == null){
            return root.right;
          }
          else if(root.right == null){
            return root.left;
          }

          //case 3- both children
          Node IS = findInorderSuccessor(root.right);
          root.data = IS.data;
          root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }


    ////print in range
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }

    //root to lead Paths
    public static void printPath(LinkedList<Integer> path){
        for(int i = 0; i<path.size(); i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }
    public static Node helper(Node root, LinkedList<Integer> arr){
          if(root == null){
            return null;
          }
          arr.add(root.data);
          Node leftNode  = helper(root.left, arr);
          Node rightNode =  helper(root.right, arr);
          if(leftNode == null && rightNode == null){
             printPath(arr);
          }
          arr.remove(arr.size()-1);
          return root;
    }
    public static void rootToLeaf(Node root){
        LinkedList<Integer> arr = new LinkedList<>();
        helper(root,arr );
    }


    //validate bst
    public static boolean isValidBST(Node root, Node min, Node max){
         if(root == null){
            return true;
         }

         if(min != null && root.data<=min.data){
            return false;
         }
         else if(max!= null && root.data>=max.data){
            return false;
         }

         return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    //mirror a bst
    public static Node mirrorBST(Node root){
        if(root == null){
            return null;
        }
        Node leftM = mirrorBST(root.left);
        Node rightM = mirrorBST(root.right);
        root.left = rightM;
        root.right = leftM;
        return root;
    }

    //preorder
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    
    
    public static void main(String[] args){
        int values[] = {8,5,3,6,10,11};
        Node root = null;

        for(int i = 0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        inorder(root);
        mirrorBST(root);
        System.out.println();
        preorder(root);

    }
}