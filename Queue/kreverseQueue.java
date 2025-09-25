import java.util.*;
import java.util.LinkedList;

public class kreverseQueue{

    public static void kReverse(Queue<Integer> q, int k){
        
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<k; i++){
           stack.push(q.poll());
        }

        int n2 = q.size();
    
        while(!stack.isEmpty()){
          q.add(stack.pop());
        }

        for(int i = 0; i<n2; i++){
            q.add(q.poll());
        }

        while(!q.isEmpty()){
            System.out.print(" " + q.poll());
        }
    }
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
     
        int k= 5;

        kReverse(q,k);
    }
}