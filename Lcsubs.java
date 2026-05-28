public class Lcsubs {
    static int solve(int index1, int index2, String s1, String s2,int[][] dp){
        if(index1<0||index2<0) return 0;
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        if(s1.charAt(index1)==s2.charAt(index2)) return dp[index1][index2]=1+solve(index1-1,index2-1,s1,s2,dp);
        return dp[index1][index2]=Math.max(solve(index1-1,index2,s1,s2,dp),solve(index1,index2-1,s1,s2,dp));
    }
    static int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        for(int i=0;i<=n1;i++) dp[i][0] = 0;
        for(int j=0;j<=n2;j++) dp[0][j] = 0;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n1][n2];
    }
}
