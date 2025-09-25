package Java.HeapDS;

import java.util.PriorityQueue;

public class SlidingWindow {

    static class Info{
        int idx;
        int data;
        Info(int idx, int data){
            this.idx = idx;
            this.data = data;
        }
    }

    public static void findMaxSubK(int window[], int k){
       PriorityQueue<Info> pq = new PriorityQueue<>((a,b)->b.data-a.data);
       for(int i = 0; i<k; i++){
         pq.add(new Info(i, window[i]));
       }
       for(int i = k; i<window.length; i++){
          System.out.print(" "+pq.peek().data);
          while(!pq.isEmpty() && pq.peek().idx <= (i-k)){
            pq.remove();
          }
          pq.add(new Info(i, window[i]));
       }
        System.out.print(" "+pq.peek().data);
    }

    public static void main(String[] args){
        int window[] = {1,6,3,4,5,1,7,8,9,10};
        int k = 3;
        findMaxSubK(window,k);
    }
}
