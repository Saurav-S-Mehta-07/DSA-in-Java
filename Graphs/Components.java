//Connected components Graph Traversal
package Graphs;
import java.util.*;
public class Components {

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

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 3, 0));
 
        graph[2].add(new Edge(2, 0, 0));

        graph[3].add(new Edge(3, 1, 0));

        graph[4].add(new Edge(4, 5, 0));

        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 6, 0));

        graph[6].add(new Edge(6, 5, 0));

    }

    public static void traverse(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(!visited[i]){
                dfsUtil(graph, visited, i);
            }
        }
    }

    //dfs util
    public static void dfsUtil(ArrayList<Edge> graph[],boolean visited[], int src){
       System.out.print(src+ " ");
       visited[src] = true;
       for(int v = 0; v<graph[src].size(); v++){
          int neigh = graph[src].get(v).dest;
          if(!visited[neigh]){
            dfsUtil(graph, visited, neigh);
          }
       }
    }

    //bfs util
    public static void bfsUtil(ArrayList<Edge> graph[], boolean visited[], int src){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int curr = q.poll();
            if(!visited[curr]){
                visited[curr] = true;
                System.out.print(curr+" ");
                for(int v = 0; v<graph[curr].size(); v++){
                    int neigh = graph[curr].get(v).dest;
                    q.add(neigh);
                }
            }
        }
    }

    public static void main(String[] args){
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        
        createGraph(V, graph);
         
        traverse(graph);
       
    }
}
