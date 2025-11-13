package Java.BinaryTreeB;

import java.util.*;



public class BinaryTreeDS {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
           idx++;
           if(nodes[idx]==-1){
             return null;
           }

           Node newNode = new Node(nodes[idx]);
           newNode.left = buildTree(nodes);
           newNode.right = buildTree(nodes);

           return newNode;
        }
        
        //traversing
        //(a) preorder
        public static void preorder(Node root){ //O(n)
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        //(b) inorder
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        //(c) postorder
        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        //(d) level order Traversal
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

    }

    //height of a tree O(n)
     public static int height(Node root){
         if(root == null){
             return 0;
         }
         int lh = height(root.left);
         int rh = height(root.right);
         return Math.max(lh,rh)+1;
     }

     //count nodes of a tree O(n)
     public static int count(Node root){
        if(root == null){
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        return lc+rc+1;
     }

     //sum of nodes(data) O(n)
     public static int sum(Node root){
       if(root == null){
        return 0;
       }
       int ls = sum(root.left);
       int rs = sum(root.right);
       return ls + rs + root.data;
     }
    
     //diameter of a tree O(n^2)
     public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int rootDiam = height(root.left) + height(root.right) + 1;
        int leftDiam = diameter(root.left);
        int rightDiam = diameter(root.right);
        return Math.max(rootDiam, Math.max(leftDiam, rightDiam));
     }

     //diameter of a tree O(n)
     static class Info{
        int diameter;
        int height;
        Info(int diameter, int height){
           this.diameter = diameter;
           this.height = height;
        }
     }

     public static Info diameterO(Node root){
        if(root == null){
            return new Info(0, 0);
        }

        Info left = diameterO(root.left);
        Info right = diameterO(root.right);
        int diam = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height+1);
        int height= Math.max(left.height, right.height) + 1;

        return new Info(diam, height);
     }

      
     //helper for subtree of another tree
     public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }
        else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }
        
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }

        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }

        return true;
     }

     //subtree of another tree
     public static boolean isSubTree(Node root, Node subRoot){

        if(root == null){
            return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);

     }


     //top view of a tree

     static class Infom{
        Node node;
        int hd;
        Infom(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
     }
     public static void topView(Node root){
          //level Order
          Queue<Infom> q = new LinkedList<>();
          HashMap<Integer, Node> map = new HashMap<>();

          int min = 0, max = 0;
          q.add(new Infom(root, 0));
          q.add(null);

          while(!q.isEmpty()){
            Infom curr = q.remove();
            if(curr == null){
               if(q.isEmpty()){
                break;
               }else{
                q.add(null);
               }
            }
            else{

                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);     
                }
    
                if(curr.node.left != null){
                    q.add(new Infom(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Infom(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }

          }

          for(int i = min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
          }
     }

     // kth level node by level order traversing
     public static void kthLevel1(Node root, int k){
         Queue<Node> q = new LinkedList<>();
         q.add(root);
         q.add(null);

         int level = 1;

         while(!q.isEmpty()){
         
            Node currNode = q.remove();

            if(currNode == null){
                if(q.isEmpty()){
                    break;
                }else{
                    level +=1;
                    q.add(null);
                }
            }
            else{
                if(level == k){
                    System.out.print(" "+currNode.data);
                }

                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
            
         }

     }

     //kth level node by recursion
     public static void kthLevel2(Node root,int l, int k){
        if(root == null){
            return;
        }
        if(k==l){
            System.out.print(root.data + " ");
            return;
        }
        kthLevel2(root.left, l+1,k);
        kthLevel2(root.right, l+1,k);
        
     }


     //get path till node (helper)
     public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);

        if(root.data == n){
            return true;
        }
        boolean foundleft = getPath(root.left, n, path);
        boolean foundRigt = getPath(root.right, n, path);

        if(foundleft || foundRigt){
            return true;
        }

        path.remove(path.size()-1);
        return false;
     }
    

     //lowest common ancestor (LCA):
     public static Node lca(Node root, int n1, int n2){
         ArrayList<Node> path1 = new ArrayList<>();
         ArrayList<Node> path2 = new ArrayList<>();

         getPath(root, n1, path1);
         getPath(root, n2, path2);

         //last common ancestor
         int i =0;
         for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
         }

         //last equal node -> i-1th
         Node lca = path1.get(i-1);
         return lca;
     }

     //approach 2
     public static Node lca2(Node root, int n1, int n2){

        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lca2(root.left,n1,n2);
        Node rightlca = lca2(root.right,n1,n2);

        //leftLca=val rightLca = null;
        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }

        return root;

     }

     //min distance between nodes
     public static int lcaDist(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }

     }

     public static int minDist(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);
        return dist1+dist2;
     }

     //kth ancestor of node
     public static int kAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);
        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
     }

     //transform to sum tree
     public static int transformSum(Node root){
        if(root == null){
            return 0;
        }
        int leftChild =  transformSum(root.left);
        int rightChild = transformSum(root.right);
        int data = root.data;
        int newLeft = root.left == null? 0: root.left.data;
        int newRigt = root.right == null? 0: root.right.data;
        root.data = newLeft + leftChild + newRigt + rightChild;
        return data;
     }


     //check if a binary tree is univalued or not
     public static boolean helper(Node root, int data){
        if(root == null){
            return true;
        }
        if(root.data != data){
            return false;
        }
        return helper(root.left, data) && helper(root.right, data);
     }
     public static boolean isUnivalued(Node root){
        if(root == null){
            return true;
        }
        return helper(root,root.data);
     }

     //invert binary tree
     public static void invertTree(Node root){
        if(root == null){
            return;
        }

        invertTree(root.left);
        invertTree(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
     }

    public static Node deleteLeaf(Node root, int x) {
        if (root == null) return null;
    
        root.left = deleteLeaf(root.left, x);
        root.right = deleteLeaf(root.right, x);
    
        if (root.left == null && root.right == null && root.data == x) {
            return null;
        }
    
        return root;
    }

    public static void main(String[] args){
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        int nodes[] = {1,3,3,-1,-1,2,-1,-1,3,3,-1,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        tree.levelOrder(root);
        deleteLeaf(root,3);
        tree.levelOrder(root);
    }
}
