package DP;

public class TargetSum {

    public static boolean isSumTarget(int[]nums, int ts){
        int n = nums.length;
        boolean[][]dp = new boolean[n+1][ts+1];

        for(int i = 0; i<dp.length; i++) dp[i][0] = true;
        for(int j = 1; j<dp[0].length; j++) dp[0][j] = false;

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<ts+1; j++){
                if(nums[i-1]<=j && dp[i-1][j-nums[i-1]]){//valid
                    //included
                    dp[i][j] = true;
                } 
                //exclude
                else if(dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }

        // printDp(dp);
        
        return dp[n][ts];
    }

    public static void printDp(boolean[][] dp){
        System.out.println();
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                if(dp[i][j]){
                    System.out.print(" T ");
                }
                else{
                    System.out.print(" F ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args){
       int nums[] = {4,2,7,1,3};
       int target = 10;
       System.out.println(isSumTarget(nums,target));
    }
}
