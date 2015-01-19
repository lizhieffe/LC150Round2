package Accepted;

public class BestTimeToBuyAndSellStockIII {

	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int[] soldBeforeDate = new int[prices.length];
        int[] buyAfterDate = new int[prices.length];
        calculateSoldBeforeDate(prices, soldBeforeDate);
        calculateBuyAfterDate(prices, buyAfterDate);
        int result = 0;
        for (int i = 1; i < prices.length - 1; ++i) {
            if (soldBeforeDate[i] + buyAfterDate[i + 1] > result)
                result = soldBeforeDate[i] + buyAfterDate[i + 1];
        }
        result = Math.max(result, soldBeforeDate[prices.length - 1]);
        return result;
    }
    
    private void calculateSoldBeforeDate(int[] prices, int[] soldBeforeDate) {
        int min = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (i == 0) {
                soldBeforeDate[i] = 0;
                min = prices[i];
            }
            else {
                if (prices[i] < min)
                    min = prices[i];
                if (prices[i] - min > maxProfit)
                    maxProfit = prices[i] - min;
                soldBeforeDate[i] = maxProfit; 
            }
        }
    }
    
    private void calculateBuyAfterDate(int[] prices, int[] buyAfterDate) {
        int max = 0;
        int maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; --i) {
            if (i == prices.length - 1) {
                buyAfterDate[i] = 0;
                max = prices[i];
            }
            else {
                if (prices[i] > max)
                    max = prices[i];
                if (max - prices[i] > maxProfit)
                    maxProfit = max - prices[i];
                buyAfterDate[i] = maxProfit; 
            }
        }
    }
}
