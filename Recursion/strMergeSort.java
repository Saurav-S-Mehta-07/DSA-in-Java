public class strMergeSort {

    public static void printArr(String arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void mergeSortStr(String arr[], int si, int ei){
        //base case
          if(si>=ei){
            return;
          }

          //work
          int mid = si + (ei-si)/2;
          //left
          mergeSortStr(arr, si, mid);
          mergeSortStr(arr, mid+1, ei);
          merge(arr, si,mid, ei);

    }

    public static void merge(String arr[], int si, int mid, int ei){
        String temp[] = new String[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=ei){
            if(arr[i].compareTo(arr[j])<0){
                 temp[k] = arr[i];
                 i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //remaining left
        while(i<=mid){
            temp[k++] = arr[i++];
        }

        //remaining right
        while(j<=ei){
            temp[k++] = arr[j++];
        }


        //copy temp to arr;
        for(k = 0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args){
        
        // String arr[] = {"sun","earth", "mars", "mercury"};
        String arr[] = {"a","z","b","c","a"};
        printArr(arr);
        mergeSortStr(arr, 0, arr.length-1);
        printArr(arr);

    }
}
