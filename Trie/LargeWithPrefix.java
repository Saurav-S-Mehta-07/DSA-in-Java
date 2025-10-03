package Trie;

//largest word with all prefixes

public class LargeWithPrefix {

    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        Node(){
            for(int i =0; i<26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root =  new Node();


    public static void insert(String word){
        Node curr = root;
        for(int i =0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static String str = "";
    public static void largestWordPrefixes(Node root, String word){
        Node curr = root;
        boolean valid = true;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(!curr.children[idx].eow){
                valid  = false;
                break;
            }
            curr = curr.children[idx];
        } 

        if(valid){
            if(word.length()>str.length() ||
               (word.length()==str.length() && word.compareTo(str)<0)){
                 str = word;
            }
        }
    }

    public static void main(String args[]){
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i = 0; i<words.length ; i++){
            insert(words[i]);
        }

        for(int i = 0; i<words.length ; i++){
            largestWordPrefixes(root, words[i]);
        }

        System.out.println(str);
        
    }
}
