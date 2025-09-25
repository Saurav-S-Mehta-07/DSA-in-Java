package Java.Backtracking;
public class Keypad {

    final static char[][] L = {
        {},
        {},
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'}
    };

    public static void letterCombination(String digits){
        int len = digits.length();
        if(len==0){
            System.out.println("");
            return;
        }
        bfs(0,len,new StringBuilder(), digits);
    }

    public static void bfs(int pos, int len, StringBuilder sb,String digits){
        if(pos==len){
            System.out.print(sb + " ");
            return;
        }
        else{
            char[] letters = L[Character.getNumericValue(digits.charAt(pos))];
            for(int i = 0; i<letters.length; i++){
                bfs(pos+1, len, new StringBuilder(sb).append(letters[i]), digits);
            }
        }
    }

    static String[] keypad={
        "",//0
        "",//1
        "abc",//2
        "def",//3
        "ghi",//4
        "jkl",//5
        "mno",//6
        "pqrs",//7
        "tuv",//8
        "wxyz"//9
    };

    public static void generateCombination(String digits, int index, String current){
        if(index==digits.length()){
            System.out.print(current+" ");
            return;
        }

        String letters = keypad[digits.charAt(index)-'0'];

        for(int i = 0; i<letters.length(); i++){
            generateCombination(digits, index+1, current+letters.charAt(i));
        }
    }

     public static void main(String args[]){
        String digits = "234";
        if(digits.isEmpty()){
            System.out.println("");
            return;
        }

        // generateCombination(digits, 0, "");

        letterCombination(digits);

     }
}