package Accepted;

public class BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        return maxProfit(prices, 0);
    }
    
    private int maxProfit(int[] prices, int beg) {
        if (beg >= prices.length - 1)
            return 0;
        int min = prices[beg];
        int prev = min;
        for (int i = beg + 1; i < prices.length; i++) {
            if (prices[i] < prev) {
                return (prev - min) + maxProfit(prices, i);
            }
            else {
                prev = prices[i];
            }
        }
        return prev - min;
    }
    
    public static void main(String[] args) {
    	int[] prices = {2,1,4,5,2,9,7};
    	System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(prices));
    }
}
