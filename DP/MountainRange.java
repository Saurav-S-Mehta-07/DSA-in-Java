package DP;
//Mountains and Valleya
public class MountainRange {
    
    //tabulation O(n^2)
    public static int noOfMountainRange(int pairs){
        int dp[] = new int[pairs+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i<pairs+1; i++){
            //i pairs=> mountain ranges => Ci
            for(int j = 0; j<i; j++){ //Ci = Cj*Ci-j-1
                int innerPair = dp[j];
                int outerPair = dp[i-j-1];
                dp[i] += innerPair * outerPair;
            }
        }
        return dp[pairs];
    }
    public static void main(String[] args) {
        int pairs = 4;
        int result = noOfMountainRange(pairs);
        System.out.println(result); //14
    }

}
