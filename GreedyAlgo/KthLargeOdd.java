package Java.GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;

public class KthLargeOdd {
    //Kth largest Odd number in a given range
    //O(nlogn)
    public static int findkthOdd(int l, int r, int k){

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = l; i<=r; i++){
            if(i%2!=0){
               arr.add(i);
            }
        }
        Collections.sort(arr,(a,b)->b - a);
        
        int n = arr.size();

        return k>n? 0: arr.get(k-1);
        
    }

    //O(1)
    public static int kthOdd(int[] range, int K) {
        if (K <= 0) return 0; // invalid input

        int L = range[0];
        int R = range[1];

        // Case 1: If R is odd
        if ((R & 1) == 1) {
            // Count how many odd numbers exist in range
            int count = (int) Math.ceil((R - L + 1) / 2.0);
            if (K > count) return 0; // Not enough odds
            else return R - 2 * (K - 1);
        } 
        // Case 2: If R is even
        else {
            int count = (R - L + 1) / 2;
            if (K > count) return 0;
            else return (R - 1) - 2 * (K - 1);
        }
    }

    public static void main(String[] args){
        int l = -3, r= 10, k = 1;
        System.out.println(findkthOdd(l,r,k));
    }
}
