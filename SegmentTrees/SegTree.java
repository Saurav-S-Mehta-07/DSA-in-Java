package SegmentTrees;

public class SegTree {

    public static int buildST(int[]arr,int[]st, int sti, int start, int end){
        if(start==end) return st[sti] = arr[start]; 
        int mid = (start+end)/2;
        buildST(arr,st, 2*sti+1, start, mid);
        buildST(arr,st, 2*sti+2, mid+1, end);
        st[sti] =st[2*sti+1]+st[2*sti+2];
        return st[sti];
    }

    public static int[] createST(int[] arr){
        int n = arr.length;
        int[] st = new int[4*n];
        buildST(arr,st,0,0,n-1);
        printST(st);
        return st;
    }

    public static void printST(int[] st){
        for(int i = 0; i<st.length; i++){
            System.out.print(st[i]+ " ");
        }
        System.out.println();
    }

    public static int getSumUtil(int[] st, int i, int si, int sj, int qi, int qj){
       //case 1: non overlap
       if(qj<=si || qi>=sj) return 0;
       //case 2: completely overlaping
       else if(si>=qi && sj<=qj) return st[i];
       //case 3: partial overlap
       else{
          int mid = (si+sj)/2;
          int left = getSumUtil(st, 2*i+1, si, mid, qi, qj);
          int right = getSumUtil(st, 2*i+2, mid+1, sj, qi, qj);
          return left+right;
       }
    }


    public static int getSum(int[] arr,int[] st, int qi, int qj){
           int n = arr.length;
        return getSumUtil(st, 0,0,n-1, qi, qj);
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int st[] = createST(arr);
        int qi = 1;
        int qj = 3;
        int sum = getSum(arr,st, qi, qj);
        System.out.println(sum);
    }
}
 