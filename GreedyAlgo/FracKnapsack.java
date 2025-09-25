package Java.GreedyAlgo;

import java.util.*;

public class FracKnapsack {

    public static void knapsack(int weight[], int value[], int W){
       
        double ratio[][] = new double[value.length][2];

        //0th col -> idx; 1st col -> ration
        for(int i =  0; i<value.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = (double)value[i]/(double)weight[i];
        }

        Arrays.sort(ratio, (a,b)->Double.compare(b[1], a[1]));

        int capacity = W;
        int finalVal  = 0;
        for(int i = 0; i<ratio.length; i++){
           int idx = (int)ratio[i][0];
           if(capacity>=weight[idx]){//add full
              finalVal += value[idx];
              capacity -= weight[idx];
           }else{
             // add fractional 
             finalVal += (ratio[i][1] * capacity);
             capacity = 0;
             break; 
           }
        }
        System.out.println("final vlaue = "+ finalVal);

    }
    public static void main(String[] args){
        int weight[] = {10,20,30};
        int value[] = {60,100,120};
        int W = 50;

        knapsack(weight, value, W);
    }
}
