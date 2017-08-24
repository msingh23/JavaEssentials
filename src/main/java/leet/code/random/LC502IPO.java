/**
 * 
 */
package leet.code.random;

import java.util.PriorityQueue;

/**
 * @author manu
 *
 */
public class LC502IPO {
	  /*
    Brute Force
 
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
	        return findMaximizedCapitalHelper(k, W, Profits, Capital, 0);
	        
	    }
	    
	     private int findMaximizedCapitalHelper(int k, int W, int[] Profits, int[] Capital, int index)
	    {
	        
	        if(k==0 || index ==Profits.length)
	        {
	            return W;
	        }
	        
	        int max = 0 ; 
	        for(int i = index ; i < Profits.length; i++)
	        {
	        	int profitNext=W;
	            if(W>=Capital[i])
	            {
	            	if(index+1<=Profits.length){
	            		profitNext = findMaximizedCapitalHelper(k-1, W+Profits[i], Profits, Capital, index+1 );
	            	}
	            }
	            if(max<profitNext)
	            {
	            	max = profitNext;
	            }
	        }
	        
	        return max;
	    }
	   */
    
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
	       PriorityQueue<int[]> pCap = new PriorityQueue<int[]>((a,b)-> a[0]-b[0]);
           PriorityQueue<int[]> pProf = new PriorityQueue<int[]>((a,b)-> b[1]-a[1]);
        for(int i =0 ; i < Capital.length; i++)
        {
            pCap.add(new int[] {Capital[i],Profits[i]});
        }
        for(int i = 0 ; i < k ; i++){
            while(!pCap.isEmpty() && W>=pCap.peek()[0])
            {
                pProf.add(pCap.poll());
            }
            if(!pProf.isEmpty())
            {
                 W+=pProf.poll()[1];
            }
           
        }
	        
        return W;
	    }
}
