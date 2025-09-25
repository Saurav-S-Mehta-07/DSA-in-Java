package Java.ArrayList;

import java.util.ArrayList;

public class pairSum {
    public static boolean pairSum1(ArrayList<Integer> list, int target){
        int lp = 0;
        int rp = list.size()-1;

        while(lp<rp){
            if(list.get(lp)+list.get(rp) == target){
                return true;
            }
            else if(list.get(lp)+list.get(rp) <target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target){
        int bp = -1;
        int n = list.size();
        for(int i = 0; i<list.size(); i++){
            if(list.get(i)>list.get(i+1)){
                bp = i;
                break;
            }
        }
        int lp = bp+1;
        int rp = bp;
        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            else if(list.get(lp)+list.get(rp)<target){
                lp = (lp+1)%n;
            }else{
                rp = (n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(8);
        list.add(9);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(pairSum2(list, 10));


    }
}
