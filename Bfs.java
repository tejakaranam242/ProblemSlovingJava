import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        queue.add(0);
        vis[0] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            bfs.add(node);
            for(int i:adj.get(node)){
                if(vis[i]==false){
                    vis[i] = true;
                    queue.add(i);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Bfs obj = new Bfs();
        ArrayList<Integer> result = obj.bfs(adj);
        System.out.println("DFS Traversal:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
