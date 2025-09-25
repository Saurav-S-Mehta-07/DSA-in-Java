package Java.GreedyAlgo;
import java.util.*;

public class IndianCoin {

    public static void minChange(double[] rupees,double val){
      
        Arrays.sort(rupees);
        int change = 0;
        for (int i = rupees.length - 1; i >= 0; i--) {
            while (val >= rupees[i]) {
                System.out.print((int)rupees[i] + ", ");
                val -= rupees[i];
                change++;
            }
        }

        System.out.println();
        System.out.println("Total minimum change = " + change);

    }
    public static void main(String[] args){
        double rupees[] = {1,2,5,10,20,50,100,500,2000};
        double val = 1059;
        minChange(rupees, val); //6
    }
}
