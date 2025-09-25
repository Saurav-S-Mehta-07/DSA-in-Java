package Java.HeapDS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthWeak {

    static class Info{
        int soldiers, idx;
        public Info(int soldiers, int idx){
            this.idx = idx;
            this.soldiers = soldiers;
        }
    }

    public static void findWeakestKth(int arr[][], int m, int n, int k){
        PriorityQueue<Info> pq = new PriorityQueue<>(
            (a,b)-> a.soldiers==b.soldiers?a.idx-b.idx: a.soldiers-b.soldiers
        );
        
        for(int i = 0; i<m; i++){
           int count=0;
           for(int j = 0; j<n; j++){
            if(arr[i][j] == 1){
                count++;
            }
           }
           pq.add(new Info(count, i));
        }

        for(int i = 0; i<k; i++){
            System.out.println("R" + pq.poll().idx);
        }
    }

    public static void main(String[] args){
        int arr[][] = {
             {1, 0, 0, 0},
             {1, 1, 1, 1},
             {1, 0, 0, 0},
             {1, 0, 0, 0}
        };

        findWeakestKth(arr, 4, 4, 2);
    }
}
