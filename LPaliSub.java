public class LPaliSub {
    static String reverse(String s){
        char[] rev = s.toCharArray();
        int n = s.length()-1;
        int m = 0;
        while(m<n){
            char temp = rev[m];
            rev[m] = rev[n];
            rev[n] = temp;
            n--;
            m++;
        }
        return new String(rev);
    }
    public int longestPalinSubseq(String s) {
        int n = s.length();
        String rev = reverse(s);
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++) dp[i][0] = 0;
        for(int j=0;j<=n;j++) dp[0][j] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}
