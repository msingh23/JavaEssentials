/**
 * 
 */
package leet.code.random;

import java.util.PriorityQueue;

/**
 * @author manu
 *
 */
public class LC123BestTimetoBuyandSellStockIII {

	public int maxProfit(int[] prices) {
		 int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
	        int prof1 = 0, prof2 =0;
	        
	        for(int i : prices)
	        {
	            buy1 = Math.max(buy1, -i);
	            prof1 = Math.max(prof1, i + buy1);
	            buy2 = Math.max(buy2, prof1 - i);
	            prof2 = Math.max(prof2, i + buy2);
	        }
	        return prof2;
	}
}
