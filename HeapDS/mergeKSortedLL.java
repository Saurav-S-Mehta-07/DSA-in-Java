package Java.HeapDS;
import java.util.*;

public class mergeKSortedLL {

    static class Node{
      int data;
      Node next;
      Node(int data){
        this.data = data;
        this.next = null;
      }
    }

    public static void mergeLists(Node list1, Node list2, Node list3){

      PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.data - b.data);
      
      pq.add(list1); pq.add(list2); pq.add(list3);
      
      Node head = new Node(0); //dummy node
      Node ptr = head;
      while(!pq.isEmpty()){
        Node curr = pq.poll();
        ptr.next = curr;
        ptr =  ptr.next;

        if(curr.next!=null) pq.add(curr.next);
      }

      head = head.next;
      ptr = head;
      while(ptr!=null){
        System.out.print(" "+ ptr.data);
        ptr = ptr.next;
      }

    }
    
    public static void main(String[] args){
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(8);
        
        Node list3 = new Node(9);
        list3.next = new Node(10);
        list3.next.next = new Node(11);

        mergeLists(list1,list2,list3);
    }
    
}
