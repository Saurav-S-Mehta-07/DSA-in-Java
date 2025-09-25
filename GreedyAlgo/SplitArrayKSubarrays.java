package Java.GreedyAlgo;
public class SplitArrayKSubarrays {

    // Check if we can split into <= K parts with max subarray sum <= mid
    public static boolean canSplit(int[] arr, int k, int mid) {
        int count = 1;  // start with 1 subarray
        int sum = 0;

        for (int num : arr) {
            if (sum + num > mid) {
                count++;
                sum = num;
                if (count > k) return false;
            } else {
                sum += num;
            }
        }
        return true;
    }

    public static int splitArray(int[] arr, int k) {
        int max = 0, sum = 0;
        for (int num : arr) {
            max = Math.max(max, num);
            sum += num;
        }

        int low = max, high = sum, ans = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(arr, k, mid)) {
                ans = mid;      // valid, try smaller
                high = mid - 1;
            } else {
                low = mid + 1;  // too small, increase
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2};
        int k1 = 2;
        System.out.println(splitArray(arr1, k1)); // Output: 2

        int[] arr2 = {1, 2, 3, 4};
        int k2 = 3;
        System.out.println(splitArray(arr2, k2)); // Output: 4

        int[] arr3 = {7, 2, 5, 8};
        int k3 = 2;
        System.out.println(splitArray(arr3, k3)); // Output: 13
    }
}
