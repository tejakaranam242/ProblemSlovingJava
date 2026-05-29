import java.util.Scanner;

public class StockMulti {
    public int solve(int[] prices, int index, int canBuy, int[][] dp){
        if(index==prices.length) return 0;
        if(dp[index][canBuy]!=-1) return dp[index][canBuy];
        if(canBuy == 1){
            int buy = -prices[index]+solve(prices,index+1,0,dp);
            int dontBuy = solve(prices,index+1,1,dp);
            return dp[index][canBuy] = Math.max(buy,dontBuy);
        }
        else{
            int sell = prices[index]+solve(prices,index+1,1,dp);
            int hold = solve(prices,index+1,0,dp);
            return dp[index][canBuy] = Math.max(sell,hold);
        }
    }
    public int maxProfit(int prices[]) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];
        for(int index=n-1;index>=0;index--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                if(canBuy == 1){
                    int buy = -prices[index]+ahead[0];
                    int dontBuy = ahead[1];
                    curr[canBuy] = Math.max(buy,dontBuy);
                }
                else{
                    int sell = prices[index]+ahead[1];
                    int hold = ahead[0];
                    curr[canBuy] = Math.max(sell,hold);
                }
            }
            ahead = curr;
        }
        return ahead[1];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        StockMulti obj = new StockMulti();
        System.out.println("Result:"+obj.maxProfit(arr));
    }
}