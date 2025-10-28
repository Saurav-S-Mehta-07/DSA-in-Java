package DP;

public class LCSubStr {
 
    static int res = 0;
    public static int LCSubString(String s1, String s2, int n, int m){
         if(n==0 || m==0) return 0;

         if(s1.charAt(n-1) == s2.charAt(m-1)){
            int ans1 = LCSubString(s1, s2,n-1,m-1)+1;
            res = Math.max(res, ans1);
            return ans1;
         }
         else{
             return 0;
         }
    }

    //tabulation
    public static int LCSubString(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;
        //initialize
        for(int i= 0; i<n+1; i++) dp[i][0] = 0;
        for(int j =0; j<m+1; j++) dp[0][j] = 0;

        //bottom up
        for(int i =1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

      public static void main(String[] args){
        String s1 = "abcde";
        String s2 = "abgce";

        System.out.println(LCSubString(s1, s2, s1.length(), s2.length())); //2

        s1 = "abcde";
        s2 = "abcdg";
        System.out.println(LCSubString(s1, s2, s1.length(), s2.length())); //4
      }
}