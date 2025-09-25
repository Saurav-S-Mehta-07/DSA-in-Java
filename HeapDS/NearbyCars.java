package Java.HeapDS;

import java.util.PriorityQueue;

public class NearbyCars {

    static class Points{
        int x, y, distSq;
        Points(int x, int y){
            this.x  = x;
            this.y = y;
            this.distSq = x*x + y*y;
        }
    }

    public static void findNearK(int pts[][], int k){
       PriorityQueue<Points> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.distSq, b.distSq)
        );

       for(int pt[] : pts){
           pq.add(new Points(pt[0], pt[1]));
       }
       for(int i = 0; i<k; i++){
        System.out.println("("+pq.peek().x + ","+pq.peek().y+") -> "+ pq.peek().distSq);
        pq.remove();
       }
    }

    public static void main(String[] args){
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        findNearK(pts,k);
    }
}
