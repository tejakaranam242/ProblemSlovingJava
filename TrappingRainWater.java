import java.util.Scanner;

public class TrappingRainWater {
    public int maxWater(int arr[]) {
        int leftMax = 0,rightMax =0,total=0;
        int left = 0,right = arr.length-1;
        while(left<right){
            if(arr[left]<=arr[right]){
                if(leftMax>arr[left]) total+=leftMax-arr[left];
                else leftMax = arr[left];
                left++;
            }
            else{
                if(rightMax>arr[right]) total+=rightMax-arr[right];
                else rightMax = arr[right];
                right--;
            }
        }
        return total;
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
