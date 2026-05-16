import java.util.ArrayList;
import java.util.Scanner;

public class Nqueens {
    public static void placeQueens(int i, int[] cols, int[] upperDiagonal, int[] lowerDiagonal,
                                   ArrayList<Integer> board, ArrayList<ArrayList<Integer>> result){
        int n = cols.length;
        if(i == n){
            result.add(new ArrayList<>(board));
            return;
        }
        for(int j=0;j<n;j++){
            if((cols[j]!=1 && upperDiagonal[i+j]!=1) && lowerDiagonal[n-1+i-j]!=1){
                board.add(j+1);
                cols[j] = 1;
                upperDiagonal[i+j] = 1;
                lowerDiagonal[n-1+i-j] = 1;
                placeQueens(i+1, cols, upperDiagonal, lowerDiagonal, board, result);
                board.remove(board.size()-1);
                cols[j] = 0;
                upperDiagonal[i+j] = 0;
                lowerDiagonal[n-1+i-j] = 0;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        int[] cols = new int[n];
        int[] upperDiagonal = new int[n*2];
        int[] lowerDiagonal = new int[n*2];
        ArrayList<Integer> board = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        placeQueens(0, cols, upperDiagonal, lowerDiagonal, board, result);
        return result;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Nqueens obj = new Nqueens();
        System.out.println("Result: "+obj.nQueen(n));
    }
}