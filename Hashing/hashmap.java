package Hashing;
import java.util.*;
public class hashmap {
    public static void main(String args[]){
        //Create
        HashMap<String, Integer> hm = new HashMap<>();

        //insert O(1)
        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);

        System.out.println(hm);

        //get - O(1)
        System.out.println(hm.get("sdas'"));
        int population = hm.get("India");
        System.out.println(population);

        //containKey - O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Nepal"));

        //remove - O(1)
        System.out.println(hm.remove("India"));
        System.out.println(hm);
        System.out.println(hm.remove("Nepal"));
        System.out.println(hm);


        //other operation
        System.out.println(hm.keySet()); //set of keys
        System.out.println(hm.values()); //set of values
        System.out.println(hm.size()); //size of hashMap
        System.out.println(hm.isEmpty()); //return true/false

    }
}
