import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
public class RottenOranges {
    public int orangesRot(int[][] mat) {
        int days=0;
        Queue<Pair> queue = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        int[][] visited = new int[n][m];
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 2){
                    queue.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                else visited[i][j] = 0;
                if(mat[i][j] == 1) fresh++;
            }
        }
        int t = 0;
        int count = 0;
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int tm = queue.peek().time;
            t = Math.max(tm,t);
            queue.poll();
            int[] delrow = {-1,0,1,0};
            int[] delcol = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow = delrow[i]+row;
                int ncol = delcol[i]+col;
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&mat[nrow][ncol]==1&&visited[nrow][ncol]==0){
                    visited[nrow][ncol] = 2;
                    queue.add(new Pair(nrow,ncol,tm+1));
                    count++;
                }
            }
        }
        if(fresh!=count) return -1;
        return t;
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
        RottenOranges obj = new RottenOranges();
        obj.orangesRot(mat);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
