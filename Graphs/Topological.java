//topological sorting

package Graphs;

import java.util.*;

public class Topological {

    public static class  Edge {
        int src,dest,wt;
        public Edge(int src,int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt=wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));

        graph[2].add(new Edge(2, 3, 0));

        graph[3].add(new Edge(3, 1, 0));

        graph[4].add(new Edge(4, 0, 0));
        graph[4].add(new Edge(4, 1, 0));

    }

    //using dfs
    public static void topologicalSort(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<graph.length; i++){
            if(!visited[i]){
                topologicalSortUtil(graph,visited,stack,i);
            }
        }

        System.out.print("Topological Sorting : ");
        while(!stack.isEmpty()){
            System.out.print(" "+ stack.pop());
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[]graph, boolean visited[], Stack<Integer> stack, int curr){
        visited[curr] = true;
        for(int v  = 0; v<graph[curr].size();v++){
            int neigh = graph[curr].get(v).dest;
            if(!visited[neigh]){
                topologicalSortUtil(graph, visited, stack, neigh);
            }
        }
        stack.push(curr);
    }

    //using bfs
    public static void calcIndeg(ArrayList<Edge>[] graph, int[] indeg){
        for(int i = 0; i<graph.length; i++){
            int v = i;
            for(int j = 0; j<graph[v].size(); j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topoSortBFS(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        calcIndeg(graph, indeg);

        for(int i = 0; i<indeg.length; i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr  = q.poll();
            System.out.print(curr + " ");
            for(int i = 0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i); 
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }


    public static void main(String[] args){
      int V = 6;
      @SuppressWarnings("unchecked")
      ArrayList<Edge>[] graph = new ArrayList[V];
      
      createGraph(graph);

    //   topologicalSort(graph);
      topoSortBFS(graph);

    }
    
}
