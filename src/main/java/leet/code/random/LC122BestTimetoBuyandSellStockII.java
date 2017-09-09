/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC122BestTimetoBuyandSellStockII {

	public int maxProfit(int[] prices) {

		// [6,1,3,2,4,7]

		// [2,1,4]
		/*
		 * sell: 2 buy: 1 prevBuy: 2 prof: 0 max: 0
		 */
		int n = prices.length;
		if (n < 1)
			return 0;
		int sell = n - 1;
		int buy = n - 2;
		int prevBuy = n - 1;
		int prof = 0;
		int max = 0;

		while (buy >= 0) {
			if (prices[buy] < prices[sell] && prices[buy] < prices[prevBuy]) {
				max = Math.max(prices[sell] - prices[buy], max);
			} else {
				prof += max;
				max = 0;
				sell = buy;
			}
			prevBuy = buy;
			buy--;
		}
		if (max > 0) {
			prof += max;
		}
		return prof;
	}

}
