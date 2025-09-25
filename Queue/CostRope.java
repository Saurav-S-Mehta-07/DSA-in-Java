import java.util.*;

public class CostRope {
    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : ropes) {
            pq.add(rope);
        }

        int totalCost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();   // shortest rope
            int second = pq.poll();  // second shortest rope

            int cost = first + second;
            totalCost += cost;

            pq.add(cost); 
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println(minCost(ropes)); // 29
    }
}
