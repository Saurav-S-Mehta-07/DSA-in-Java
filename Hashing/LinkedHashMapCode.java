package Hashing;
import java.util.*;

public class LinkedHashMapCode {
    
    public static void main(String args[]){
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 300);
        lhm.put("US", 230);

        System.out.println(lhm);
    }
}
