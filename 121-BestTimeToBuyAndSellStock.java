// 121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
       int minimum = prices[0];
       int maximum = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minimum)
                minimum = prices[i];
            else {
            maximum = Math.max(maximum, prices[i] - minimum);
                }        
        }
        return maximum;
    }
}