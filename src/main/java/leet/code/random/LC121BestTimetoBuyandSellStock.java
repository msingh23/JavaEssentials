/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC121BestTimetoBuyandSellStock {

	  public int maxProfit(int[] prices) {
	        
	        int n = prices.length;
	        
	        int sell = n-1;
	        int buy = n-2;
	        int prof = 0;
	        
	        while(buy>= 0)
	        {
	            if(prices[buy]<prices[sell])
	            {
	                prof = Math.max(prof, prices[sell]-prices[buy]);
	            }
	            else
	            {
	                sell = buy;
	            }
	            buy--;
	        }
	        
	        return prof;
	        
	    }
	
}
