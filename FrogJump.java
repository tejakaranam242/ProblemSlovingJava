import java.util.Scanner;

public class FrogJump {
    int minCost(int[] height) {
        int[] dp = new int[height.length];
        dp[0] = 0;
        for(int i=1;i<height.length;i++){
            int oneStep = dp[i-1]+Math.abs(height[i]-height[i-1]);
            int twoStep = Integer.MAX_VALUE;
            if(i>1) twoStep = dp[i-2]+Math.abs(height[i]-height[i-2]);
            dp[i] = Math.min(oneStep,twoStep);
        }
        return dp[height.length-1];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i< input.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        FrogJump obj = new FrogJump();
        System.out.println("Result: "+obj.minCost(arr));
    }
}
