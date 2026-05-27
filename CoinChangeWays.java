import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeWays {
    static int solve(int[] coins, int sum ,int index,int[][] dp){
        if(index == 0) return (sum%coins[0]==0)?1:0;
        if(dp[index][sum]!=-1) return dp[index][sum];
        int notTake = solve(coins,sum,index-1,dp);
        int take = 0;
        if(coins[index]<=sum) take = solve(coins,sum-coins[index],index,dp);
        return dp[index][sum]=notTake+take;
    }
    public int count(int coins[], int sum) {
        int[][] dp = new int[coins.length][sum+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(coins,sum,coins.length-1,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();
        CoinChangeWays obj = new CoinChangeWays();
        System.out.println("Result:"+obj.count(arr,d));
    }
}
