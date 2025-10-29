package DP;

import java.util.Arrays;

public class CatalansNumber {

    //recursion  -> tc: O(2^n) sc: O(2^n)
    public static int catalanRec(int n){
        if(n==0 || n==1) return 1;
        int ans=0;
        for(int i = 0; i<n; i++){
           ans+=catalanRec(i)*catalanRec(n-i-1);
        }
        return ans;
    }
    
    //memoization -> tc: O(n^2) , sc: O(n)
    public static int catalanMemo(int n, int[] dp){
        if(n==0 || n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int ans  = 0;
        for(int i = 0; i<n; i++){
            ans+=catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }
        return dp[n] = ans;
    }

    //tabulation -> tc: O(n^2), sc: O(n)
    public static int catalanTab(int n){
        int[] dp = new int[n+1]; //table creation
        dp[0] = dp[1] = 1; //initialization

        for(int i = 2; i<n+1; i++){
            for(int j = 0; j<i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        } 
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("recursion: " + catalanRec(n));

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("memoization: " + catalanMemo(n, dp));

        System.out.println("tabulation: " + catalanTab(n));
    }

}
