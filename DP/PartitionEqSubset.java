package DP;

class  PartitionEqSubset {

    public static boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0; 
        for(int i  = 0; i<n; i++) sum+=nums[i];

        if(sum%2!=0) return false; //odd sum
     
        int res = helper(nums, n, sum/2, sum);

        return res==0;
    }

    public static int helper(int nums[],int n, int W, int sum){
        W = sum/2;
        int dp[][] = new int[n+1][W+1];
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<W+1; j++){
                //valid
                if(nums[i-1]<=j){
                    //include
                     int ans1 = nums[i-1] + dp[i-1][j-nums[i-1]];
                    //exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
                //invalid
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum-sum1;
        return Math.abs(sum2-sum1);
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,5};
        System.out.println(canPartition(nums));
    }
}