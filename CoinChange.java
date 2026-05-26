import java.util.Scanner;

public class CoinChange {
    static int solve(int[] coins, int sum, int index,int[][] dp){
        if(index==0){
            if(sum%coins[0]==0) return sum/coins[0];
            else return (int)1e9;
        }
        if(dp[index][sum]!=0) return dp[index][sum];
        int notTake = solve(coins,sum,index-1,dp);
        int take = Integer.MAX_VALUE;
        if(coins[index]<=sum) take = 1+solve(coins,sum-coins[index],index,dp);
        return dp[index][sum]=Math.min(take,notTake);
    }
    public int minCoins(int coins[], int sum) {
        if(sum==0) return 0;
        int[][] dp = new int[coins.length][sum+1];
        int value = solve(coins,sum,coins.length-1,dp);
        return value>=(int)1e9?-1:value;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();
        CoinChange obj = new CoinChange();
        System.out.println("Result:"+obj.minCoins(arr,d));
    }
}
