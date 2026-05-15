import java.util.Arrays;
import java.util.Scanner;

public class KnapSack {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        double result=0.0;
        int n = val.length;
        double[][] values = new double[val.length][2];
        for(int i=0;i<n;i++){
            values[i][0] = val[i];
            values[i][1] = wt[i];
        }
        Arrays.sort(values,(a, b)->Double.compare(b[0]/b[1],a[0]/a[1]));
        int i = 0;
        while(i<n && capacity>0){
            double value = values[i][0];
            double weight = values[i][1];
            if(weight<=capacity){
                result+=value;
                capacity-=weight;
            }
            else{
                result+=(value/weight)*capacity;
                capacity = 0;
            }
            i++;
        }

        return result;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] val = new int[input.length];
        for(int i=0;i< input.length;i++){
            val[i] = Integer.parseInt(input[i]);
        }
        input = scanner.nextLine().split(" ");
        int[] wt = new int[input.length];
        for(int i=0;i< input.length;i++){
            wt[i] = Integer.parseInt(input[i]);
        }
        int capacity = scanner.nextInt();
        KnapSack obj = new KnapSack();
        System.out.printf("Result: %.6f",obj.fractionalKnapsack(val, wt, capacity));
    }
}
