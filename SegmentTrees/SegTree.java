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

    public static void createST(int[] arr){
        int n = arr.length;
        int[] st = new int[4*n];
        buildST(arr,st,0,0,n-1);
        System.out.println(st[0]);
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        createST(arr);
    }
}
 