package SegmentTrees;

public class SegTree {

    static int st[];

    public static int buildST(int[]arr, int sti, int start, int end){
        if(start==end) return st[sti] = arr[start]; 
        int mid = (start+end)/2;
        buildST(arr, 2*sti+1, start, mid);
        buildST(arr, 2*sti+2, mid+1, end);
        st[sti] =st[2*sti+1]+st[2*sti+2];
        return st[sti];
    }

    public static void createST(int[] arr){
        int n = arr.length;
        st = new int[4*n];
        buildST(arr,0,0,n-1);
        printST(st);
    }

    public static void printST(int[] st){
        for(int i = 0; i<st.length; i++){
            System.out.print(st[i]+ " ");
        }
        System.out.println();
    }

    //query->get subarray sum qi to qj TC: O(log n)
    public static int getSumUtil(int i, int si, int sj, int qi, int qj){
       //case 1: non overlap
       if(qj<si || qi>sj) return 0;
       //case 2: completely overlaping
       else if(si>=qi && sj<=qj) return st[i];
       //case 3: partial overlap
       else{
          int mid = (si+sj)/2;
          int left = getSumUtil( 2*i+1, si, mid, qi, qj);
          int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
          return left+right;
       }
    }


    public static int getSum(int[] arr, int qi, int qj){
           int n = arr.length;
        return getSumUtil(0,0,n-1, qi, qj);
    }


    //update on ST -> TC: O(log n)
    public static void update(int[] arr, int idx, int newVal){
        int oldVal = arr[idx];
        arr[idx] = newVal;
        int diff = newVal-oldVal;
        updateUtil(0,arr.length-1,idx,diff,0);
    }

    public static void updateUtil(int si, int sj, int idx,int diff, int i){
        if(idx<si || sj<idx) return;
        st[i] = st[i]+diff;
        if(si!=sj){
            int mid = (si+sj)/2;
            updateUtil(si, mid, idx, diff,2*i+1);
            updateUtil(mid+1, sj, idx, diff, 2*i+2);
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        createST(arr);
        int qi = 2;
        int qj = 5;
        int sum = getSum(arr, qi, qj);
        System.out.println(sum);
        update(arr, 2, 2);
        printST(st);
        System.out.println(getSum(arr, qi, qj));

    }
}
 