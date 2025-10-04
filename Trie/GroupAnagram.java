//group anagram together

package Trie;

import java.util.*;

public class GroupAnagram{

    public static void groupAnagram(String str[]){

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String s : str) {
            // Sort the string to create a key
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            // Group words by their sorted form
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        for(ArrayList<String> s : map.values()){
            System.out.println(s);
        }
    }

    public static void main(String [] args){
        String str[] = {"eat", "ate", "tea", "nat", "tan", "bat"};
        groupAnagram(str);
    }

}