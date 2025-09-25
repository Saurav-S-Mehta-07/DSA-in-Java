package Java.GreedyAlgo;

public class PriceSell {
    
    //best time to buy and sell stocks

    public static void findProfit(int prices[]){
        int buy = prices[0];
        int profit = 0;

        for(int i = 1; i<prices.length; i++){
            if(prices[i]>buy){
                profit = Math.max(profit, prices[i]-buy);
            }
            else{
                buy = prices[i];
            }
        }

        System.out.println("maximum profit = "+ profit);
    }

    public static void main(String[] args){
        int prices[] = {7,1,5,3,6,4};

        findProfit(prices);
    }
}
