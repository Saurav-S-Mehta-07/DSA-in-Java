import java.util.Scanner;

public class LinkedList{
    public static class Node{
        int data;
        Node next;
        //construtor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //Methods
    public void addFirst(int data){
       //step1 = create new node
        Node newNode = new Node(data);
        size++;

        if(head==null){
           head = tail = newNode;
           return;
        }

        //step2 = newNode next = head;
        newNode.next = head; //link

        //step3 - head = newNode
        head = newNode;

    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void display(){
        if(head==null){
            System.out.println("linked list is empty");
            return;         
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i<idx-1){
            temp = temp.next;
            i++;
        }

        //i == idx-1; temp->prev
        newNode.next = temp.next;
        temp.next = newNode;
    }


    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val  = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        //prev: i=size-2;
        Node prev = head;
        for(int i = 0; i<size-2; i++){
          prev = prev.next;
        }
        int val = prev.next.data; //tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key){//key found
       Node temp = head;
       int i = 0;

       while(temp!=null){
        if(temp.data==key){
            return i;
        }
        temp = temp.next;
        i++;
       }
       //key not found
       return -1;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail = head;
        head = prev;
    }

    public void deleteNthformEnd(int n){
        //calculating size;
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }

        if(n==sz){
            head = head.next;//remove first
            return;
        }

        //sz-n
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
          prev = prev.next;
          i++;
        }
        prev.next = prev.next.next;
        size--;
        return;
    }


    //Slow-Fast Approach
    public Node findMid(Node head){ //helper
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //slow is my middle Node;
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step1 - find mid
        Node midNode = findMid(head);

        //step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; //right half head
        Node left = head;

        //step3 - check left half & right half
        while(right != null){
            if(left.data!=right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }


    
   //isCycle
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
               cycle = true;
               break;
            }
        }
        if(cycle == false){
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle -> lastNode.next = null;
        prev.next = null;
    }

    //helper for mergesort
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;//mid node
    }

    private Node merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
               temp.next = head1;
               head1 = head1.next;
               temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }


    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //left and right halves
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //merge
        return merge(newLeft,newRight);
    }

    public void zigZag(){
        //mid
        Node midNode = findMid(head);

        //reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr!=null){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
        }

        Node right = prev;
        Node left =  head;
        Node nextL;
        Node nextR;
        //zig-zag
        while(left.next != null && right.next!=null){
           nextL = left.next;
           left.next = right;
           left = nextL;

           nextR = right.next;
           right.next = left;
           right = nextR;
        }

    }

    

    //Y-Shape(intersection point)
    public static Node intersection(Node head1, Node head2){
         int len1 = getLength(head1);
         int len2 = getLength(head2);
         
         //move the longer list's head forward
         while(len1>len2){
            head1  = head1.next;
            len1--;
         }
         while(len2>len1){
            head2 = head2.next;
            len2--;
         }

         //traverse together
         while(head1!=null && head2!=null){
            if(head1==head2){
                System.out.println(head1.data);
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
         }
         return null;

    }

    //helper of intersection
    public static int getLength(Node head){
        int length = 0;
        while(head!=null){
            head = head.next;
            length++;
        }
        return length;
    }

    //delete n nodes after m nodes of a linked list

  public static void retainMdeleteN(Node head, int m, int n) {
    Node curr = head;

    while (curr != null) {
        // 1. Retain m nodes
        for (int i = 1; i < m && curr != null; i++) {
            curr = curr.next;
        }

        // If we reached end after retaining
        if (curr == null) return;

        // 2. Delete next n nodes
        Node temp = curr.next;
        for (int i = 0; i < n && temp != null; i++) {
            temp = temp.next;
            size--;
        }

        // 3. Link retained part to the rest
        curr.next = temp;

        // Move curr to the next retained block
        curr = temp;
    }
}

   //swapping node
  public static void swapping(int x, int y) {
    if (x == y) return; // Nothing to swap

    Node prevX = null, currX = head;
    Node prevY = null, currY = head;

    // Search for x
    while (currX != null && currX.data != x) {
        prevX = currX;
        currX = currX.next;
    }

    // Search for y
    while (currY != null && currY.data != y) {
        prevY = currY;
        currY = currY.next;
    }

    // If either is not found, do nothing
    if (currX == null || currY == null) return;

    // If x is not head
    if (prevX != null)
        prevX.next = currY;
    else
        head = currY;

    // If y is not head
    if (prevY != null)
        prevY.next = currX;
    else
        head = currX;

    // Swap next pointers
    Node temp = currX.next;
    currX.next = currY.next;
    currY.next = temp;
}

   //odd even seperate

  public static void evenBeforeOdd() {
     if(head == null || head.next == null){
        return;
     }

     Node curr = head;
     Node evenStart, evenEnd, oddStart, oddEnd;
     evenStart = evenEnd = oddEnd = oddStart = null;

     while(curr!=null){
        if(curr.data%2==0){//even
            if(evenStart==null){
                evenStart = evenEnd = curr;
            }
            else{
                evenEnd.next = curr;
                evenEnd = curr;
            }
        }
        else{
            if(oddStart == null){
                oddStart = oddEnd = curr;
            }
            else{
                oddEnd.next = curr;
                oddEnd = curr;
            }
        }
        curr = curr.next;
     }

     if(evenStart == null ||oddStart == null){
        return;
     }

     evenEnd.next = oddStart;
     oddEnd.next = null;
     head = evenStart;
  }



    public static void main(String[] args){

        Node l1, l2, l3;
        l1 = new Node(1);
        l1.next = new Node( 2);
        l1.next.next = null;

        l2 = new Node(6);
        l2.next = new Node( 8);
        l2.next.next = null;

        l3 = new Node(9);
        l3.next = new Node( 10);
        l3.next.next = null;
    }
}