package BSTds;

public class rangeSum {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static int sum;

    public static void findRangeSum(Node root, int l, int r){
         if(root == null){
            return;
         }

         if(l<=root.data && r>=root.data){
            findRangeSum(root.left, l, r);
            sum+=root.data;
            findRangeSum(root.right, l, r);
         }

         else if(l<root.data){
              findRangeSum(root.left, l, r);
         }

         else if(r>root.data){
             findRangeSum(root.right, l, r);
         }
    }


    public static void main(String args[]){
       Node root  = new Node(8);
       root.left = new Node(5);
       root.left.left = new Node(3);
       root.left.right = new Node(6);

       root.right = new Node(11);
       root.right.right= new Node(20);


       int l = 5, r=12;
       findRangeSum(root, l, r);
       System.out.println(sum);
    }
}
