package DisjointSet;

import java.util.*;

public class KruskalsAlgo {

    public static class Edge implements Comparable<Edge>{
       int src, dest, wt;
       public Edge(int s, int d, int w){
        src = s; dest = d; wt = w;
       }

       @Override
       public int compareTo(Edge e2){
        return this.wt - e2.wt;
       }
    }

    public static void createGraph(ArrayList<Edge>graph){
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0,2,15));
        graph.add(new Edge(0,3,30));
        graph.add(new Edge(1,3,40));
        graph.add(new Edge(3, 2, 60));
    }

    static int n = 4;  
    static int par[] = new int[4];
    static int rank[] = new int[4];

    public static void init(){
        for(int i = 0; i<n; i++) par[i] = i;
    }

    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x] = find(par[x]);
    }
    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB]) par[parA]=parB;
        else par[parB] = parA;
     }


    public static void findMinCost(ArrayList<Edge> graph, int V){
         Collections.sort(graph);
         int mstCost = 0;
         int count = 0;
         init();
         for(int i = 0; count<V-1; i++){
              Edge e = graph.get(i);
              int parA = find(e.src);
              int parB = find(e.dest);
              if(parA!=parB){
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
              }
         }
         System.out.println(mstCost);
    }
    
    public static void main(String[] args){
         int V = 4;
         ArrayList<Edge> graph = new ArrayList<>();
         createGraph(graph);
         findMinCost(graph,V);
    }
}
