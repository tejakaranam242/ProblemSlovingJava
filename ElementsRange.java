import java.util.HashSet;
import java.util.Scanner;

public class ElementsRange {
    public boolean checkElements(int start, int end, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:arr){
            set.add(i);
        }
        for(int i=start;i<=end;i++){
            if(!set.contains(i)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        ElementsRange obj = new ElementsRange();
        System.out.println("Result:"+obj.checkElements(start,end,arr));
    }
}
