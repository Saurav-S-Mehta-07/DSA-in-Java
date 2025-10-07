//directed graph is cycle 
package Graphs;
import java.util.*;
public class IsCycleDire {

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
        graph[0].add(new Edge(0, 2, 0));
        graph[0].add(new Edge(0, 1, 0));
        graph[1].add(new Edge(1, 3, 0)); 
        graph[2].add(new Edge(2, 3, 0));

        // graph[0].add(new Edge(0, 2, 0));
        // graph[1].add(new Edge(1, 0, 0));
        // graph[2].add(new Edge(2, 3, 0));
        // graph[3].add(new Edge(3, 0, 0));

    }


    public static boolean detectCycle(ArrayList<Edge> graph[]){
       boolean visited[] = new boolean[graph.length];
       boolean stack[] = new boolean[graph.length];
       for(int i = 0; i<graph.length; i++){
           if(!visited[i]){
               if(detectCycleUtil(graph, visited, stack, i)){
                return true;
               }
           }
       }
       return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean[] visited, boolean[] stack, int i){
         visited[i] = true;
         stack[i] = true;
         for(int v = 0; v<graph[i].size(); v++){
            int neigh = graph[i].get(v).dest;
            if(stack[neigh]==true){
                return true;
            }
            if(!visited[neigh]){
                if(detectCycleUtil(graph, visited, stack, neigh)){
                    return true;
                }
            }
         }
        stack[i] = false;
         return false;
    }
    public static void main(String[] args){
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        
        createGraph(graph);
         
       boolean res = detectCycle(graph);
       System.out.println(res);
    }
}
