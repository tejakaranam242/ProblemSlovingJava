import java.util.Arrays;
import java.util.Scanner;

public class TargetSum {
    static int solve(int[] arr, int target, int index, int[][] dp){
        if(index == 0){
            if(arr[0]==0&&target==0) return 2;
            if(arr[0]==target||(target==0)) return 1;
            return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake = solve(arr,target,index-1,dp);
        int take = 0;
        if(arr[index]<=target) take = solve(arr,target-arr[index],index-1,dp);
        return notTake+take;
    }
    public int totalWays(int[] arr, int target) {
        int sum = 0;
        for(int i:arr) sum+=i;
        if(sum-target<0 || (sum-target)%2!=0) return 0;
        int req = (sum-target)/2;
        int[][] dp = new int[arr.length][req+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(arr,req,arr.length-1,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();
        TargetSum obj = new TargetSum();
        System.out.println("Result:"+obj.totalWays(arr,d));
    }
}
