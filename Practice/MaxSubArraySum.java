package Practice;

public class MaxSubArraySum {

    // Brute force approach -> O(n^3)
    // c + c + n[n[c+n[c]+c]] + c => O(n^3)
    public static void maxSubArrSumM1(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // -> n
            for (int j = i; j < n; j++) { // -> n
                int currSum = 0;
                for (int k = i; k <= j; k++) { // -> n
                    currSum = currSum + arr[k];
                }
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println("maxSum of Subarray O(n^3) = " + maxSum);
    }

    // using prefix Sum -> O(n^2)
    // n + n[n] => n + n^2
    public static void maxSubArrSumM2(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int maxSum = Integer.MIN_VALUE;
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) { // -> n
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = 0; i < n; i++) { // -> n
            for (int j = i; j < n; j++) { // -> n
                int currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(currSum, maxSum);
            }
        }

        System.out.println("MaxSubArr sum O(n^2) = " + maxSum);
    }

    // using kadanes algo O(n)
    // n + n => 2n => n
    public static void maxSubArrSumM3(int[] arr) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) { // ->n
            ms = Math.max(arr[i], ms);
        }

        if (ms < 0) {
            System.out.println("maxSum of subarray O(n): " + ms);
            return;
        }

        ms = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) { // -> n
            cs = cs + arr[i];
            if (cs < 0)
                cs = 0;
            ms = Math.max(cs, ms);
        }

        System.out.println("maxSum of subarray O(n): " + ms);
    }

    public static void main(String[] args) {
        int arr[] = { -1, -2, 4, -2, -1, 1, 5, -3 };
        maxSubArrSumM1(arr);
        maxSubArrSumM2(arr);
        maxSubArrSumM3(arr);
    }
}