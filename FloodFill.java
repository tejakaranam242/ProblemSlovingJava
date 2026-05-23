import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int originalColor = image[sr][sc];
        if(originalColor == newColor) return image;
        queue.add(new Pair(sr, sc));
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.poll();
            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};
            for (int k = 0; k<4; k++) {
                int nrow = delrow[k]+row;
                int ncol = delcol[k]+col;
                if (nrow >= 0 && nrow<n && ncol >= 0 && ncol<m && image[nrow][ncol] == originalColor) {
                    image[nrow][ncol] = newColor;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }

        return image;
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
        int sr = scanner.nextInt();
        int sc = scanner.nextInt();
        int newColor = scanner.nextInt();
        FloodFill obj = new FloodFill();
        obj.floodFill(mat,sr,sc,newColor);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}