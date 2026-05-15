import java.util.Arrays;
import java.util.Scanner;

public class Meetings {
    public int maxMeetings(int start[], int end[]) {
        int length = start.length;
        int[][] arr = new int[length][2];
        for(int i=0;i<length;i++){
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        Arrays.sort(arr,(a, b)->Integer.compare(a[1],b[1]));
        int count = 0;
        int endTime = -1;
        for(int i=0;i<length;i++){
            if(endTime<arr[i][0]){
                count++;
                endTime = arr[i][1];
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] start = new int[input.length];
        for(int i=0;i< input.length;i++){
            start[i] = Integer.parseInt(input[i]);
        }
        input = scanner.nextLine().split(" ");
        int[] end = new int[input.length];
        for(int i=0;i< input.length;i++){
            end[i] = Integer.parseInt(input[i]);
        }
        Meetings obj = new Meetings();
        System.out.printf("Result: "+obj.maxMeetings(start, end));
    }
}
