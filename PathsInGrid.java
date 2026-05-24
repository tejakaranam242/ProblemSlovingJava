import java.util.Scanner;

public class PathsInGrid {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=1){
                    if(i==0 && j==0){
                        dp[i][j] = 1;
                        continue;
                    }
                    int up = 0;
                    int down = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) down = dp[i][j-1];
                    dp[i][j] = up+down;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = scanner.nextInt();
            }
        }
        PathsInGrid obj = new PathsInGrid();
        obj.uniquePaths(mat);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
