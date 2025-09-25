import java.util.*;
import java.util.LinkedList;
public class DequeJCF {

    //JCF deque(interface)
    public static void JCFdeque(){
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        System.out.println(deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);
        System.out.println("first el : " + deque.getFirst());
        System.out.println("last el: "+ deque.getLast());
    }
    
    //implementation of stack using deque
    static class Stack{
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }

        public int pop(){
            if(deque.isEmpty()){
                return -1; //stack is empty
            }
            return deque.removeLast();
        }

        public int peek(){
             if(deque.isEmpty()){
                return -1; //stack is empty
            }
            return deque.getLast(); 
        }
    }

    //implementation of queue using deque
    static class Queue{
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            if(deque.isEmpty()){
                return -1; //queue is empty
            }
            return deque.removeFirst();
        }

        public int peek(){
            if(deque.isEmpty()){
                return -1; //queue is empty
            }
            return deque.getFirst();
        }
    }
  public static void main(String[] args){

    Queue q = new Queue();
    q.add(1);
    q.add(2);
    q.add(3);
    System.out.println("peek = "+ q.peek());
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.remove());
    
  }  
}
