import java.util.*;

public class MinMulToReachEnd {
    public int minSteps(int[] arr, int start, int end) {
        if(start==end) return 0;
        int[]dist=new int[1000];
        Arrays.fill(dist,-1);
        Queue<Integer> q=new ArrayDeque<>();
        dist[start]=0;
        q.add(start);
        while(!q.isEmpty()){
            int node=q.poll();
            for(int it:arr){
                int next=(node*it)%1000;
                if(dist[next]==-1){
                    dist[next]=dist[node]+1;
                    if(next==end)
                        return dist[next];
                    q.add(next);
                }
            }
        }
        return-1;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i< input.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        MinMulToReachEnd obj = new MinMulToReachEnd();
        int result = obj.minSteps(arr,start,end);
        System.out.print("Result"+result);
    }
}
