import java.util.Scanner;

public class SudokuSlover {
    public void solveSudoku(int[][] mat) {
        slove(mat);
    }
    public static boolean slove(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    for(int k=1;k<=9;k++){
                        if(isValid(k,i,j,mat)){
                            mat[i][j] = k;
                            if(slove(mat)== true) return true;
                            else mat[i][j] =0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(int k,int i,int j,int[][] mat){
        for(int c=0;c<9;c++){
            if(mat[i][c] == k) return false;
            if(mat[c][j] == k) return false;
            if(mat[3*(i/3)+c/3][3*(j/3)+c%3] == k) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] mat = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                mat[i][j] = scanner.nextInt();
            }
        }
        SudokuSlover obj = new SudokuSlover();
        obj.solveSudoku(mat);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
