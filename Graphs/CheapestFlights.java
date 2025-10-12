package Graphs;
import java.util.*;
public class CheapestFlights {

    public static class Edge{
        int src,dst,wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
    }
    
    public static void createGraph(ArrayList<Edge> graph[], int [][] flights){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<flights.length; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];

            Edge e = new Edge(src, dest, price);
            graph[src].add(e);
        }

    }

    public static class Info{
        int v,cost,stop;
        public Info(int v, int c, int s){
            this.v = v;
            this.cost = c;
            this.stop = s;
        }
    }

    public static int findCheapestPrice(int[][] flights, int src, int dst, int k){

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[flights.length];
        createGraph(graph,flights);

        int dist[] = new int[graph.length];

        for(int i = 0; i<dist.length; i++){
            if(i!=src) dist[i] = Integer.MAX_VALUE;
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0,0,0));

        while(!q.isEmpty()){
            Info curr = q.poll();
            if(curr.stop > k){
                break;
            }

            for(int i = 0; i<graph[curr.v].size(); i++){
                Edge e= graph[curr.v].get(i);
                int u = e.src;
                int v = e.dst;
                int wt = e.wt;
                if(curr.cost+wt < dist[v] && curr.stop <= k){
                    dist[v] = curr.cost+wt;
                    q.add(new Info(v, dist[v], curr.stop+1));
                }
            }
        }

        //dist[cost]
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dist[dst];
        }

    }

   public static void main(String[] args){
      
      int flights[][] = {
        {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}
      };
      

      int src = 0, dst = 3, k = 1;
      int res = findCheapestPrice(flights, src, dst, k);
      System.out.println(res);
   }

}
