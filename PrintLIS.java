import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PrintLIS {
    public ArrayList<Integer> getLIS(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxi = 0;
        int lastIndex = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
            for(int prev = 0;prev<i;prev++){
                if(arr[prev]<arr[i] && 1+dp[prev] > dp[i]){
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i]>maxi){
                maxi = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(arr[lastIndex]);
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        PrintLIS obj = new PrintLIS();
        System.out.println("Result:"+obj.getLIS(arr));
    }
}