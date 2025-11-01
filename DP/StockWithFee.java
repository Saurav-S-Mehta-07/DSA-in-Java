
//check later 

// package DP;

// class Solution {
//     // O(n^2) time, O(1) space
//     static void max_profit(int[] prices, int[] result, int n, int fee) {
//         int maxTotalProfit = 0;
//         int maxSingleProfit = 0;
//         int bestDayDiff = 0;

//         // Try every possible buy day
//         for (int i = 0; i < n; i++) {
//             int totalProfit = 0;

//             // Try every possible sell day after buy day
//             for (int j = i + 1; j < n; j++) {
//                 int profit = prices[j] - prices[i] - fee;

//                 if (profit > 0) {
//                     totalProfit += profit;

//                     // Track largest single transaction
//                     if (profit > maxSingleProfit) {
//                         maxSingleProfit = profit;
//                         bestDayDiff = j - i;
//                     }
//                 }
//             }

//             maxTotalProfit = Math.max(maxTotalProfit, totalProfit);
//         }

//         result[0] = maxTotalProfit;
//         result[1] = bestDayDiff;
//     }

//     public static void main(String[] args) {
//         int arr[] = {6, 1, 7, 2, 8, 4};
//         int n = arr.length;
//         int[] b = new int[2];
//         int tranFee = 2;

//         max_profit(arr, b, n, tranFee);
//         System.out.println(b[0] + ", " + b[1]); // ✅ Output: 8, 1
//     }
// }
