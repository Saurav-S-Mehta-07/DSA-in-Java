public class inversion {

    public static int merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid;
        int k = 0;
        int invCount = 0;

        while(i<mid && j<=ei){
            if(arr[i]<=arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            }else{
                temp[k] = arr[j];
                //mid-i because if a element is greate than remaining all el in the subarray also greater
                invCount+=(mid-i);
                k++;
                j++;
            }
        }

        while(i<mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }

        for(i=si,k=0;i<=ei;i++,k++){
            arr[i] =temp[k];
        }

        return invCount;
    }

    public static int mergeSort(int arr[], int si, int ei){

        int invCount=0;
       
        if(ei>si){
        //work
        int mid = si + (ei-si)/2;
        //left
        invCount = mergeSort(arr, si, mid);
        //right
        invCount += mergeSort(arr, mid+1, ei);

        //merge
       invCount += merge(arr, si, mid+1, ei);
        }
       return invCount;
    }
    public static void main(String args[]){
          int arr[] = {5,4,3,2,1};
          System.out.println(mergeSort(arr, 0, arr.length-1));
    }
}
