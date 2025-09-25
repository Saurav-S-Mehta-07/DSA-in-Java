import java.util.Deque;
import java.util.LinkedList;

public class maxAllSub {

    // Function to print maximum of each subarray of size k
    static void printMax(int arr[], int n, int k) {
        // Deque to store indices of useful elements
        Deque<Integer> dq = new LinkedList<>();

        // Process first k elements
        for (int i = 0; i < k; i++) {
            // Remove smaller elements from the back
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        // Process rest of the array
        for (int i = k; i < n; i++) {
            // The element at the front is the largest of the previous window
            System.out.print(arr[dq.peek()] + " ");

            // Remove elements out of this window
            while (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.removeFirst();
            }

            // Remove all elements smaller than current from the back
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }

        // Print maximum of the last window
        System.out.print(arr[dq.peek()]);
    }
  

    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;

        printMax(arr, arr.length, k);
    }
}
