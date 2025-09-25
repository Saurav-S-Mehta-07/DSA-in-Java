import java.util.*;
public class DoublyLL {
    
    public class Node{
        Node prev;
        int data;
        Node next;

        public Node(int data){
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;


    //add first
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
           return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //add Last
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = null;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

      //remove - removeFirst
    public int removeFirst(){
        if(head == null){
            System.out.println("DLL is empty");;
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }


    //remove last
    public int removeLast(){
        if(head == null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    //reverse
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        tail = head;
        head = prev;
    }

    //add node at nth
    public void addAtNth(int data,int idx){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while(i<idx-1){
            i++;
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        size++;
    }

    //remove nth node
    public int removeAtNth(int idx){
        int i = 0;
        Node temp = head;
        if(idx==0){
            int val = removeFirst();
            return val;
        }
        while(i<idx-1){
           i++;
           temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
        return val;
    }

    public void distroyNodes(){
        while(size!=0){
            removeFirst();
        }
    }

    //display
    public void print(){
        Node temp = head;
        while(temp!=null){
           System.out.print(temp.data + "<->");
           temp = temp.next;
        }
        System.out.println("null");
    }

    //create
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size of linked list: ");
        int n = sc.nextInt();
        System.out.println("enter "+ n +" elements");
        for(int i = 0; i<n; i++){
            System.out.print("enter "+ (i+1) + " element: ");
            int data = sc.nextInt();
            Node newNode = new Node(data);
            size++;
            if(i==0){
                head = tail = newNode;
            }
            else{
                newNode.prev = tail;
                tail.next = newNode;
                newNode.next = null;
                tail = newNode;
            }

        }
        System.out.println("created");
    }

  
    public static void main(String args[]){

        DoublyLL dll = new DoublyLL();
        dll.create();
        dll.print();
        dll.create();
        dll.print();
    }
}
