package DP;

import java.util.Arrays;

//matrix chain multiplication 

public class MCM {

    public static int findMinCost(int[] arr, int i, int j){
        if( i==j ) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k = i; k<=j-1; k++){
            int cost1 = findMinCost(arr, i, k); //Ai....Ak => arr[i-1] x arr[k]-> a x b
            int cost2 = findMinCost(arr, k+1, j); //Ak+1... Aj => arr[k] x arr[j]->c x d
            int cost3 = arr[i-1] * arr[k] * arr[j]; //a * b * d
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans; //minCost
    }

    public static int findMinCost(int[] arr, int i, int j,int[][] dp){
        if( i==j ) return dp[i][j] = 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k<=j-1; k++){
            int cost1 = findMinCost(arr, i, k,dp); //Ai....Ak => arr[i-1] x arr[k]-> a x b
            int cost2 = findMinCost(arr, k+1, j, dp); //Ak+1... Aj => arr[k] x arr[j]->c x d
            int cost3 = arr[i-1] * arr[k] * arr[j]; //a * b * d
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    }

    public static void printDP(int[][] dp){
        for(int[] row : dp){
            for(int el : row){
                System.out.print(" " + el);
            }
            System.out.println();
        }
    }

    public static int mcmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i = 0; i<n; i++){
            dp[i][i] = 0;
        }
 
        //bottom up
        for(int len = 2; len<=n-1; len++){
            for(int i = 1; i<=n-len; i++){
                int j = i+len-1; //col
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k<=j-1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        printDP(dp);
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3}; //find min cost
        int dp[][] = new int[arr.length][arr.length];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        int minCost = mcmTab(arr);
        System.out.println(minCost);
    }
}
 