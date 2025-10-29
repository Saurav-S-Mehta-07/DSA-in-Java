package DP;


//string conversion -> deletion & insertion
public class StrConversion {

    //tabulation
    public static void dltInsertOp(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i = 0; i<n+1; i++) dp[i][0] = 0; 
        for(int j =0; j<m+1; j++) dp[0][j] = 0; 

        //lcs
        for(int i =1; i<n+1; i++){
            for(int j =1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    int ans1 = dp[i][j-1]; 
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        //lcs length at dp[n][m]
        int lcs = dp[n][m];
        int dltOp = n - lcs;
        int instOp = m - lcs;

        System.out.println("delete op: " + dltOp );
        System.out.println("Insert Op: " + instOp);
    }
    
    public static void main(String[] args){
       String str1 = "pear", str2 = "sea";

       //tabulation ans
       dltInsertOp(str1, str2);
    }
}
