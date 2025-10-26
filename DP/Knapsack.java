package DP;

//0-1 Knapsack
import java.util.*;;
public class Knapsack {

    public static int findProfit(int val[], int wt[], int W, int n){
        if(W==0 || n==0) return 0;
        if(wt[n-1] <= W){ //valid
           //include
          int ans1 =  val[n-1] + findProfit(val, wt, W-wt[n-1], n-1);
          //exclude
          int ans2  = findProfit(val, wt, W, n-1);

          return Math.max(ans1, ans2);
        }
        else{ //not valid
            //exclude
            int ans2  = findProfit(val, wt, W, n-1);
            return ans2;
        }
    }

    //memoization
    public static int findProfitM(int val[], int wt[], int W, int n, int[][] dp){
        if(W==0 || n==0) return 0;
        if(dp[n][W]!=-1) return dp[n][W];
        if(wt[n-1] <= W){ //valid
           //include
          int ans1 =  val[n-1] + findProfitM(val, wt, W-wt[n-1], n-1,dp);
          //exclude
          int ans2  = findProfitM(val, wt, W, n-1,dp);
          dp[n][W] = Math.max(ans1, ans2);
          return Math.max(ans1, ans2);
        }
        else{ //not valid
            //exclude
            int ans2  = findProfitM(val, wt, W, n-1,dp);
            dp[n][W] = ans2;
            return ans2;
        }
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        int dp[][] = new int[val.length+1][W+1];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(findProfitM(val, wt, W, val.length, dp));
    }
}
