package Java.HeapDS;

import java.util.PriorityQueue;

public class NRope {

    public static void findMinCost(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minCost = 0;
        for(int i = 0; i<ropes.length; i++){
            pq.add(ropes[i]);
        }
        while(pq.size()!=1){
            int currCost = pq.poll() + pq.poll();
            pq.add(currCost);
            minCost = minCost+currCost;
        }
        System.out.println("Minimum cost = " + minCost);
    }
    public static void main(String[] args){
        int ropes[] = {4,3, 3, 2, 6};
        findMinCost(ropes);
    }
}
