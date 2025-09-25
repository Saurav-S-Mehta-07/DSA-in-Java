package Java.HeapDS;
import java.util.*;

public class minTime {
    public static int minTime(int N, int K, int arr[]) {
        Arrays.sort(arr);

        // Edge distances
        int maxTime = Math.max(arr[0] - 1, N - arr[K - 1]);

        // Check gaps between consecutive filled slots
        for (int i = 1; i < K; i++) {
            int gap = arr[i] - arr[i - 1];
            maxTime = Math.max(maxTime, gap / 2);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        int N1 = 5, K1 = 5;
        int arr1[] = {1, 2, 3, 4, 5};
        System.out.println("Output 1: " + minTime(N1, K1, arr1)); // 0

        int N2 = 6, K2 = 2;
        int arr2[] = {2, 6};
        System.out.println("Output 2: " + minTime(N2, K2, arr2)); // 2
    }
}
