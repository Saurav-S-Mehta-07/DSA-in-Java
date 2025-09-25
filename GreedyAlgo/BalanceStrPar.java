package Java.GreedyAlgo;

public class BalanceStrPar {
   //Maximum Balanced String Partition
    
   public static void findMaxPartition(String str){
     int L = 0, R = 0;
     int partition = 0;
     StringBuffer sb = new StringBuffer("");
     for(int i = 0; i<str.length(); i++){
        if(str.charAt(i)=='L'){
            L++;
            sb.append("L");
        }
        else{
            R++;
            sb.append("R");

        }
        if(L==R){
            partition++;
            System.out.println(sb);
        }
     }

     System.out.println("Total maximum balanced string partition = "+ partition);
   }
   public static void main(String[] args){
    String str = "LRRRRLLRLLRL";
    findMaxPartition(str);
   }

}
