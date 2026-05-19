import java.util.ArrayList;
import java.util.Scanner;

public class Dfs {
    static void dfsResult(int node, boolean[] vis, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        dfs.add(node);
        for(int i:adj.get(node)){
            if(vis[i]==false) dfsResult(i,vis,dfs,adj);
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        vis[0] = true;
        dfsResult(0,vis,dfs,adj);
        return dfs;
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
        Dfs obj = new Dfs();
        ArrayList<Integer> result = obj.dfs(adj);
        System.out.println("DFS Traversal:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
