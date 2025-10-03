package Trie;

public class LargePrefix2 {

    static class Node{
    
        Node children[] = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i = 0; i<26; i++){
                children[i] = null;
            }
        }
    }

   public static Node root = new Node();


    public static void insertInTrie(String word){
        Node curr = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static String str = "";

    public static void largestWithAllPrefix(Node root, StringBuilder temp){ 
        Node curr = root;
        for(int i = 0; i<26; i++){
            if(curr.children[i]!=null && curr.children[i].eow){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length()>str.length()){
                    str = temp.toString();
                }
                largestWithAllPrefix(curr.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
                curr = curr.children[i];
            }
        }        
    }

    public static void main(String []args){
        String words[] = {"a","app","ap","appl", "apply", "apple","banana"}; //apple
        for(int i = 0; i<words.length; i++){
            insertInTrie(words[i]);
        }
        
       largestWithAllPrefix(root, new StringBuilder());
       System.out.println(str);
    }
     
}