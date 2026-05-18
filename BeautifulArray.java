import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BeautifulArray {
    List<Integer> makeBeautiful(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (list.isEmpty()) {
                list.add(num);
            }
            else {
                int last = list.get(list.size() - 1);
                if ((last >= 0 && num >= 0) ||
                        (last < 0 && num < 0)) {
                    list.add(num);
                }
                else {
                    list.remove(list.size() - 1);
                }
            }
        }
        return list;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i< input.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        BeautifulArray obj = new BeautifulArray();
        List<Integer> result = obj.makeBeautiful(arr);
        for(int i:result) System.out.print(i+" ");
    }
}
