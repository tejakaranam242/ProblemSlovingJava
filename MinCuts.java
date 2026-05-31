import java.util.Arrays;
import java.util.Scanner;

public class MinCuts {
    static int solve(int i, int j, int[] cuts, int [][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int index=i;index<=j;index++){
            int cost = cuts[j + 1] - cuts[i - 1]+solve(i,index-1,cuts,dp)+solve(index+1,j,cuts,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
    public int minCutCost(int n, int[] arr) {
        int m = arr.length;
        int[] cuts = new int[m + 2];
        cuts[0] = 0;
        cuts[m + 1] = n;
        for (int i = 0; i < m; i++) {
            cuts[i + 1] = arr[i];
        }
        Arrays.sort(cuts);
        int[][] dp = new int[m + 2][m + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(1, m, cuts, dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        MinCuts obj = new MinCuts();
        System.out.println("Result:"+obj.minCutCost(k,arr));
    }
}
