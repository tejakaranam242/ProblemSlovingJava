public class LongCSub {
    static int ans = 0;
    static int solve(String s1, String s2, int n1, int n2, int count) {
        if(n1 == 0 || n2 == 0) return count;
        if(s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            count = solve(s1, s2, n1 - 1, n2 - 1, count + 1);
        }
        ans = Math.max(ans, count);
        solve(s1, s2, n1 - 1, n2, 0);
        solve(s1, s2, n1, n2 - 1, 0);
        return ans;
    }
    public int longCommSubstr(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        int ans = 0;
        for(int i=0;i<=n1;i++) dp[i][0] = 0;
        for(int j=0;j<=n2;j++) dp[0][j] = 0;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }
        return ans;
    }
}
