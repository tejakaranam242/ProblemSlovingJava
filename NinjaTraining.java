public class NinjaTraining {
    // static int maxResult(int day,int last,int[][] mat,int[][] dp){
    //     if(day==0){
    //         int maxi=0;
    //         for(int i=0;i<3;i++){
    //             if(i!=last){
    //                 maxi = Math.max(maxi,mat[0][i]);
    //             }
    //         }
    //         return maxi;
    //     }
    //     if(dp[day][last]!=0) return dp[day][last];
    //     int maxi = 0;
    //     for(int i=0;i<3;i++){
    //         if(i!=last){
    //             int point = mat[day][i] + maxResult(day-1,i,mat,dp);
    //             maxi = Math.max(maxi,point);
    //         }
    //     }
    //     return dp[day][last] = maxi;
    // }
    public int maximumPoints(int mat[][]) {
        int[][] dp = new int[mat.length][4];
        dp[0][0] = Math.max(mat[0][1],mat[0][2]);
        dp[0][1] = Math.max(mat[0][0],mat[0][2]);
        dp[0][2] = Math.max(mat[0][1],mat[0][0]);
        dp[0][3] = Math.max(mat[0][0],Math.max(mat[0][1],mat[0][2]));
        for(int day=1;day<mat.length;day++){
            for(int task=0;task<4;task++){
                for(int i=0;i<3;i++){
                    if(i!=task){
                        int point = mat[day][i]+dp[day-1][i];
                        dp[day][task] = Math.max(dp[day][task],point);
                    }
                }
            }
        }
        return dp[mat.length-1][3];
    }
}
