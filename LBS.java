import java.util.Scanner;

public class LBS {
    public static int longestBitonicSequence(int n, int[] arr) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i<n; i++) {
            dp1[i] = 1;
            for (int j = 0; j<i; j++) {
                if (arr[i]>arr[j] && dp1[i]<1 + dp1[j])
                    dp1[i] = 1 + dp1[j];
            }
        }
        int maxi = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = n - 1; j>i; j--) {
                if (arr[i]>arr[j] && dp2[i]<1 + dp2[j])
                    dp2[i] = 1 + dp2[j];
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
            }
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
        int k = scanner.nextInt();
        LBS obj = new LBS();
        System.out.println("Result:"+obj.longestBitonicSequence(k,arr));
    }
}
