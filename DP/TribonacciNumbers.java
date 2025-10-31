package DP;

import java.util.Arrays;

public class TribonacciNumbers {

    //recursion
    public static int tribonacci(int n){
        if(n==0 || n==1) return 0;
        if(n==2) return 1;
        else return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }

    //memoization
    public static int tribonacci(int n, int dp[]){
        if(n==0||n==1)return 0;
        if(n==2) return  1;
        if(dp[n]!=-1) return dp[n];
        else return dp[n] = tribonacci(n-1,dp)+tribonacci(n-2,dp)+tribonacci(n-3,dp);
    }

    //tabulation
    public static void tribTab(int n, int[] dp){
        dp[0] = dp[1] = 0;
        dp[2] = 1;
        for(int i = 3; i<=n; i++){
           dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
    }

    public static void main(String[] args) {
        int n = 20;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        //recursion + memoization
        // for(int i = 0; i<n; i++){
        //     System.out.print(" " + tribonacci(i));
        // }

        //tabulation
        tribTab(n,dp);
        for(int i = 0; i<n; i++){
            System.out.print(dp[i] + " ");
        }
    }
}
