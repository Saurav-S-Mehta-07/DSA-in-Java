package DP;
//print all combination of balanced parentheses
public class BalancedParentheses {

    static int ways = 0;
    public static void printWays(int n, int open, int close, String curr){
         if(curr.length() == n*2){
            System.out.print(curr + ", ");
            ways++;
            return;
         }

         if(open<n){
            printWays(n, open+1, close, curr+"{");
         }
         if(close<open){
            printWays(n, open, close+1, curr+"}");
         }
    }

    public static void main(String[] args){
        //if n = 1 => {}, n = 2=> {}{}, {{}}
        
        int n = 3;
        printWays(n,0,0,"");
        System.out.println("\nways: "+ ways);

    }
}