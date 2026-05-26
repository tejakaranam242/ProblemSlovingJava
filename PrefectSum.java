import java.util.Arrays;
import java.util.Scanner;

public class PrefectSum {
    static int slove(int index, int[] nums, int target, int[][] dp){
        if(index == 0) {
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 ||(nums[0]==target))  return 1;
            return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake = slove(index-1,nums,target,dp);
        int take = 0;
        if(nums[index]<=target) take = slove(index-1,nums,target-nums[index],dp);
        return dp[index][target]=take+notTake;
    }
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return slove(nums.length-1,nums,target,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();
        PrefectSum obj = new PrefectSum();
        System.out.println("Result:"+obj.perfectSum(arr,d));
    }
}
