//Bridge in graphs
import java.util.*;
public class TarjansAlgo {

    public static class Edge{
        int src, dest;
        public Edge(int s, int d){
            src = s; dest = d;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int s, int d){
        graph[s].add(new Edge(s, d));
        graph[d].add(new Edge(d, s));
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        addEdge(graph, 1,0);
        addEdge(graph, 1, 2);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 3, 4);
        // addEdge(graph, 3, 5);
        // addEdge(graph, 4, 5);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, 
        int par, int dt[], int low[], boolean[] vis, int time)
    {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        
        for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i); //e.src -> e.dest
            int neigh = e.dest;
            if(neigh==par){
                continue;
            }
            else if(!vis[neigh]){
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr]<low[neigh]){
                    System.out.println("Bridge: "+ curr + "------" + neigh);
                }
            }
            else{
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge>[] graph){
        int V = graph.length;
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for(int i = 0; i<V; i++){
            if(!vis[i]){
               dfs(graph, i,-1, dt, low, vis, time);
            }
        }
    }
    
    public static void main(String[] args) {
        int V  = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        tarjanBridge(graph);
    }

}
