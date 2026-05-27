import java.util.Scanner;

public class WifiRange {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int One = 0;
        while(One<n && s.charAt(One)!='1') One++;
        if(One == n || One>x) return false;
        for(int i = One+1;i<n;i++){
            if(s.charAt(i)=='1') One = i;
            if(i-One+1>2*x+1) return false;
        }
        if(n-One>x+1) return false;
        return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        WifiRange obj = new WifiRange();
        System.out.println("Range:"+obj.wifiRange(s,n));
    }
}
