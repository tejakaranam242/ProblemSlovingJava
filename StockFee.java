import java.util.Scanner;

public class StockFee {
    static int solve(int[] arr, int index, int canBuy, int fee,int[][] dp){
        if(index==arr.length) return 0;
        if(dp[index][canBuy]!=0) return dp[index][canBuy];
        if(canBuy == 1){
            int buy = -arr[index]+solve(arr,index+1,0,fee,dp);
            int dontBuy = solve(arr,index+1,1,fee,dp);
            return dp[index][canBuy] = Math.max(buy,dontBuy);
        }
        int sell = -fee+arr[index]+solve(arr,index+1,1,fee,dp);
        int dontSell = solve(arr,index+1,0,fee,dp);
        return dp[index][canBuy] = Math.max(sell,dontSell);
    }
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        int[][] dp = new int[n+1][2];
        return solve(arr,0,1,k,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        StockFee obj = new StockFee();
        System.out.println("Result:"+obj.maxProfit(arr,k));
    }
}