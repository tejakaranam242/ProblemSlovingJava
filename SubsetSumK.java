import java.util.Scanner;

public class SubsetSumK {
    static boolean slove(Boolean[][] dp,int index,int[] arr, int sum){
        if(sum==0) return true;
        if(index == 0) return (arr[0]==sum);
        if(dp[index][sum]!=null) return dp[index][sum];
        Boolean notTake = slove(dp,index-1,arr,sum);
        Boolean take = false;
        if(sum>=arr[index])
            take = slove(dp,index-1,arr,sum-arr[index]);
        return dp[index][sum] = take||notTake;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        return slove(dp,arr.length-1,arr,sum);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();
        SubsetSumK obj = new SubsetSumK();
        System.out.println("Result:"+obj.isSubsetSum(arr,d));
    }
}
