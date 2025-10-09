//find minimum depth of a binary tree -> using graph dfs

package Graphs;

import java.util.*;

public class minHeightBT {

    public static void addEdge(ArrayList<Integer>[] graph, int src, int dest){
          graph[src].add(dest);
    }

    public static int findMinDepth(ArrayList<Integer>[] graph, int src){

        if(graph[src].size() == 0){
            return 1;
        }

        if(graph[src].size() == 2){
           int n1 = graph[src].get(0);
           int n2 = graph[src].get(1);
   
           int leftHeight = findMinDepth(graph, n1);
           int rightHeight = findMinDepth(graph, n2);

           int minHeight = Math.min(leftHeight, rightHeight);
         
           return minHeight+1;
        }

        else{
            return findMinDepth(graph, graph[src].get(0))+1;
        }

    }
    

    public static void main(String[] args){
        int V = 10;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        // addEdge(graph, 1, 2);
        // addEdge(graph, 1,8);
        // addEdge(graph, 8, 5);
        // addEdge(graph, 8, 6);
        // addEdge(graph, 2, 9);

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 4);
        addEdge(graph, 4, 9);
        addEdge(graph, 4, 5);
        addEdge(graph, 5, 7);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 6);
        addEdge(graph, 6, 8);



        System.out.println(findMinDepth(graph, 0));

    }


}
