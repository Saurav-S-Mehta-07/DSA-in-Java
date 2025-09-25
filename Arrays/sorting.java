package Java.Arrays;
// import java.util.Arrays;
// import java.util.Collections;

public class sorting{

    public static void seletionSort(int arr[]){
             for(int i = 0; i<arr.length-1; i++){
                int minPos = i;
                for(int j = i+1; j<arr.length; j++){
                   if(arr[minPos]>arr[j]){
                    minPos = j;
                   }
                }
                int temp = arr[minPos];
                arr[minPos] = arr[i];
                arr[i] = temp;
            }
    }

    public static void bubbleSort(int arr[]){
        for(int i = 0; i<arr.length-1; i++){
            int swap = 0;
            for(int j = 0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    swap++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]  = temp;
                }
            }
            if(swap==0){
               System.out.println("\nI'm out");
                break;
            }
        }
    }

    public static void insertionSort(int arr[]){
       for(int i = 1; i<arr.length; i++){
        int curr = arr[i];
        int prev = i-1;
        while(prev>=0 && arr[prev]<curr){
            arr[prev+1] = arr[prev];
            prev--;
        }
        //insertion
        arr[prev+1] = curr; 
       }
    }
    
    public static void countingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            largest = Math.max(largest,arr[i]);
        }

        int count[] = new int[largest+1];
        for(int i = 0; i<arr.length; i++){
            count[arr[i]]++;
        }

        //sorting
         int j = 0;
        for(int i = 0; i<count.length; i++){
            while(count[i]>0){
               arr[j] = i;
               j++;
               count[i]--;
            }
        }
    }
    
    public static void main(String args[]){

         int arr[] = {5,4,1,1,4,5,3,2};
         countingSort(arr);

    }
}