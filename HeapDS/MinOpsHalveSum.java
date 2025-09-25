package Java.HeapDS;
import java.util.*;

public class MinOpsHalveSum {
    public static int minOperations(int[] arr) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        double sum = 0;
        for (int x : arr) {
            sum += x;
            maxHeap.add((double)x);
        }
        
        double target = sum / 2.0;
        double curr = sum;
        int ops = 0;
        
        while (curr > target) {
            double largest = maxHeap.poll();
            double half = largest / 2.0;
            curr -= (largest - half);  // reduce from sum
            maxHeap.add(half);
            ops++;
        }
        
        return ops;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 19};
        System.out.println("Minimum Operations: " + minOperations(arr)); // 3
    }
}
