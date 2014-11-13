package Accepted;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else if (prices[i] - min > result)
                result = prices[i] - min;
        }
        return result;
    }
}
