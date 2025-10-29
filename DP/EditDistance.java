package DP;


//Edit distance
public class EditDistance {

    //recursion
    public static int minOperation(String word1, String word2, int n, int m){
        if(n==0) return m; // m op to insert
        if(m==0) return n; // n op to delete

        if(word1.charAt(n-1) == word2.charAt(m-1)){
            return minOperation(word1, word2, n-1, m-1);
        }
        else{
            int ans1 = minOperation(word1, word2, n, m-1) + 1;
            int ans2 = minOperation(word1, word2, n-1, m) + 1;
            int ans3 = minOperation(word1, word2, n-1, m-1) + 1;
            return Math.min(ans1, Math.min(ans2, ans3));
        }
    }

    //tabulation
    public static int minOperation(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i = 0; i<n+1; i++) dp[i][0] = i; //i deletion
        for(int j =0; j<m+1; j++) dp[0][j] = j; // j insertion

        for(int i =1; i<n+1; i++){
            for(int j =1; j<m+1; j++){
                //same
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                //diff
                else{
                    int ans1 = dp[i][j-1] + 1; //add
                    int ans2 = dp[i-1][j] + 1; //delete
                    int ans3 = dp[i-1][j-1] + 1; //replace
                    dp[i][j] = Math.min(ans1, Math.min(ans2, ans3));
                }
            }
        }
        return dp[n][m];
    }
    
    public static void main(String[] args){
       String word1 = "intention", word2 = "execution";
       int result = minOperation(word1, word2, word1.length(), word2.length());
       System.out.println(result);

       //tabulation ans
       System.out.println(minOperation(word1, word2));
    }
}
