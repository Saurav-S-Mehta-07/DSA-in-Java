package SegmentTrees;
//max/min element queries
public class MaxMinElQueries {

    public static class Info{
        int mx,mn;
        public Info(int mx, int mn){
            this.mx = mx;
            this.mn = mn;
        }
    }

    static Info st[];
    public static void createST(int[] arr){
        int n = arr.length;
        st = new Info[2*n-1];
        buildST(arr,0,n-1,0);
    }

    public static Info buildST(int[] arr,int si, int ei, int i){
        if(si==ei){
            int mx = arr[si];
            int mn = arr[si];
            st[i] = new Info(mx, mn);
            return st[i];
        }
        int mid = (si+ei)/2;
        Info l = buildST(arr, si, mid, 2*i+1);
        Info r = buildST(arr, mid+1, ei, 2*i+2);

        int mx = Math.max(r.mx,l.mx);
        int mn = Math.min(r.mn,l.mn);
        st[i] = new Info(mx, mn);
        return st[i];
    }

    public static void printST(Info[]st){
        for(Info i : st){
            System.out.print(i.mx + " ");
        }
        System.out.println();
        for(Info i: st){
            System.out.print(i.mn + " ");
        }
        System.out.println();
    }

    public static void update(int[] arr, int idx, int newVal){
        arr[idx] = newVal;
        updateUtil(arr, idx, newVal, 0, arr.length-1, 0);
    }

    public static void updateUtil(int[] arr, int idx, int Val, int si, int sj,int i){
      if(idx<si || idx>sj) return;

      if(si!=sj){
        int mid = (si+sj)/2;
        updateUtil(arr, idx, Val, si, mid, 2*i+1);
        updateUtil(arr, idx, Val, mid+1, sj, 2*i+2);
        int lmax = st[2*i+1].mx;
        int lmin = st[2*i+1].mn;
        int rmax = st[2*i+2].mx;
        int rmin = st[2*i+2].mn;
        st[i].mx = Math.max(lmax,rmax);
        st[i].mn = Math.min(lmin, rmin);
      }
      else if(si==sj && idx>=si && idx<=sj){
         st[i].mx = Val;
         st[i].mn = Val;
      }
    }

    public static int getMax(int arr[],int qi, int qj){
        int n = arr.length;
        return getMaxUtil(0, qi, qj, 0, n-1);
    }
    public static int getMaxUtil(int i, int qi, int qj, int si, int sj){
        //non overlap
        if(sj<qi || si>qj){
            return Integer.MIN_VALUE;
        }

        //completely overlap
        else if(si>=qi && sj<=qj){
            return st[i].mx;
        }

        //partial overlap
        else{
            int mid = (si+sj)/2;
            int lmax = getMaxUtil(2*i+1, qi, qj, si, mid);
            int rmax = getMaxUtil(2*i+2, qi, qj, mid+1, sj);
            return Math.max(lmax, rmax);
        }

    }

    public static int getMin(int arr[],int qi, int qj){
        int n = arr.length;
        return getMinUtil(0, qi, qj, 0, n-1);
    }
    public static int getMinUtil(int i, int qi, int qj, int si, int sj){
        //non overlap
        if(sj<qi || si>qj){
            return Integer.MAX_VALUE;
        }

        //completely overlap
        else if(si>=qi && sj<=qj){
            return st[i].mn;
        }

        //partial overlap
        else{
            int mid = (si+sj)/2;
            int lmin = getMinUtil(2*i+1, qi, qj, si, mid);
            int rmin = getMinUtil(2*i+2, qi, qj, mid+1, sj);
            return Math.min(lmin,rmin);
        }

    }

    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        createST(arr);
        printST(st);

        System.out.println("max in 5-8: "+getMax(arr, 5, 8)); //4
        System.out.println("min in 5-8: "+getMin(arr, 5, 8)); //1


        update(arr,2,9);
        printST(st);
    }
}
