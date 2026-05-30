import java.util.Scanner;

public class StockCooldown {
    public int solve(int[] prices, int index, int canBuy, int[][] dp){
        if(index>=prices.length) return 0;
        if(dp[index][canBuy]!=0) return dp[index][canBuy];
        if(canBuy == 1){
            int buy = -prices[index]+solve(prices,index+1,0,dp);
            int dontBuy = solve(prices,index+1,1,dp);
            return dp[index][canBuy] = Math.max(buy,dontBuy);
        }
        else{
            int sell = prices[index]+solve(prices,index+2,1,dp);
            int hold = solve(prices,index+1,0,dp);
            return dp[index][canBuy] = Math.max(sell,hold);
        }
    }
    public int maxProfit(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n+1][2];
        return solve(arr,0,1,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        StockCooldown obj = new StockCooldown();
        System.out.println("Result:"+obj.maxProfit(arr));
    }
}
