import java.util.Scanner;

public class Theif1 {
    public int findMaxSum(int arr[]) {
        int prev = arr[0];
        int prev2 = 0;
        for(int i=1;i<arr.length;i++){
            int curri = arr[i];
            if(i>1) curri+=prev2;
            int notTake = prev;
            curri = Math.max(notTake,curri);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i< input.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        Theif1 obj = new Theif1();
        System.out.println("Result: "+obj.findMaxSum(arr));
    }
}
