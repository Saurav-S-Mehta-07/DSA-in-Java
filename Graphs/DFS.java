//DFS Graph Traversal
package Graphs;
import java.util.*;
public class DFS {

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
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 3, 0));
        graph[1].add(new Edge(1, 0, 0));

        graph[2].add(new Edge(2, 4, 0));
        graph[2].add(new Edge(2, 0, 0));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 5, 0));
        graph[3].add(new Edge(3, 4, 0));

        graph[4].add(new Edge(4, 5, 0));
        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 2, 0));

        graph[5].add(new Edge(5, 6, 0));
        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 3, 0));

        graph[6].add(new Edge(6, 5, 0));
    }

    //dfs traversing - O(V+E) ~ O(n)
    public static void dfsTranversal(ArrayList<Edge> graph[],int i,boolean visited[] ){
       
       System.out.print(i + " ");
       visited[i] = true;

       for(int v = 0; v<graph[i].size(); v++){
           int neigh = graph[i].get(v).dest;
           if(!visited[neigh]){
              dfsTranversal(graph, neigh, visited);
           }
       }
    }
    public static void main(String[] args){
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        
        createGraph(V, graph);
         
        //DFS traversal of  graph
        boolean visited[] = new boolean[V];
        dfsTranversal(graph,0,visited);
    }
}
