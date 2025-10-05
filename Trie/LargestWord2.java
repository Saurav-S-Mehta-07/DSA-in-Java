package Trie;

public class LargestWord2 {

    public static class  Node{
         Node children[] = new Node[26];
         boolean eow  = false;
         Node(){
            for(int i = 0; i<26; i++){
                children[i]  = null;
            }
         }
    } 

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static String res = "";
    public static void LargestWord2(Node root, StringBuilder temp){
         Node curr=root;
         for(int i = 0; i<26; i++){
            if(curr.children[i]!=null && curr.children[i].eow==true){
                 char ch = (char)(i+'a');
                 temp.append(ch);

                 if(temp.length() > res.length()) res = temp.toString();
                 LargestWord2(curr.children[i], temp);
                 temp.deleteCharAt(temp.length()-1);
            }
         }
    }
    
    public static void main(String[] args){
        String words[] = {"wo", "w", "wor", "worl", "world", "word"};
        for(int i = 0; i<words.length; i++){
            insert(words[i]);
        }

        LargestWord2(root, new StringBuilder(""));
        System.out.println("largest word in dictionary: " + res);
    }
}
