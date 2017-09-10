/**
 * 
 */
package leet.code.random;

import java.util.Arrays;

/**
 * @author manu
 *
 */
public class LC188BestTimetoBuyandSellStockIV {

	public int maxProfit(int k, int[] prices) {
		if (k == 0 || prices.length == 0)
			return 0;

		if (k >= prices.length / 2) {
			return quickSolve(prices);
		}

		int[] b1 = new int[k + 1];
		Arrays.fill(b1, Integer.MIN_VALUE);
		// b1[1] = Integer.MIN_VALUE;
		int[] p1 = new int[k + 1];
		Arrays.fill(p1, 0);

		for (int i = 0; i < prices.length; i++) {
			for (int j = 1; j <= k; j++) {
				b1[j] = Math.max(b1[j], p1[j - 1] - prices[i]);
				p1[j] = Math.max(p1[j], prices[i] + b1[j]);

			}
		}
		return p1[k];

	}

	private int quickSolve(int[] prices) {
		int len = prices.length, profit = 0;
		for (int i = 1; i < len; i++)
			// as long as there is a price gap, we gain a profit.
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		return profit;
	}

}
