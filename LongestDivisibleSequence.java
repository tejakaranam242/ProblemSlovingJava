import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LongestDivisibleSequence {
    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.sort(arr);
        int it = 0;
        int jt = arr.length-1;
        while(it < jt){
            int t = arr[it];
            arr[it] = arr[jt];
            arr[jt] = t;
            it++;
            jt--;
        }
        int lastIndex = 0;
        int maxi = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
            for(int prev=0;prev<i;prev++){
                if(arr[prev]%arr[i]==0 && ( dp[i] < 1+dp[prev])){
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
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        LongestDivisibleSequence obj = new LongestDivisibleSequence();
        System.out.println("Result:"+obj.largestSubset(arr));
    }
}