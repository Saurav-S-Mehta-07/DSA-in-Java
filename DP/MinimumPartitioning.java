package DP;

//minimum partitioning/ minimum subset sum difference/ partitioning subset
//(variation of 0-1 knapsack)
public class MinimumPartitioning {

    public static int minPartition(int [] numbers){
        int n  = numbers.length;
        int sum = 0;

        for(int i = 0; i<n; i++){
            sum+=numbers[i];
        }
 
        int W = sum/2;
        int dp[][] = new int[n][W+1];
        
        for(int i = 0; i<n; i++) dp[i][0] = 0;
        for(int j = 0; j<W; j++) dp[0][j] = 0;

        for(int i = 1; i<n; i++){
            for(int  j = 1; j<W+1; j++){
                //valid
                if(numbers[j-1] <= j){
                    //include
                    int ans1 = numbers[j-1] + dp[i-1][j-numbers[j-1]];

                    //exclude
                    int ans2 = dp[i-1][j];

                    dp[i][j] = Math.max(ans2, ans1);
                }
                //invalid
                else{
                    //exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum2-sum1);
    }

    public static void printDP(int[][] dp){
        for(int[] row : dp){
            for(int el : row){
                System.out.print(" " + el);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int numbers[] = {1,6,11,5};
        int res = minPartition(numbers);
        System.out.println(res);
    }
}
