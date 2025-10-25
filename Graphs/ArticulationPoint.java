//find articulation point using Tarjan's Algo

import java.util.*;
public class ArticulationPoint {
    
    public static class  Edge {
           int src,  dest;
           public Edge(int s ,int d){
            src = s; dest = d;
           }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int s, int d){
        graph[s].add(new Edge(s, d));
        graph[d].add(new Edge(d, s));
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        addEdge(graph, 0,1);
        addEdge(graph, 1,2);
        addEdge(graph, 0,2);
        addEdge(graph, 0,3);
        addEdge(graph, 3,4);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par,
       int dt[], int low[], int time, boolean[] vis, boolean[] ap)
    {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for(int i = 0; i<graph[curr].size(); i++){
            int neigh = graph[curr].get(i).dest;

            if(neigh == par){
                continue;
            }
            else if(vis[neigh]){
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
            else{
                dfs(graph, neigh, curr, dt, low, time, vis, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(par!=-1 && dt[curr]<=low[neigh]){
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1  && children >1){
           ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge>[] graph){
        int dt[] = new int[graph.length];
        int low[] =new int[graph.length];
        int time = 0;
        boolean[] vis = new boolean[graph.length];
        //sometime one AP print multiple time to beat it we make a bool arr
        boolean[] ap = new boolean[graph.length];

        for(int i= 0; i<graph.length; i++){
            if(!vis[i]){
                dfs(graph, i, -1, dt, low, time, vis, ap);
            }
        }

        //print all APs
        for(int i =0; i<graph.length; i++){
            if(ap[i]){
                System.out.println("AP : " + i);
            }
        }
    }

    public static void main(String[] args){
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getAP(graph);

    }

}
