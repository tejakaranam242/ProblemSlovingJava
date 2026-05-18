import java.util.Scanner;

public class Thief2 {
    public int maxValue(int[] arr) {
        int prev = arr[0];
        int prev2 = 0;
        for(int i=1;i<arr.length-1;i++){
            int curri = arr[i];
            if(i>1) curri+=prev2;
            int notTake = prev;
            prev2 = prev;
            prev = Math.max(curri,notTake);
        }
        int firstMax = prev;
        prev = arr[1];
        prev2 = 0;
        for(int i=2;i<arr.length;i++){
            int curri = arr[i];
            if(i>1) curri+=prev2;
            int notTake = prev;
            prev2 = prev;
            prev = Math.max(curri,notTake);
        }
        return Math.max(firstMax,prev);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i< input.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        TrappingRainWater obj = new TrappingRainWater();
        System.out.println("Result: "+obj.maxWater(arr));
    }
}
