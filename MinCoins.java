import java.util.Scanner;

public class MinCoins {
    public int findMin(int n) {
        int coinsCount = 0;
        coinsCount += n/10;
        n%=10;
        coinsCount += n/5;
        n%=5;
        coinsCount += n/2;
        n%=2;
        coinsCount +=n;
        return coinsCount;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MinCoins obj = new MinCoins();
        System.out.println("Result: "+obj.findMin(n));
    }
}
