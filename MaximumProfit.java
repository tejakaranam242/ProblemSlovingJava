import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaximumProfit {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        List<int[]> tasks = new ArrayList<>();
        for(int i=0;i<n;i++){
            int diff = Math.abs(a[i]-b[i]);
            tasks.add(new int[]{diff,a[i],b[i]});
        }
        Collections.sort(tasks,(t1, t2)->t2[0]-t1[0]);
        int profit = 0;
        for(int[] task:tasks){
            int ai = task[1];
            int bi = task[2];
            if(ai>bi){
                if(x>0){
                    profit+=ai;
                    x--;
                }
                else{
                    profit+=bi;
                    y--;
                }
            }
            else{
                if(y>0){
                    profit+=bi;
                    y--;
                }
                else{
                    profit+=ai;
                    x--;
                }
            }
        }
        return profit;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] a = new int[input.length];
        for(int i=0;i< input.length;i++){
            a[i] = Integer.parseInt(input[i]);
        }
        input = scanner.nextLine().split(" ");
        int[] b = new int[input.length];
        for(int i=0;i< input.length;i++){
            b[i] = Integer.parseInt(input[i]);
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        MaximumProfit obj = new MaximumProfit();
        System.out.printf("Result: "+obj.maxProfit(x,y,a,b));
    }
}
