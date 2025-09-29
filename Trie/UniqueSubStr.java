package Trie;
public class UniqueSubStr {

    static class  Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node(){
            for(int i =0; i<26; i++){
                children[i]  = null;
            }
        }
        
    }

    public static Node root = new Node();

    public static void insertInTree(String word){
        Node curr = root;
        for(int i =0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] ==  null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i = 0; i<26; i++){
            if(root.children[i] != null){
                count+= countNodes(root.children[i]);
            }
        }
        return count+1;
    }


    public static void main(String args[]){
        
       String str = "ababa";
        
       //suffix
       for(int i = 0; i<str.length(); i++){
            insertInTree(str.substring(i));
       }

       System.out.println("total unique substring : " + countNodes(root));

    }

}
