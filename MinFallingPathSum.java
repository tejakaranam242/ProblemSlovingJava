import java.util.Scanner;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i] = mat[0][i];
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0) continue;
                int up = Integer.MAX_VALUE;
                int ur = Integer.MAX_VALUE;
                int ul = Integer.MAX_VALUE;
                if(i>0) up = dp[i-1][j];
                if(i>0 && j<n-1) ur = dp[i-1][j+1];
                if(i>0 && j>0) ul = dp[i-1][j-1];
                dp[i][j] = mat[i][j]+Math.min(up,Math.min(ur,ul));
            }
        }
        for(int i=0;i<n;i++){
            min = Math.min(min,dp[m-1][i]);
        }
        return min;
    }
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] mat = new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            mat[i][j] = scanner.nextInt();
        }
    }
    MinFallingPathSum obj = new MinFallingPathSum();
        obj.minFallingPathSum(mat);
        for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            System.out.print(mat[i][j]+" ");
        }
        System.out.println();
    }
}
}
