import java.util.Scanner;

public class StockK {
    static int solve(int[] prices, int index, int canBuy, int k, int[][][] dp){
        if(index==prices.length) return 0;
        if(k==0) return 0;
        if(dp[index][canBuy][k]!=0) return dp[index][canBuy][k];
        if(canBuy == 1){
            int buy = -prices[index]+solve(prices,index+1,0,k,dp);
            int cantBuy = solve(prices,index+1,1,k,dp);
            return dp[index][canBuy][k] = Math.max(buy,cantBuy);
        }
        int sell = prices[index]+solve(prices,index+1,1,k-1,dp);
        int cantSell = solve(prices,index+1,0,k,dp);
        return dp[index][canBuy][k] = Math.max(sell,cantSell);
    }
    int maxProfit(int prices[], int k) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int index=n-1;index>=0;index--){
            for(int canBuy = 0;canBuy<=1;canBuy++){
                for(int j=1;j<=k;j++){
                    if(canBuy == 1){
                        int buy = -prices[index]+dp[index+1][0][j];
                        int cantBuy = dp[index+1][1][j];
                        dp[index][canBuy][j] = Math.max(buy,cantBuy);
                    }
                    else{
                        int sell = prices[index]+dp[index+1][1][j-1];
                        int cantSell = dp[index+1][0][j];
                        dp[index][canBuy][j] = Math.max(sell,cantSell);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        StockK obj = new StockK();
        System.out.println("Result:"+obj.maxProfit(arr,k));
    }
}