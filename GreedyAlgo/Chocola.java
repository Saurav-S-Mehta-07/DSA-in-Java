
package Java.GreedyAlgo;
import java.util.*;
import java.util.Collections;
public class Chocola {

    public static void findMinCost(Integer verCut[], Integer horCut[]){
        Arrays.sort(verCut,Collections.reverseOrder());
        Arrays.sort(horCut, Collections.reverseOrder());
        int cost = 0, i = 0, j = 0;
        while(i<verCut.length && j<horCut.length){
            if(verCut[i]>=horCut[j]){
                cost += verCut[i]*(j+1);
                i++;
            }else{
               cost += horCut[j] * (i+1);
               j++;
            }
        }
        while(i<verCut.length){
               cost+= verCut[i]*(j+1);
               i++;
        }
        while(j<horCut.length){
            cost+= horCut[j] * (i+1);
            j++;
        }
        
        System.out.println(cost);
    }
    
    public static void main(String[] args){
        Integer verCut[] = {2,1,3,1,4};
        Integer horCut[] ={4,1,2};

        findMinCost(verCut, horCut); //42
    }

}
