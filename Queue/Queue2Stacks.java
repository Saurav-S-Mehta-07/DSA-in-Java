import java.util.*;
public class Queue2Stacks {

    static class QueuePushOn{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //add O(n)
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //remove O(1);
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }

            return s1.pop();
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            return s1.peek();
        }
    }
    
    static class QueuePopOn{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //add O(1)
        public static void add(int data){
            s1.push(data);
        }

        //remove O(n);
        public static int remove(){
           if(s1.isEmpty()){
            System.out.println("queue empty");
            return -1;
           }

           while(!s1.isEmpty()){
            s2.push(s1.pop());
           }
           int front = s2.pop();

           while(!s2.isEmpty()){
            s1.push(s2.pop());
           }

           return front;
        }

        //peek
        public static int peek(){
             if(s1.isEmpty()){
            System.out.println("queue empty");
            return -1;
           }

           while(!s1.isEmpty()){
            s2.push(s1.pop());
           }
           int front = s2.peek();

           while(!s2.isEmpty()){
            s1.push(s2.pop());
           }

           return front;
        }
    }
    
    public static void main(String[]  args){
          QueuePopOn q = new QueuePopOn();
          q.add(1);
          q.add(2);
          q.add(3);

          while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
          }
    }
}
