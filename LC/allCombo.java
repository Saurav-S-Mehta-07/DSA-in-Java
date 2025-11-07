package  LC;
import java.util.*;
public class allCombo {
    public static List<String> letterCombinations(String digits) {
       List<String> list = new ArrayList<>();
       if(digits == "1" || digits==null) return list;
       backtrack(0,digits,new StringBuilder(), list);
       return list;
    }
    public static void backtrack(int pos, String digits, StringBuilder ans, List<String> list){
        if(pos == digits.length()){
            list.add(ans.toString());
            return;
        }

        String letters = getLetters(digits.charAt(pos));
        for(int i =0; i<letters.length(); i++){
            ans.append(letters.charAt(i));
            backtrack(pos+1, digits, ans, list);
            ans.deleteCharAt(ans.length()-1);
        }
    }


    public static String getLetters(char num){
        switch(num){
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
        }
        return "";
    }

    public static void main(String[] args){
        String digits = "23";
        List<String> list = letterCombinations(digits);
        for(String s : list) System.out.print(s + " ");
    }
}