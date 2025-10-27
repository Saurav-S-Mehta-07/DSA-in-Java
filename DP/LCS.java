package DP;
import java.util.*;
//longest common subsequence
//find length of lcs
public class LCS {

    //recursion
    public static int findLCS(String str1, String str2, int n, int m){
        if(n==0 || m==0) return 0;
        if(str1.charAt(n-1) == str2.charAt(m-1)){ //same
               return findLCS(str1, str2, n-1, m-1)+1;   
        }
        else{ //different
             int ans1 = findLCS(str1, str2, n-1, m);
             int ans2 = findLCS(str1, str2, n-1, m-1);
             return Math.max(ans1, ans2);
        }
    }

    //memoization O(n*m)
     public static int findLCS(String str1, String str2, int n, int m, int[][] dp){
        if(n==0 || m==0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(str1.charAt(n-1) == str2.charAt(m-1)){ //same
            return dp[n][m] = findLCS(str1, str2, n-1, m-1, dp)+1;  
        }
        else{ //different
             int ans1 = findLCS(str1, str2, n-1, m,dp);
             int ans2 = findLCS(str1, str2, n-1, m-1,dp);
             return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static void PrintDP(int[][] dp){
        for(int i =0; i<dp.length; i++){
            for(int n : dp[i]){
                System.out.print(n + "   ");
            }
            System.out.println();
        }
    }

    //tabulation O(n*m)
    public static int findLCS(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        //initialize -> when one str is empty
        for(int i = 0; i<dp.length; i++) dp[i][0] = 0; //str1 is empty
        for(int j = 0; j<dp[0].length; j++) dp[0][j] = 0; //str2 is empty

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        PrintDP(dp);

        return dp[n][m];
    }

    public static void main(String[] args) {
    
      //using recursion
      String str1 = "abcde", str2 = "ace"; //ans = 3 (ace)
      int res1 = findLCS(str1, str2, str1.length(), str2.length());
      System.out.println(res1);

      //using memoizaiton
      String str3 = "abcdge", str4 = "abedg"; //ans = 4 (abdg)
      int dp[][] = new int[str3.length()+1][str4.length()+1];
      for(int i = 0; i<dp.length; i++){
        Arrays.fill(dp[i],-1);
      }
      int res2 = findLCS(str3, str4, str3.length(), str4.length(),dp);
      System.out.println(res2);

      //using tabulation
      String str5 = "abc", str6 = "ac";
      int res3 = findLCS(str5, str6);
      System.out.println(res3);


    }    

}
