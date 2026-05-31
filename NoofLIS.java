import java.util.Scanner;

public class NoofLIS {
    public int numberofLIS(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int maxi = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            cnt[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp[i]<1+dp[j]){
                    dp[i] = 1+dp[j];
                    cnt[i] = cnt[j];
                }
                else if(arr[i]>arr[j] && dp[i] == 1+dp[j]) cnt[i]+=cnt[j];
            }
            if(dp[i]>maxi) maxi = dp[i];
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxi) count+=cnt[i];
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        NoofLIS obj = new NoofLIS();
        System.out.println("Result:"+obj.numberofLIS(arr));
    }
}