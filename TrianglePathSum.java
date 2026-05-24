import java.util.ArrayList;
import java.util.Scanner;

public class TrianglePathSum {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<=i;j++){
                int up=Integer.MAX_VALUE;
                int ul=Integer.MAX_VALUE;
                if(j<i)up = dp[i-1][j];
                if(j>0)ul = dp[i-1][j-1];
                dp[i][j] = triangle.get(i).get(j)+Math.min(up,ul);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < triangle.size(); j++) ans = Math.min(ans, dp[triangle.size() - 1][j]);
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(scanner.nextInt());
            }
            triangle.add(row);
        }
        TrianglePathSum obj = new TrianglePathSum();
        System.out.println("Result:"+obj.minPathSum(triangle));
    }
}
