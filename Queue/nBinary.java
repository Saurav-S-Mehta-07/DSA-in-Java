import java.util.*;
import java.util.LinkedList;
public class nBinary {

    public static void generateBinary(int n){
        Queue<String> q = new LinkedList<>();
        
        q.add("1");

        for(int i = 0; i<n; i++){
            String currBin = q.poll(); //poll-> remove+return
            System.out.print(" " + currBin);

            q.add(currBin+"0");
            q.add(currBin+"1");
        }
        
        
    }
    public static void main(String[] args){
        int n = 5;
        generateBinary(5);
    }
}
