import java.util.Arrays;
import java.util.Scanner;

public class Knapsack01 {
    static int slove(int W, int[] val, int[] wt, int index, int[][] dp){
        if(index == 0){
            if(wt[0]<=W) return val[0];
            else return 0;
        }
        if(dp[index][W]!=-1) return dp[index][W];
        int notTake = slove(W,val,wt,index-1,dp);
        int take = 0;
        if(wt[index]<=W) take = val[index]+slove(W-wt[index],val,wt,index-1,dp);
        return dp[index][W]=Math.max(take,notTake);
    }
    public int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length][W+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return slove(W,val,wt,val.length-1,dp);
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
        Knapsack01 obj = new Knapsack01();
        System.out.println("Result:"+obj.knapsack(W,val,wt));
    }
}
