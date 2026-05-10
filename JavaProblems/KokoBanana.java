import java.util.Scanner;

public class KokoBanana {
    public int maxOfArray(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            if(piles[i] > max) max = piles[i];
        }
        return max;
    }
    public int timeTaken(int[] piles, int time){
        int totalTime = 0;
        for(int i=0;i<piles.length;i++){
            totalTime += Math.ceil((double)piles[i]/time);
        }
        return totalTime;
    }
    public int kokoEat(int[] piles, int h) {
        int low = 1, high = maxOfArray(piles);
        while(low<=high){
            int mid = (low+high)/2;
            if(timeTaken(piles,mid) <= h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int k = scanner.nextInt();
        KokoBanana obj = new KokoBanana();
        System.out.print("Result:"+obj.kokoEat(arr,k));
    }
}
