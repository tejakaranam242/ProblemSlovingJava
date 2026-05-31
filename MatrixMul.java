import java.util.Scanner;

public class MatrixMul {
    static int solve(int i, int j, int[] arr, int[][] dp){
        if(i==j) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int steps = arr[i-1]*arr[k]*arr[j] + solve(i,k,arr,dp) + solve(k+1,j,arr,dp);
            mini = Math.min(steps,mini);
        }
        return dp[i][j] = mini;
    }
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        return solve(1,n-1,arr,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        MatrixMul obj = new MatrixMul();
        System.out.println("Result:"+obj.matrixMultiplication(arr));
    }
}