import java.util.Scanner;

public class ChocolatePickup {
    static int slove(int[][][] dp,int i,int j1,int j2,int[][] grid,int m, int n){
        if(j1<0 || j1>=n || j2<0 || j2>=n) return (int)-1e8;
        if(i==m-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=0) return dp[i][j1][j2];
        int max = Integer.MIN_VALUE;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int value = 0;
                if(j1 == j2) value = grid[i][j1];
                else value = grid[i][j1]+grid[i][j2];
                value+=slove(dp,i+1,dj1+j1,dj2+j2,grid,m,n);
                max = Math.max(max,value);
            }
        }
        return dp[i][j1][j2] = max;
    }
    public int maxChocolate(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dp[m-1][i][j] = grid[m-1][i];
                else dp[m-1][i][j] = grid[m-1][i]+grid[m-1][j];
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j1 = 0;j1<n;j1++){
                for(int j2 = 0;j2<n;j2++){
                    int max = Integer.MIN_VALUE;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int value = 0;
                            if(j1==j2) value = grid[i][j1];
                            else value = grid[i][j1]+grid[i][j2];
                            if(dj1+j1>=0 && dj2+j2>=0 && dj1+j1<n&&dj2+j2<n) value+=dp[i+1][dj1+j1][dj2+j2];
                            else value+=(int) -1e8;
                            max = Math.max(max,value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][n-1];
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
        ChocolatePickup obj = new ChocolatePickup();
        System.out.println(obj.maxChocolate(mat));
    }
}
