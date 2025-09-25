package BSTds;

public class greateSumTree {
    static class  Node {
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
        else if(root.data>data){
            root.left = insert(root.left, data);
        }
        else{
            root.right = insert(root.right, data);
        }
        return root;
    }

    static int sum = 0;
    public static void reverseInorder(Node root){
        if(root ==  null){
            return;
        }
        reverseInorder(root.right);
        sum+=root.data;
        root.data = sum-root.data;
        reverseInorder(root.left);
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void findGST(Node root){
        reverseInorder(root);
    }

    public static void main(String args[]){
        Node root = null;
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);

        findGST(root);
        inorder(root);

    }
}
