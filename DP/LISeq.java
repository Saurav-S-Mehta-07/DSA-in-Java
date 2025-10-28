package DP;

import java.util.Arrays;
import java.util.HashSet;

//longest increasing subsequence (variation of LCS)

public class LISeq {
    
    //tabulation
    public static int LCS(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];
        
        for(int i = 1; i<n+1; i++){
            for(int j =1; j<m+1; j++){
               if(arr1[i-1]==arr2[j-1]){
                  dp[i][j] = dp[i-1][j-1] + 1;
               }
               else{
                 int ans1 = dp[i-1][j];
                 int ans2 = dp[i][j-1];
                 dp[i][j] = Math.max(ans1, ans2);
               }
            }
        }
      
        return dp[n][m];
    }
    public static void main(String[] args){
        int arr[] = {50,3,10,7,40,80}; //ans = 4
        
        //step 1-> sort+asending (unique elements)
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        
        int i = 0;
        int arr2[] = new int[set.size()];
        for(int el : set){
            arr2[i] = el;
            i++;
        }
        Arrays.sort(arr2);

        //step 2 -> do LCS of arr and arr2
        int LIS = LCS(arr,arr2);
        System.out.println(LIS);

    }

}
