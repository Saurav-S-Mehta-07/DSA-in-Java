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
    public static int count = 1;

    public static void insertInTree(String word){
        Node curr = root;
        for(int i =0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] ==  null){
                count++;
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static void main(String args[]){
        
       String str = "ababa";

       for(int i = 0; i<str.length(); i++){
            insertInTree(str.substring(i));
       }

       System.out.println("total unique substring : " + count);

    }

}
