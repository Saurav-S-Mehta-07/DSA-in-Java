package Java.Arrays;

public class buyStock {

// public static int butSellStock(int prices[]){
//         int buyPrice = prices[0];
//         int profit = 0;
//         for(int i = 1; i<prices.length;i++){
//             if(buyPrice<prices[i]){
//                profit = Math.max(profit, prices[i]-buyPrice);
//              }else{
//                 buyPrice = prices[i];
//             }
//         }
//         return profit;
//     }

    public static int buyAndSellStock(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i<prices.length; i++){
            if(buyPrice< prices[i]){//profit
                  int profit = prices[i]-buyPrice;//today's profit
                  maxProfit = Math.max(maxProfit,profit);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String args[]){
        int prices[] = {7,1,5,3,6,4};

        System.out.println(buyAndSellStock(prices));


    }
}
