package DP;

//Unbounded knapsack
import java.util.*;;
public class UnboundedKnapsack {

    //tabulation
    public static int unboundKnapsack(int val[], int wt[], int W){
        int n = val.length;
        int [][] dp  = new int[n+1][W+1];
        for(int i = 0; i<dp.length; i++){ //0th col
            dp[i][0] = 0;
        }
        for(int j = 0; j<dp[0].length; j++){ //0th row
            dp[0][j] = 0;
        }

        for(int i = 1; i<n+1; i++){
           for(int j =1; j<W+1; j++){
            if(wt[i-1] <= j){//valid
              dp[i][j] = Math.max((val[i-1]+dp[i][j-wt[i-1]]), dp[i-1][j]);
            }
            else{//invalid
                dp[i][j] = dp[i-1][j];
            }
           }
        }

        //print dp
 
        // System.out.println();
        //     for(int i = 0; i<dp.length; i++){
        //     for(int j = 0; j<dp[0].length; j++){
        //         if(dp[i][j]==0){
        //             System.out.print(dp[i][j] + "  ");
        //         }else{
        //           System.out.print(dp[i][j] + " ");
        //         }
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(unboundKnapsack(val, wt, W));
        System.out.println();
    }
}
