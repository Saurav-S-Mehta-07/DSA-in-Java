package LC;

import java.util.Arrays;

//min jumps to reach end
public class jumpArrII {

    public static int minJumps(int arr[]){
        int dp[] = new int[arr.length];
        int n = arr.length;
        Arrays.fill(dp, -1);
        dp[n-1] = 0;

        for(int i = n-2; i>=0; i--){
            int steps = arr[i];
            int min = Integer.MAX_VALUE;
            for(int j = i+1; j<=i+steps&& j<n; j++){
                if(dp[j]!=-1){
                   min  = Math.min(min, dp[j]+1);
                }
            }
            if(min!=Integer.MAX_VALUE){
                dp[i] = min;
            }
        }

        return dp[0];
    }
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        System.out.println(minJumps(arr)); //2 => 2-3, 2-4

        int arr2[] = {2,2,1,0,4};
        System.out.println(minJumps(arr2)); //-1 => can't reach end

        int arr3[] = {2,1,1,2,4};
        System.out.println(minJumps(arr3));//3 => 2-1, 1-2, 2-4
    }
}
