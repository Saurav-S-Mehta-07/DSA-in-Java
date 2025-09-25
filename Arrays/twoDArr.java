package Java.Arrays;
import java.util.*;
public class twoDArr {
    
    public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int arr[][] = new int[3][3];
      int r, c;
      r = arr.length;
      c = arr[0].length;
      System.out.println("enter array elements: ");
      for(int i = 0; i<r; i++){
        for(int j = 0; j<c; j++){
            arr[i][j] = sc.nextInt();
        }
      }
      System.out.println();
      for(int i = 0; i<r; i++){
        for(int j =0; j<c; j++){
            System.out.print(" "+ arr[i][j]);
        }
        System.out.println();
      }
    }

}
