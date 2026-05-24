import java.util.Scanner;

public class JumpGameV {
    static int slove(int[] arr,int d,int index, int[] dp){
        if(dp[index] != 0) return dp[index];
        int max = 1;
        for(int i=index+1;i<=Math.min(arr.length-1,index+d);i++){
            if(arr[i]>=arr[index]) break;
            max = Math.max(max,1+slove(arr,d,i,dp));
        }
        for(int i=index-1;i>=Math.max(0,index-d);i--){
            if(arr[i]>=arr[index]) break;
            max = Math.max(max,1+slove(arr,d,i,dp));
        }
        return dp[index] = max;
    }
    public int maxJumps(int[] arr, int d) {
        int result = 1;
        int[] dp = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            result = Math.max(result,slove(arr,d,i,dp));
        }
        return result;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();
        JumpGameV obj = new JumpGameV();
        System.out.println("Result:"+obj.maxJumps(arr,d));
    }
}
