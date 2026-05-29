import java.util.Scanner;

public class StockOne {
    public int maxProfit(int[] arr) {
        int min = arr[0];
        int ans = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min) min = arr[i];
            ans = Math.max(ans,arr[i]-min);
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        StockOne obj = new StockOne();
        System.out.println("Result:"+obj.maxProfit(arr));
    }
}