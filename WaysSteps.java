import java.util.Scanner;

public class WaysSteps {
    public int countWays(int n) {
        if(n<2) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        WaysSteps obj = new WaysSteps();
        System.out.println("Result: "+obj.countWays(n));
    }
}
