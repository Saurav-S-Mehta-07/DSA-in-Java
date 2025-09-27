package Hashing;
import java.util.*;
public class UnionIntersection {

    public static void union(int arr1[], int arr2[]){
          HashSet<Integer> set = new HashSet<>();
          for(int i =0; i<arr1.length; i++){
            set.add(arr1[i]);
          }
          for(int i = 0; i<arr2.length; i++){
            set.add(arr2[i]);
          }

          System.out.println("Union = " + set);
    }

    public static void intersection(int arr1[], int arr2[]){
        
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        System.out.print("\nIntersection: ");
        for(int j = 0; j<arr2.length; j++){
            if(set.contains(arr2[j])){
                System.out.print(arr2[j]+" ");
                set.remove(arr2[j]);
            }
        }
        System.out.print("\n"); 
    }

    public static void main(String args[]){
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        union(arr1, arr2);
        intersection(arr1,arr2);
    }
}
