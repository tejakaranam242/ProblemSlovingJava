public class DistinctOccurences {
    static int solve(String s1, String s2, int n1, int n2, int[][] dp){
        if(n2<0) return 1;
        if(n1<0) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];
        if(s1.charAt(n1)==s2.charAt(n2)) return dp[n1][n2] = solve(s1,s2,n1-1,n2-1,dp)+solve(s1,s2,n1-1,n2,dp);
        else return dp[n1][n2] = solve(s1,s2,n1-1,n2,dp);
    }
    public int subseqCount(String txt, String pat) {
        int n1 = txt.length();
        int n2 = pat.length();
        int[][] dp = new int[n1][n2];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(txt,pat,n1-1,n2-1,dp);
    }
}
