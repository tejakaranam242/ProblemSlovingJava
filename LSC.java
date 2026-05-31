import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LSC {
    public boolean compare(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2 + 1)
            return false;
        int first = 0;
        int second = 0;
        while (first<n1) {
            if (second < n2 && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            }
            else {
                first++;
            }
        }
        return (first == n1 && second == n2);
    }
    public int longestStringChain(String words[]) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) indexMap.put(words[i], i);
        int maxi = 0;
        for (int i = 0; i<n; i++) {
            dp[i] = 1;
            for (int k = 0; k < words[i].length(); k++) {
                String predecessor = words[i].substring(0, k) + words[i].substring(k + 1);
                if (indexMap.containsKey(predecessor)) {
                    int j = indexMap.get(predecessor);
                    if (dp[i] < 1 + dp[j]) dp[i] = 1 + dp[j];
                }
            }
            if (dp[i]>maxi) maxi = dp[i];
        }
        return maxi;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.next();
        }
        LSC obj = new LSC();
        System.out.println("Result:"+obj.longestStringChain(arr));
    }
}
