package Hashing;
import java.util.*;
public class ValidAnagram {

    public static boolean isAnagram(String s, String t){

        if(s.length() != t.length()) return false;

       HashMap<Character, Integer> map = new HashMap<>();

       for(int i = 0; i<s.length(); i++){
         map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
       }

       for(int i = 0; i<t.length(); i++){
        int value = map.getOrDefault(t.charAt(i), 0);
        if(value == 0) return false;
        map.put(t.charAt(i), value - 1);
       }
       return true;
    }
    public static void main(String args[]){
        String s  = "race";

        String t =  "caae";

        System.out.println(isAnagram(s,t));
    }
}
