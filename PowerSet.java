import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PowerSet {
    static List<String> ans;
    static void solve(String s, int index, StringBuilder temp){
        if(index==s.length()){
            if(temp.length()>0) ans.add(temp.toString());
            return;
        }
        temp.append(s.charAt(index));
        solve(s,index+1,temp);
        temp.deleteCharAt(temp.length()-1);
        solve(s,index+1,temp);
    }
    public List<String> AllPossibleStrings(String s) {
        StringBuilder temp = new StringBuilder();
        ans = new ArrayList<>();
        solve(s,0,temp);
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        PowerSet obj = new PowerSet();
        System.out.println("Result:"+obj.AllPossibleStrings(s1));
    }
}