public class code122 {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     */
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int max = 0;
        int valley = prices[0];
        int peak = prices[0];
        int i=0;
        while(i < prices.length-1){
            while(i<prices.length-1 && prices[i]>=prices[i+1])
                i++;
            valley = prices[i];
            while(i<prices.length-1 && prices[i]<=prices[i+1])
                i++;
            peak = prices[i];
            max += peak- valley;
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int max = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                max += prices[i+1]-prices[i];
            }
        }
        return max;
    }
}
