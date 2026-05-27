import java.util.Scanner;

public class RodCutting {
    static int solve(int[] price, int length, int index, int[][] dp){
        if(index==0){
            return length*price[0];
        }
        if(dp[length][index]!=0) return dp[length][index];
        int notTake = solve(price,length,index-1,dp);
        int take = Integer.MIN_VALUE;
        if(index+1<=length) take = price[index]+solve(price,length-index-1,index,dp);
        return dp[length][index]=Math.max(take,notTake);
    }
    public int cutRod(int[] price) {
        int[][] dp = new int[price.length][price.length+1];
        int[] prev = new int[price.length+1];
        int[] curr = new int[price.length+1];
        for(int i=1;i<=price.length;i++) prev[i] = i*price[0];
        for(int i=1;i<price.length;i++){
            for(int j=1;j<=price.length;j++){
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if(i+1<=j) take = price[i]+curr[j-i-1];
                curr[j]=Math.max(take,notTake);
            }
            prev = curr;
        }
        return prev[price.length];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        RodCutting obj = new RodCutting();
        System.out.println("Result:"+obj.cutRod(arr));
    }
}
