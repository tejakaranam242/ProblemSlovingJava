import java.util.Scanner;

public class OptimalKey {
    public int optimalKeys(int n) {
        if(n<=6) return n;
        int[] dp = new int[n+1];
        for(int i=1;i<=6;i++){
            dp[i] = i;
        }
        for(int i=7;i<=n;i++){
            int case1 = dp[i-3]*2;
            int case2 = dp[i-4]*3;
            int case3 = dp[i-5]*4;
            dp[i] = Math.max(case1,Math.max(case2,case3));
        }
        return dp[n];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        OptimalKey obj = new OptimalKey();
        System.out.println("Result: "+obj.optimalKeys(n));
    }
}
