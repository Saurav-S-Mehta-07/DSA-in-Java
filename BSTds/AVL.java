package BSTds;


public class AVL {

    static class Node{
        int data , height;
        Node left, right;
        Node(int data){
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    //get balanced factor of node
    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static int max(int a, int b){
        return Math.max(a, b);
    }

    //left rotagte subtree rooted with x
    public static Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        //perform rotation
        y.left = x;
        x.right = T2;

        //update heights
        x.height = max(height(x.left), height(x.right))+1;
        y.height = max(height(y.left), height(y.right))+1;

        //return new root
        return y;
    }

    //right rotate subtree rooted with y
    public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        //Perform rotation
        x.right = y;
        y.left = T2;

        //update heights
        y.height = max(height(y.left), height(y.right))+1;
        x.height = max(height(x.left), height(x.right))+1;

        //return new root
        return x;
    }

    public static Node insert(Node root, int key){
        if(root == null)
           return new Node(key);
        if(key<root.data)
            root.left = insert(root.left, key);
        else if(key>root.data)
             root.right = insert(root.right, key);
        else 
          return root; // Duplicate keys not allowed

          //Update root height
          root.height = 1 + Math.max(height(root.left), height(root.right));
          //get root's balaced factor
          int bf = getBalance(root);
          //left left case
          if(bf > 1 && key < root.left.data)
              return rightRotate(root); 
          //right right case
          if(bf < -1 && key > root.right.data)
               return leftRotate(root);
         //left right case
         if(bf > 1 && key > root.left.data){
             root.left = leftRotate(root.left);
             return rightRotate(root);
         }
         //right left case
         if(bf < -1 && key<root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
         }

         return root; //returned if AVL balanced
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }
    

    //delete
    // Return the node with minimum data in a non-empty BST
    public static Node getMinNode(Node root) {
        Node curr = root;
        // MIN data is at the left-most node
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    
    // Delete a node from AVL Tree
    public static Node deleteNode(Node root, int key) {
        // 1. Perform usual BST delete
        if (root == null) {
            return root;
        }
    
        // If key is smaller, go to left subtree
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }
        // If key is greater, go to right subtree
        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }
        // Key == root.data → this is the node to be deleted
        else {
            // Case 1: Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;
    
                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    // One child case → copy the contents of non-empty child
                    root = temp;
                }
            }
            // Case 2: Node with two children
            else {
                // Get inorder successor (smallest in right subtree)
                Node temp = getMinNode(root.right);
    
                // Copy inorder successor's data
                root.data = temp.data;
    
                // Delete inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }
    
        // If the tree had only one node
        if (root == null) {
            return root;
        }
    
        // 2. Update height of current node
        root.height = Math.max(height(root.left), height(root.right)) + 1;
    
        // 3. Get balance factor of this node
        int bf = getBalance(root);
    
        // 4. Balance the tree if unbalanced
    
        // Left Left Case
        if (bf > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
    
        // Left Right Case
        if (bf > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
    
        // Right Right Case
        if (bf < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
    
        // Right Left Case
        if (bf < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
    
        return root;
    }


    public static void main(String args[]){
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);


        preorder(root);

    }
}