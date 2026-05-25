import java.util.Scanner;

public class EqualPartitionSum {
    static int sum(int[] arr){
        int sum = 0;
        for(int i:arr) sum+=i;
        return sum;
    }
    static boolean equalPartition(int arr[]) {
        int sum = sum(arr);
        if(sum%2!=0) return false;
        int n = arr.length;
        int target = (int)sum/2;
        boolean[][] dp =new boolean[n][target+1];
        for(int i=0;i<n;i++) dp[i][0] = true;
        if(arr[0] <= target) dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int k=1;k<=target;k++){
                boolean notTake = dp[i-1][k];
                boolean take = false;
                if(arr[i]<=k) take = dp[i-1][k-arr[i]];
                dp[i][k] = notTake||take;
            }
        }
        return dp[n-1][target];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();
        EqualPartitionSum obj = new EqualPartitionSum();
        System.out.println("Result:"+obj.equalPartition(arr));
    }
}
