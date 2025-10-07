//Undirected graph is cycle 
package Graphs;
import java.util.*;
public class IsCycle {

    public static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
           this.src = src;
           this.dest = dest;
           this.wt = wt;
        }
    }

    public static void createGraph(int V, ArrayList<Edge> graph[]){
         for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 0));
        // graph[0].add(new Edge(0, 2, 0));   
        graph[0].add(new Edge(0, 3, 0));


        graph[1].add(new Edge(1, 2, 0));
        graph[1].add(new Edge(1, 0, 0));

        graph[2].add(new Edge(2, 1, 0));
        // graph[2].add(new Edge(2, 0, 0));

        graph[3].add(new Edge(3, 0, 0));
        graph[3].add(new Edge(3, 4, 0));

        graph[4].add(new Edge(4, 3, 0));
    }


    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(!visited[i]){
                return detectCycleUtil(graph,visited,i,-1);
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean visited[], int src,int par){
        visited[src] = true;
        for(int v = 0; v<graph[src].size(); v++){
            int neigh = graph[src].get(v).dest;
            if(!visited[neigh]){
                return detectCycleUtil(graph, visited,neigh,src);
            }
            else if(visited[neigh] && neigh!=par){
                return true;
            }
        } 
        return false;       
    }
    public static void main(String[] args){
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        
        createGraph(V, graph);
         
        boolean res = detectCycle(graph);
        System.out.println(res);
    }
}
