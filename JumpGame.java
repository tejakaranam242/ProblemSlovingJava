import java.util.Scanner;

public class JumpGame {
    public boolean canReach(int[] arr) {
        int maxReach = 0;
        for(int i=0;i<arr.length;i++){
            if(i>maxReach) return false;
            maxReach = Math.max(maxReach,i+arr[i]);
            if(maxReach>=arr.length-1) return true;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i< input.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        JumpGame obj = new JumpGame();
        System.out.println("Result: "+obj.canReach(arr));
    }
}
