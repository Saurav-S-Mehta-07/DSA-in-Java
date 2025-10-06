//DFS Graph Traversal
package Graphs;
import java.util.*;
public class HasPath {

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

    //dfs traversing - O(V+E) 
    public static boolean hasPath1(ArrayList<Edge> graph[],boolean visited[], int src, int dest){
        if(src == dest){
            return true;
        }
        visited[src] = true;
         for(int v  = 0; v<graph[src].size(); v++){
            int neigh = graph[src].get(v).dest;
            if(!visited[neigh]){
                return hasPath1(graph, visited, neigh, dest);
            }
         }
         return false;
    }


    //using bfs
    public static boolean hasPath2(ArrayList<Edge> graph[],boolean visited[], int src, int dest){

        Queue<Integer> q = new LinkedList<>();
        
        q.add(src);

        while(!q.isEmpty()){
            int curr = q.poll();
            if(!visited[curr]){
                visited[curr] = true;
                for(int v = 0; v<graph[curr].size(); v++){
                    int neigh = graph[curr].get(v).dest;
                    if(neigh == dest){
                        return true;
                    }
                    q.add(neigh);
                }
            }
        }
        return false;

    }

    public static void main(String[] args){
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        
        createGraph(V, graph);
         
        //DFS traversal of  graph
        boolean visited[] = new boolean[V];
        int src = 0; 
        int dest = 0;
        boolean res  =  hasPath1(graph,visited, src, dest);
        System.out.println(res);
    }
}
