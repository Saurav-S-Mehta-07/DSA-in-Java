//find all el that appear more than n/3 times.

package Hashing;
import java.util.*;

public class MajorityElement {
    
    public static ArrayList<Integer> findMajority(int nums[], int n){
         HashMap<Integer, Integer> hm = new HashMap<>();
         ArrayList<Integer> result = new ArrayList<>();
         for(int i=0; i<nums.length; i++){
             hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
         }
         
         for(int key: hm.keySet()){
             if(hm.get(key)>n){
                result.add(key);
             }
         }

         return result;
    }
    public static void main(String args[]){
        int nums[] = {1,3,2,5,1,3,1,5,1};
        int n = nums.length;
        ArrayList<Integer> result = findMajority(nums,n/3);
        for(int i = 0; i<result.size(); i++){
            System.out.print(" " + result.get(i));
        }
    }
}
