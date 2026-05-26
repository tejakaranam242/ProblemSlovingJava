import java.util.Scanner;

public class MinSumPartition {
    static int sum(int[] arr){
        int sum = 0;
        for(int i:arr) sum+=i;
        return sum;
    }
    public int minDifference(int arr[]) {
        int sum = sum(arr);
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum+1];
        for(int i=0;i<n;i++) dp[i][0] = true;
        if(arr[0]<=sum) dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int k=1;k<=sum;k++){
                boolean notTake = dp[i-1][k];
                boolean take = false;
                if(arr[i]<=k) take = dp[i-1][k-arr[i]];
                dp[i][k] = notTake||take;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;i++){
            if(dp[n-1][sum-i]==true){
                int s1 = i;
                int s2 = sum-i;
                min = Math.min(min,Math.abs(s1-s2));
            }
        }
        return min;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        MinSumPartition obj = new MinSumPartition();
        System.out.println("Result:"+obj.minDifference(arr));
    }
}
