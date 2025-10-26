package DP;
import java.util.*;
//count ways to reach the nth stair.
//The person can climb either 1 stair or 2 stairs at a time.

public class ClimbingStairs {

    //recursion
    public static int countWays(int n){
          if(n<0) return 0;
          if(n==0) return 1;
          return countWays(n-1)+countWays(n-2);
    }

    //recursion (memoization)
    public static int countWaysM(int n, int[] ways){
        if(n<0) return 0;
        if(n==0) return 1;
        if(ways[n]!=-1) return ways[n];
        ways[n] =  countWaysM(n-1, ways) + countWaysM(n-2, ways);
        return ways[n];
    }

    //tabulation
    public static int countWaysT(int n){
        if(n<0) return 0;
        int dp[] = new int[n+1];        
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        } 
        return dp[n];
    }
    public static void main(String[] args){
        //recursion
        // System.out.println(countWays(5));

        //memoization
        int n = 5;
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        // System.out.println(countWaysM(n, ways));

        //tabulation
        System.out.println(countWaysT(n));
        
    }

}
