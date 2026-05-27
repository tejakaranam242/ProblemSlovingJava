import java.util.*;

public class PrintAllLCS {
    static Set<String> solve(String s1, String s2, int i, int j, int[][] dp, Map<String, Set<String>> memo) {
        String key = i + "," + j;
        if(memo.containsKey(key))
            return memo.get(key);
        Set<String> ans = new HashSet<>();
        if(i == 0 || j == 0){
            ans.add("");
            return ans;
        }
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            Set<String> temp = solve(s1,s2,i-1,j-1,dp,memo);
            for(String str : temp){
                ans.add(str + s1.charAt(i-1));
            }
        }
        else{
            if(dp[i-1][j] >= dp[i][j-1]){
                ans.addAll(solve(s1,s2,i-1,j,dp,memo));
            }
            if(dp[i][j-1] >= dp[i-1][j]){
                ans.addAll(solve(s1,s2,i,j-1,dp,memo));
            }
        }
        memo.put(key, ans);
        return ans;
    }
    public List<String> allLCS(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++) dp[i][0] = 0;
        for(int j=0;j<=n2;j++) dp[0][j] = 0;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> result = solve(s1,s2,n1,n2,dp,memo);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        PrintAllLCS obj = new PrintAllLCS();
        System.out.println("Result:"+obj.allLCS(s1,s2));
    }
}
