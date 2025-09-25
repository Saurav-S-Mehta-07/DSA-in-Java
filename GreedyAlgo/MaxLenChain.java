package Java.GreedyAlgo;
import java.util.Arrays;
public class MaxLenChain {

    public static void maxLength(int arr[][]){

        Arrays.sort(arr,(a,b)->Double.compare(a[1], b[1]));

        int pair = 1;
        int b = arr[0][1];

        System.out.print("(" + arr[0][0] +","+ b +  ")"+"->");

        for(int i = 1; i<arr.length; i++){
             int c = arr[i][0];
             if(b<c){
                System.out.print("(" + arr[i][0] +","+ arr[i][1] +  ")"+"->");
                pair++;
                b = arr[i][1];
             }
        }
        System.out.println();
         System.out.println(pair);
        
    }
    public static void main(String[] args){
        int arr[][] = {
            {5,90},
            {39,60},
            {5,28},
            {27,40},
            {50,90}
        };

        maxLength(arr);
    }
}
