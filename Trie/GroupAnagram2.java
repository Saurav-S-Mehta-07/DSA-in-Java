package Trie;

import java.util.*;

public class GroupAnagram2 {

    public static class Node{
        ArrayList<String> list = new ArrayList<>();
        Node children[] = new Node[26];
        boolean eow = false;
        Node(){
            for(int i = 0; i<26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
       char[] ch = word.toCharArray();
       Arrays.sort(ch);
       String temp = new String(ch);
       Node curr = root;
       for(int i = 0; i<temp.length(); i++){
        int idx = temp.charAt(i)-'a';
        if(curr.children[idx] == null){
            curr.children[idx] = new Node();
        }
        curr = curr.children[idx];
       }
       curr.eow = true;   
       curr.list.add(word);
    }

    public static ArrayList<ArrayList<String>> ans = new ArrayList<>();
    public static void groupAnagram(Node root){
        Node curr = root;
        if(curr.eow == true){
             ans.add(curr.list);
        }
        for(int i = 0; i<26; i++){
            if(curr.children[i]!=null){
                groupAnagram(curr.children[i]);
            }
        }   
    }
    
   public static void main(String[] args){
      String[] str = {"tea", "ate", "eat", "nat", "tan", "bat"};
      for(int i =0; i<str.length;  i++){
        insert(str[i]);
      }
      groupAnagram(root);
      System.out.println(ans);
   }

}
