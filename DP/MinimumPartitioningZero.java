package DP;

// Check if array can be partitioned into two subsets with equal sum (diff = 0)
public class MinimumPartitioningZero {

    public static boolean isMinPartitionZero(int[] numbers) {
        int n = numbers.length;
        int sum = 0;

        for (int num : numbers) sum += num;

        // If total sum is odd, equal partition is impossible
        if (sum % 2 != 0) return false;

        int W = sum / 2;
        boolean[][] dp = new boolean[n + 1][W + 1];

        // Base case: sum = 0 is always possible
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        // DP filling
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (numbers[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - numbers[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        // Return if subset with sum = total/2 exists
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] numbers = {1, 6, 11, 5};
        boolean res = isMinPartitionZero(numbers);
        System.out.println("Is partition difference 0 possible? " + res);
    }
}
