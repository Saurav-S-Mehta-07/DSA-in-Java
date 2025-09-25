package Java.Arrays;

public class diagonalSum {

    // public static void diagonal(int arr[][]){ //O(n^2)
    //     int pd = 0, sd = 0;
    //     int n = arr.length -1;
    //     int i, j;
    //       for(i = 0; i<arr.length; i++){
    //         for(j = 0; j<arr.length; j++){
    //             if(i==j){
    //                      pd+= arr[i][j];
    //             }
    //             else if(i+j==n){
    //                 sd+= arr[i][j];
    //             }
    //         }
    //       }
    //       System.out.println(pd+sd);
    // }
    
    public static void diagonal(int arr[][]){ //O(n)
           int sum = 0;
           int n = arr.length-1;
           for(int i = 0; i<arr.length; i++){
              sum+=arr[i][i];
              if(i!=n-i){
               sum+=arr[i][n-i];
               }
           }

           System.out.println(sum);
    }
    public static void main(String args[]){
    int arr[][] = {
                //  {0,1,2},
                //  {3,4,5},
                //  {6,7,8}

                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                 {13,14,15,16}
             };

        diagonal(arr);

    }
}
