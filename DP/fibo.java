package DP;
import java.util.Scanner;

public class fibo { // O(n)
    public static int fib(int n, int[] f) {
        if (n == 0 || n == 1) return n; // Base cases
        else if (f[n] != 0) return f[n]; // Return cached result if available
        // Recursive calls with memoization
        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        int[] f = new int[n + 1]; // DP array to store computed Fibonacci values
        System.out.println("Fibonacci(" + n + ") = " + fib(n, f));
    }
}
