package DP;

public class WildcardMatching {

    public static boolean isMatching(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true; // empty string matches empty pattern
        for(int i = 1; i<n+1; i++) dp[i][0] = false; //p = ""
        // pattern starts with * can match empty string 
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
            else dp[0][j] = false;
        }

        // main DP logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "abc", p = "ab*"; //true
        //  s="abd"; p = "ab?"; //true
        //  s = "abc"; p = "*"; //true
         s = "acb"; p = "??"; //false
        System.out.println(isMatching(s, p)); 
    }
}
