package Java.HeapDS;

import java.util.PriorityQueue;

public class KthLargest {

    public static void findKthLargest(int stream[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<stream.length; i++){
            pq.add(stream[i]);
            if(pq.size() < k){
               System.out.print(" "+"_");
            }else{
                if(pq.size() > k){
                    pq.remove();
                }
                System.out.print(" "+pq.peek());
            }
        }
    }
    public static void main(String[] args){
        int stream[]= {10, 20, 11, 70, 50, 40, 100, 5};
        int k = 3;
        findKthLargest(stream, k);
    }
}
