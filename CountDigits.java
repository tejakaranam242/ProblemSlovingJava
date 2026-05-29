import java.util.Arrays;
import java.util.Scanner;

public class CountDigits  {
    static int solve(String s, int index, int prevSum, int[][] dp){
        if(index==s.length()) return 1;
        if(dp[index][prevSum]!=-1) return dp[index][prevSum];
        int sum = 0;
        int count = 0;
        for(int j=index;j<s.length();j++){
            sum+=s.charAt(j)-'0';
            if(sum>=prevSum) count+=solve(s,j+1,sum,dp);
        }
        return dp[index][prevSum] = count;
    }
    public int validGroups(String s) {
        int n = s.length();
        int maxSum = 9*n;
        int[][] dp = new int[n][maxSum];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(s,0,0,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        CountDigits obj = new CountDigits();
        System.out.println("Result:"+obj.validGroups(s1));
    }
}