import java.util.Arrays;
import java.util.Scanner;

public class MinPlatforms {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;;
        int count =0,maxCount =0;
        while(i<n){
            if(arr[i]<=dep[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            maxCount = Integer.max(count,maxCount);
        }
        return maxCount;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i< input.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        input = scanner.nextLine().split(" ");
        int[] dep = new int[input.length];
        for(int i=0;i< input.length;i++){
            dep[i] = Integer.parseInt(input[i]);
        }
        MinPlatforms obj = new MinPlatforms();
        System.out.printf("Result: "+obj.minPlatform(arr, dep));
    }
}
