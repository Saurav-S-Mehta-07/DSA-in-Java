package Hashing;

import java.util.*;

public class HashSetCode{
    
    public static void main(String args[]){

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(null);
        set.add(2);
        set.add(4);

        System.out.println(set);
        System.out.println(set.contains(2));
        System.out.println(set.contains(43));
        System.out.println(set.size());
        set.remove(2);
        System.out.println(set);
    }
}