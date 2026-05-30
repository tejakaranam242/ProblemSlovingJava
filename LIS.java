import java.util.Scanner;

public class LIS {
    // static int[][] dp;
    // static int solve(int[] arr, int prev, int n, int index){
    //     if(index==n) return 0;
    //     if(dp[index][prev+1]!=0) return dp[index][prev+1];
    //     int notTake=solve(arr,prev,n,index+1);
    //     int take = 0;
    //     if(prev==-1||arr[index]>arr[prev]) take=1+solve(arr,index,n,index+1);
    //     return dp[index][prev+1] = Math.max(take,notTake);
    // }
    static int lis(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        int maxi = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int prev = 0;prev<i;prev++){
                if(arr[prev]<arr[i]) dp[i] = Math.max(dp[i],1+dp[prev]);
            }
            maxi = Math.max(dp[i],maxi);
        }
        return maxi;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        LIS obj = new LIS();
        System.out.println("Result:"+obj.lis(arr));
    }
}