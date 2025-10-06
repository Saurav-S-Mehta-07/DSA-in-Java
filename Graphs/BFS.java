//BFS Graph Traversal
package Graphs;
import java.util.*;
public class BFS {

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

    //bfs traversing - O(V+E) ~ O(n)
    public static void bfsTranversal(int V,ArrayList<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.poll();
            if(!visited[curr]){
                visited[curr] = true;
                System.out.print(curr + " ");
                for(int i = 0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args){
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        
        createGraph(V, graph);
         
        //BFS traversal of  graph
        bfsTranversal(V,graph);
    }
}
