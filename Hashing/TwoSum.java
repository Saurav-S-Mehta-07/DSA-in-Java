package Hashing;
import java.util.*;
public class TwoSum {
    
    public static void main(String args[]){
        int arr[] = {3,2,4};

        int target = 6;
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< arr.length; i++){
           int k = target-arr[i];
           if(map.containsKey(k)){
             System.out.println(map.get(k) +  " " + i);
             return;
           }
           map.put(arr[i], i);
        }
    }
}
