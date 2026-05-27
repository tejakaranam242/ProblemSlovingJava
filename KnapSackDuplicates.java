import java.util.Arrays;
import java.util.Scanner;

public class KnapSackDuplicates {
    static int solve(int[] val, int[] wt, int W, int index,int[][] dp){
        if(index==0){
            return val[0]*(W/wt[0]);
        }
        if(dp[index][W]!=-1)  return dp[index][W];
        int notTake = solve(val,wt,W,index-1,dp);
        int take = (int)-1e9;
        if(wt[index]<=W) take = val[index]+solve(val,wt,W-wt[index],index,dp);
        return dp[index][W]=Math.max(take,notTake);
    }
    public int knapSack(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length][capacity+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(val,wt,capacity,val.length-1,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] val = new int[n];
        for(int i=0;i<n;i++){
            val[i] = scanner.nextInt();
        }
        int[] wt = new int[n];
        for(int i=0;i<n;i++){
            wt[i] = scanner.nextInt();
        }
        int W = scanner.nextInt();
        KnapSackDuplicates obj = new KnapSackDuplicates();
        System.out.println("Result:"+obj.knapSack(val,wt,W));
    }
}
