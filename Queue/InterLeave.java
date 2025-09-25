import java.util.*;
import java.util.LinkedList;
public class InterLeave {

    public static void interleave(Queue<Integer> q){
        Queue<Integer> first = new LinkedList<>();
        int size = q.size();
        int firstSize=size/2;
        for(int i = 0; i<firstSize; i++){
            first.add(q.remove());
        }
        while(!first.isEmpty()){
            q.add(first.remove());
            q.add(q.remove());
        }
        
    }
    
    public static void main(String[] args){
         Queue<Integer>  q = new LinkedList<>();
         q.add(1); q.add(2);
         q.add(3);
         q.add(4); q.add(5); 
         q.add(6); q.add(7);
         q.add(8); q.add(9);
         q.add(10);

         interleave(q);
         int size = q.size();
         for(int i  = 0; i<size; i++){
            System.out.print(" " +q.peek());
            q.remove();
        }

    }

}
