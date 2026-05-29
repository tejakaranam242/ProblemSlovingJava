import java.util.Scanner;

public class PatternMatch {
    static boolean solve(String txt, String pat, int n1, int n2, Boolean[][] dp){
        if(n1<0&&n2<0) return true;
        if(n2<0&&n1>=0) return false;
        if(n1<0&&n2>=0){
            for(int i=n2;i>=0;i--){
                if(pat.charAt(i)!='*') return false;
            }
            return true;
        }
        if(dp[n1][n2]!=null) return dp[n1][n2];
        if(txt.charAt(n1)==pat.charAt(n2)||pat.charAt(n2)=='?') return dp[n1][n2]=solve(txt,pat,n1-1,n2-1,dp);
        if(pat.charAt(n2) == '*') return dp[n1][n2]=(solve(txt,pat,n1,n2-1,dp) || solve(txt,pat,n1-1,n2,dp));
        return dp[n1][n2]=false;
    }
    public boolean wildCard(String txt, String pat) {
        int n1 = txt.length();
        int n2 = pat.length();
        Boolean[][] dp = new Boolean[n1][n2];
        return solve(txt,pat,n1-1,n2-1,dp);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        PatternMatch obj = new PatternMatch();
        System.out.println("Result:"+obj.wildCard(s1,s2));
    }
}