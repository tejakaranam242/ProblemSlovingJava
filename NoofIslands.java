import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NoofIslands {
    static void bfs(int row, int col, boolean[][] visited, char[][] grid){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;
        while(!queue.isEmpty()){
            int ro = queue.peek().row;
            int co = queue.peek().col;
            queue.poll();
            for(int delrow = -1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow = ro+delrow;
                    int ncol = co+delcol;
                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&grid[nrow][ncol]=='L'&&visited[nrow][ncol]==false){
                        visited[nrow][ncol] = true;
                        queue.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
    public int countIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == false && grid[i][j] == 'L') {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] mat = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = scanner.next().charAt(0);
            }
        }
        NoofIslands obj = new NoofIslands();
        System.out.println(obj.countIslands(mat));
    }
}
