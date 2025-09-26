package Hashing;
import java.util.*;

import javax.print.DocFlavor.STRING;
public class iteration {
    public static void main(String []args){

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India",100);
        hm.put("China", 150);
        hm.put("US",50);

        //iteration on hasmap
        
        Set<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.print("key = " + key + " value = " + hm.get(key) + " ");
        }

        System.out.println("\n"+hm.entrySet());

        
    }
}
