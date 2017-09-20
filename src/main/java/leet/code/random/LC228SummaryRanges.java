/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manu
 *
 */
public class LC228SummaryRanges {

	
	 public List<String> summaryRanges(int[] nums) {
	        
	        List<String> out = new ArrayList<String>();
	        int n = nums.length;
	        long start = Long.MAX_VALUE;
	        long end = Long.MAX_VALUE;
	        if( n == 0) return out;
	        if(n>0) 
	        {
	            start = nums[0];
	            end = nums[0];
	        }
	        
	        for(int i =1 ;i <n ;i ++)
	        {
	            if(nums[i] - end > 1)
	            {
	                StringBuffer buff = new StringBuffer();
	                buff.append(start);
	                if(start!=end)
	                {
	                     buff.append("->");
	                     buff.append(end);
	                    
	                }
	                out.add(buff.toString());
	                start = nums[i];
	                end = nums[i];
	            }
	            else{
	                end++;
	            }
	        }
	        
	        
	        StringBuffer buff = new StringBuffer();
	        buff.append(start);
	        if(start!=end)
	        {
	             buff.append("->");
	             buff.append(end);

	        }
	        out.add(buff.toString());
	        
	        return out;
	    }
}
