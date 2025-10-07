//all path from sourse to target in directed graph
package Graphs;

import java.util.ArrayList;

public class AllPath {

    public static class Edge{
        int src, dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));

        graph[0].add(new Edge(0, 3));
    }

    public static void printAllPath(ArrayList<Edge>[] graph, ArrayList<Integer> path, int src, int target){
        if(src==target){
            System.out.println(path);
            return;
        }
        
        for(int v =  0; v<graph[src].size(); v++){
            int neigh = graph[src].get(v).dest;
            path.add(neigh);
            printAllPath(graph, path, neigh, target);
            path.remove(path.size()-1);
        }
    }
    
    public static void main(String[] args){
       int V = 6;
       @SuppressWarnings("unchecked")
       ArrayList<Edge>[] graph = new ArrayList[V];
       createGraph(graph);

       int src = 5;
       int target = 1;
       ArrayList<Integer> path = new ArrayList<>();
       path.add(src);
       printAllPath(graph, path, src, target);
    }

}
