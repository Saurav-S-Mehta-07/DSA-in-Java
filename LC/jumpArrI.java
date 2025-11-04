package LC;
//can we reach end from start
public class jumpArrI {
    public static boolean canReach(int arr[]){
        int n = arr.length;
        boolean dp[] = new boolean[n];
        dp[n-1] = true;

        for(int i = n-2; i>=0; i--){
            int steps = arr[i];
            for(int j = i+1; j<=i+steps && j<n; j++){
                if(dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int arr[]  =  {2,3,1,1,4};
        System.out.println(canReach(arr)); //true

        int arr2[] = {2,2,1,0,4};
        System.out.println(canReach(arr2)); //false
    }
}
