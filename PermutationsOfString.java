import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class PermutationsOfString {
    public static void permutations(int index, char[] s, ArrayList<String> result){
        int length = s.length;
        if(length == index){
            result.add(new String(s));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i=index;i<s.length;i++){
            if(set.contains(s[i])) continue;
            set.add(s[i]);
            swap(index,i,s);
            permutations(index+1,s,result);
            swap(index,i,s);
        }
    }
    public static void swap(int i,int j, char[] s){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        permutations(0,s.toCharArray(),result);
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s= scanner.next();
        PermutationsOfString obj = new PermutationsOfString();
        System.out.println("Result: "+obj.findPermutation(s));
    }
}
