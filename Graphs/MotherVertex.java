package Graphs;
import java.util.*;

public class MotherVertex {
    static class Graph {
        int V;
        ArrayList<ArrayList<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
        }

        void DFSUtil(int v, boolean[] visited) {
            visited[v] = true;
            for (int nbr : adj.get(v)) {
                if (!visited[nbr])
                    DFSUtil(nbr, visited);
            }
        }

        int findMotherVertex() {
            boolean[] visited = new boolean[V];
            int lastV = -1;

            // Step 1: find last finished vertex
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    DFSUtil(i, visited);
                    lastV = i;
                }
            }

            // Step 2: check if lastV is actually mother vertex
            Arrays.fill(visited, false);
            DFSUtil(lastV, visited);

            for (boolean v : visited) {
                if (!v)
                    return -1;
            }

            return lastV;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);

        System.out.println("Mother Vertex is: " + g.findMotherVertex());
    }
}
