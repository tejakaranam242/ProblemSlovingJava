import java.util.*;
public class NoofComponents {
    static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> edges) {
        vis[node] = true;
        for (int i : edges.get(node)) {
            if (vis[i] == false) {
                dfs(i, vis, edges);
            }
        }
    }
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjLs.get(u).add(v);
            adjLs.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        int result = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfs(i, vis, adjLs);
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(u);
            edge.add(v);
            edges.add(edge);
        }
        NoofComponents obj = new NoofComponents();
        int result = obj.countConnected(V, edges);
        System.out.println("Connected Components: " + result);
    }
}