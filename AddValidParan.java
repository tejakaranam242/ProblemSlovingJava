import java.util.Scanner;
import java.util.Stack;

public class AddValidParan {
    public int minParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(') st.push(ch);
            else if(ch==')'){
                if(st.isEmpty()) st.push(ch);
                else{
                    char top = st.peek();
                    if(ch==')'&&top=='(') st.pop();
                    else st.push(ch);
                }
            }
        }
        return st.size();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String paran = scanner.next();
        AddValidParan obj = new AddValidParan();
        System.out.println("Result :"+obj.minParentheses(paran));
    }
}
