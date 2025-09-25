import java.util.*;
import java.util.LinkedList;
public class Stack2Queue {

    static class StackPopOn{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;

            if(!q1.isEmpty()){
              while(!q1.isEmpty()){
                top = q1.remove();
                if(q1.isEmpty()){
                    break;
                }
                q2.add(top);
             }
            }else{
                while(!q2.isEmpty()){
                    top  = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }

            }
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;

            if(!q1.isEmpty()){
              while(!q1.isEmpty()){
                top = q1.remove();
                q2.add(top);
             }
            }else{
                while(!q2.isEmpty()){
                    top  = q2.remove();
                    q1.add(top);
                }

            }
            return top;
        }
    }   

    static class StackPushOn{
       static Queue<Integer> q1 = new LinkedList<>();
       static Queue<Integer> q2 = new LinkedList<>();

       public static boolean isEmpty(){
        return q1.isEmpty();
       }

       //push O(n)
       public static void push(int data){
         q2.add(data);
         while(!q1.isEmpty()){
            q2.add(q1.remove());
         }

         Queue<Integer> temp = q1;
         q1 = q2;
         q2 = temp;
       }

       //pop O(1)
       public static int pop(){
        if(q1.isEmpty()){
            System.out.println("stack empty");
            return -1;
        }
        return q1.remove();
       }

       //peek O(1)
       public static int peek(){
          if(q1.isEmpty()){
              System.out.println("stack empty");
              return -1;
          }
          return q1.peek();
       }

    }
    
    public static void main(String[] args){
           StackPushOn s = new StackPushOn();
           s.push(1);
           s.push(2);
           s.push(3);

           while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
           }
    }
}
