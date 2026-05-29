import java.util.Scanner;

public class StockMax2 {
    static int solve(int[] prices, int index, int canBuy, int limit,int[][][] dp){
        if(limit == 0) return 0;
        if(index==prices.length) return 0;
        if(dp[index][canBuy][limit] != -1) return dp[index][canBuy][limit];
        int profit;
        if(canBuy==1) profit = Math.max(-prices[index]+solve(prices,index+1,0,limit,dp),solve(prices,index+1,1,limit,dp));
        else profit = Math.max(prices[index]+solve(prices,index+1,1,limit-1,dp),solve(prices,index+1,0,limit,dp));
        return dp[index][canBuy][limit] = profit;
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=1;j++){
                for(int k=0;k<=2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(prices,0,1,2,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        StockMax2 obj = new StockMax2();
        System.out.println("Result:"+obj.maxProfit(arr));
    }
}
