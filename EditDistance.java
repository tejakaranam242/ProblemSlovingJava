import java.util.Scanner;

public class EditDistance {
    public int solve(String s1, String s2, int n1, int n2, int[][] dp){
        if(n1<=0) return n1;
        if(n2<=0) return n2;
        if(dp[n1][n2] != -1) return dp[n1][n2];
        if(s1.charAt(n1-1)==s2.charAt(n2-1)) return solve(s1,s2,n1-1,n2-1,dp);
        int insert = 1+solve(s1,s2,n1,n2-1,dp);
        int delete = 1+solve(s1,s2,n1-1,n2,dp);
        int replace = 1+solve(s1,s2,n1-1,n2-1,dp);
        return dp[n1][n2]  = Math.min(insert,Math.min(delete,replace));
    }
    public int editDistance(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        return solve(s1,s2,n1,n2,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        EditDistance obj = new EditDistance();
        System.out.println("Result:"+obj.editDistance(s1,s2));
    }
}