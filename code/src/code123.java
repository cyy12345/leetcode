public class code123 {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     */
    public int maxProfit(int[] prices) {

        int buyOne = Integer.MAX_VALUE;
        int SellOne = 0;
        int buyTwo = Integer.MAX_VALUE;
        int SellTwo = 0;
        for(int p : prices) {
            buyOne = Math.min(buyOne, p);
            SellOne = Math.max(SellOne, p - buyOne);
            buyTwo = Math.min(buyTwo, p - SellOne);
            SellTwo = Math.max(SellTwo, p - buyTwo);
        }
        return SellTwo;
    }
}
