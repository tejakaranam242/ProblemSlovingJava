import java.util.Arrays;
import java.util.Scanner;

public class MinNotSubsetSum {
    public int findSmallest(int[] arr) {
        int smallest = 1;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]>smallest) break;
            else smallest+=arr[i];
        }
        return smallest;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i<input.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        MinNotSubsetSum obj = new MinNotSubsetSum();
        System.out.println("Result: "+obj.findSmallest(arr));
    }
}
