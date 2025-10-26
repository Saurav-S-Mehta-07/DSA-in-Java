package DP;

//coin change ->variation of unbounded Knapsack

public class CoinChange {

    //tabulation
    public static int printWays(int[] coins, int sum){
        int n = coins.length;
        int[][] dp = new int[n+1][sum+1];

        for(int i = 0; i<dp.length; i++) dp[i][0] = 1;
        for(int j = 1; j<dp[0].length; j++) dp[0][j] = 0;

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<sum+1; j++){
               //valid
               if(coins[i-1]<=j){
                   int includedAns = dp[i][j-coins[i-1]];
                   int excludedAns = dp[i-1][j];
                   dp[i][j] = includedAns + excludedAns;
               }
               //invalid
               else{
                 dp[i][j] = dp[i-1][j];
               }
            }
        }
        printDp(dp);
        return dp[n][sum];
    }

    public static void printDp(int[][] dp){
        System.out.println();
        for(int i = 0; i<dp.length; i++){
            for(int j =0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int coins[] = {1,2,3};
        // int sum = 4; //-> ans = 4

        int coins[] = {2,5,6,3};
        int sum = 6;
        

        System.out.println(printWays(coins, sum));
    }

}