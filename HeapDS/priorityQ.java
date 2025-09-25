package Java.HeapDS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQ {

    static class Student{
        int rank;
        String name;
        Student(int rank, String name){
            this.name = name;
            this.rank = rank;
        }
    }
    public static void main(String args[]){
        PriorityQueue<Student> pq = new PriorityQueue<>((a,b)->b.rank-a.rank);
        pq.add(new Student(1, "Saurav"));
        pq.add(new Student(4, "Gaurav"));
        pq.add(new Student(3, "Shivam"));
        pq.add(new Student(2, "Harry"));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name +"->"+pq.peek().rank);
            pq.remove();
        }
    }
}
