package Graphs;
import java.util.*;

public class TargansAlgo {

    static int time; // Global time counter

    // Add undirected edge
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Utility function for DFS traversal
    static void APUtil(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited,
                       int[] disc, int[] low, int parent, boolean[] isAP) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;
        // Go through all vertices adjacent to this
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                APUtil(adj, v, visited, disc, low, u, isAP);

                // Check if the subtree rooted with v has a connection to
                // one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // u is an articulation point in following cases

                // (1) u is not root and low value of one of its child is more than discovery value of u
                if (parent != -1 && low[v] >= disc[u])
                    isAP[u] = true;
            }
            // Update low value of u for parent function calls
            else if (v != parent)
                low[u] = Math.min(low[u], disc[v]);
        }

        // (2) u is root of DFS tree and has two or more children
        if (parent == -1 && children > 1)
            isAP[u] = true;
    }

    // Function to find articulation points
    static void AP(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        time = 0;
        int parent = -1;

        for (int u = 0; u < V; u++)
            if (!visited[u])
                APUtil(adj, u, visited, disc, low, parent, isAP);

        for (int u = 0; u < V; u++)
            if (isAP[u])
                System.out.print(u + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {

        // ===== Graph 1 =====
        int V = 5;
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj1.add(new ArrayList<>());

        addEdge(adj1, 1, 0);
        addEdge(adj1, 0, 2);
        addEdge(adj1, 2, 1);
        addEdge(adj1, 0, 3);
        addEdge(adj1, 3, 4);

        System.out.println("Articulation points in first graph:");
        AP(adj1, V);

        // ===== Graph 2 =====
        V = 4;
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj2.add(new ArrayList<>());

        addEdge(adj2, 0, 1);
        addEdge(adj2, 1, 2);
        addEdge(adj2, 2, 3);

        System.out.println("Articulation points in second graph:");
        AP(adj2, V);

        // ===== Graph 3 =====
        V = 7;
        ArrayList<ArrayList<Integer>> adj3 = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj3.add(new ArrayList<>());

        addEdge(adj3, 0, 1);
        addEdge(adj3, 1, 2);
        addEdge(adj3, 2, 0);
        addEdge(adj3, 1, 3);
        addEdge(adj3, 1, 4);
        addEdge(adj3, 1, 6);
        addEdge(adj3, 3, 5);
        addEdge(adj3, 4, 5);

        System.out.println("Articulation points in third graph:");
        AP(adj3, V);
    }
}
