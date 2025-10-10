//is bipartite graph
package Graphs;
import java.io.LineNumberInputStream;
import java.util.*;
public class Bipartite {

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

    public static void createGraph(ArrayList<Edge> graph[]){
         
        graph[0].add(new Edge(0, 1, 0));
        // graph[0].add(new Edge(0, 2, 0));
        graph[0].add(new Edge(0, 4, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 4, 0));
        // graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 3, 0));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, 0));

        graph[4].add(new Edge(4, 0, 0));
        graph[4].add(new Edge(4, 2, 0));
      
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];
        for(int i =0; i<color.length; i++) color[i] = -1;

        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<graph.length; i++){
            if(color[i]==-1){
               q.add(i);
               color[i] = 0; //red
               while(!q.isEmpty()){
                int curr = q.poll();
                for(int v = 0;v<graph[curr].size(); v++){
                    int neigh = graph[curr].get(v).dest;
                    if(color[neigh] == -1){
                        color[neigh] = color[curr] == 0? 1: 0;
                        q.add(neigh);
                    }
                    else if(color[neigh] == color[curr]){
                        return false; //not bipartite
                    }
                }
               }
            }
        }
        return true;
    }
      
  public static boolean bipartite(ArrayList<Edge>[] graph){
        int color[] = new int[graph.length];
        for(int i = 0; i<color.length; i++) color[i] = -1;
        for(int i = 0; i<graph.length; i++){
            if(color[i] == -1){
                if(!bipartiteUtil(graph, color, i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bipartiteUtil(ArrayList<Edge>[] graph, int[] color, int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0; //red
        while(!q.isEmpty()){
         int curr = q.poll();
         for(int v = 0;v<graph[curr].size(); v++){
             int neigh = graph[curr].get(v).dest;
             if(color[neigh] == -1){
                 color[neigh] = color[curr] == 0? 1: 0;
                 q.add(neigh);
             }
             else if(color[neigh] == color[curr]){
                 return false; //not bipartite
             }
         }
        }
        return true;
    }

    public static void main(String[] args){
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        
        createGraph(graph);
         
        boolean res = bipartite(graph);
        System.out.println(res);
    }
}
