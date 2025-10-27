package DP;
// same as unbounded knapsack
public class RodCutting {

    public static int findMaxProfit(int[]lengths, int[]prices, int rl){
        int n = lengths.length;
        int[][]dp = new int[n+1][rl+1];
        for(int i = 0; i<n+1; i++) dp[i][0] = 0;
        for(int j =0; j<rl+1; j++) dp[0][j] = 0;

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                //valid
                if(lengths[i-1]<=j){
                    dp[i][j] = Math.max((prices[i-1]+dp[i][j-lengths[i-1]]), dp[i-1][j]);
                }
                //invalid
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printDP(dp);
        return dp[n][rl];
    }

    public static void printDP(int[][] dp){
        System.out.println();
        for(int i = 0; i<dp.length; i++){
            for(int n : dp[i]){
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
         int lengths[] = {1,2,3,4,5,6,7,8};
         int prices[] = {1,5,8,9,10,17,17,20};
         int rodlength = 8;
         System.out.println(findMaxProfit(lengths, prices, rodlength));
    }

}
