import java.util.*;

public class SingllyCLL {

    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    Scanner sc = new Scanner(System.in);

    //create
    public void create(){
        System.out.print("enter size of list: ");
        int n;
        n = sc.nextInt();
        for(int i = 0; i<n; i++){
            System.out.print("enter "+ (i+1) + " data: ");
            int data = sc.nextInt();
            Node newNode  = new Node(data);
            size++;
            if(i==0){
               head = tail = newNode;
               newNode.next = head;
            }
            else{
                newNode.next = head;
                tail.next = newNode;
                tail = newNode;
            }
        }
        System.out.println("created");

    }

    //display

    public void display(){
        if(size==0){
            System.out.println("CLL is empty");
            return;
        }
        Node temp = head;
        while(temp.next != head){
          System.out.print(temp.data + "<->");
          temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }


    //add first
    public void addFirst(){
        System.out.print("enter data to insert at first: ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        if(size == 0){
            head = tail = newNode;
            newNode.next = head;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = newNode;
        size++;
    }
    

    //add Last

    public void addLast(){
        System.out.print("enter data to insert at end: ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        if(size==0){
           head = tail = newNode;
           newNode.next = head;
           size++;
           return;
        }
        tail.next = newNode;
        newNode.next=head;
        tail = newNode;
        size++;
    }

    //add at nth position

    public void addAtNth(){
        System.out.println("enter data and index where to insert: ");
        int data = sc.nextInt();
        int idx = sc.nextInt();

        if(idx<0 || idx>=size){
            System.out.println("out of bound");
            return;
        }
        
        Node newNode = new Node(data);
        int i = 0;
        Node prev = head;
        while(i<idx-1){
            prev = prev.next;
            i++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    //remove first

    public int removeFirst(){
        if(size==0){
            System.out.println("CLL is empty");
            return -1;
        }
        else if(size==1){
            int val = head.data;
            head = tail  = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        tail.next = head;
        size--;
        return val;
    }

    //remove last
    public int removeLast(){
        if(size==0){
            System.out.println("CLL is empty");
            return -1;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }

        Node prev = head;

        while(prev.next!=tail){
            prev = prev.next;
        }

        int val= tail.data;

        prev.next = head;
        tail = prev;
        return val;
    }

    //remove form nth position
    public int removeAtNth(){
        System.out.print("enter index: ");
        int idx = sc.nextInt();
        if(idx<0 || idx>=size){
            System.out.println("index out of bound");
            return -1;
        }

        if(idx==0){
            int val = removeFirst();
            return val;
        }
        int i = 0;
        Node prev = head;
        while(i<idx-1){
           prev = prev.next;
           i++;
        }
        System.out.println(prev.data);
        int val= prev.next.data;
        prev.next = prev.next.next;
        return val;
    }

    
    public static void main(String args[]){

        SingllyCLL scll = new SingllyCLL();
    

    }

}
