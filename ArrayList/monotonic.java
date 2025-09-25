package Java.ArrayList;
import java.util.ArrayList;
public class monotonic {

    public static boolean isMonotonic(ArrayList<Integer> list){


        boolean inc = true;
        boolean dec = true;

        for(int i = 0; i<list.size()-1; i++){
            if(list.get(i)>list.get(i+1)){
                inc = false;
            }

            if(list.get(i)<list.get(i+1)){
                dec = false;
            }
        }
        

        return inc||dec;
    }


    public static void main(String[] args){
       ArrayList<Integer> list = new ArrayList<>();
       list.add(10);
       list.add(20);
       list.add(30);
       list.add(40);
       list.add(40);
       list.add(50);
   
       System.out.println(isMonotonic(list));
    }
}

