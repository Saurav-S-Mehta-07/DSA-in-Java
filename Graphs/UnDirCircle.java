//detect cycle in undirected graph using BFS

package Graphs;
import java.util.*;

public class UnDirCircle {

    public static void addEdge(ArrayList<Integer>[] graph, int src, int dest){
        graph[src].add(dest);
        graph[dest].add(src);
    }

    public static boolean isCycle(ArrayList<Integer>[] graph){

        boolean visited[] = new boolean[graph.length];

        for(int i = 0; i<graph.length; i++){
            if(!visited[i]){
                if(isCycleUtil(graph, visited, i)){
                    return true;
                }
            }
        }
         
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Integer>[] graph, boolean visited[], int src){
        int par[] = new int[graph.length];
        Arrays.fill(par,-1);

        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited[src] = true;

        while(!q.isEmpty()){
            int curr= q.poll();
            for(int v : graph[curr]){
                if(!visited[v]){
                    visited[v] = true;
                    par[v] = curr;
                    q.add(v);
                }
                else if(visited[v] && v != par[curr]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]){

        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[V];

        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph, 1, 2);
        addEdge(graph,1,3);

        if(isCycle(graph)){
            System.out.println("yes cycle");
        }
        else{
            System.out.println("no cycle");
        }

    }

}