/**
 * 
 */
package leet.code.random;

import java.util.TreeSet;

/**
 * @author manu
 *
 */
public class LC220ContainsDuplicateIII {
	 public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

	        /*
	        for(int i = 0 ;i < nums.length; i++)
	        {
	            for(int j = i+1; j-i<=k && j<nums.length; j++ )
	            {
	                if(Math.abs((long)nums[i]-(long)nums[j])<=t) return true;
	            }
	        }
	        return false;
	    }
	    
	*/
	        
	        TreeSet<Long> set = new TreeSet<Long>();
	        for(int i = 0 ;i < nums.length; i++)
	        {
	            Long max = set.floor((long)nums[i]+t);
	            Long min = set.ceiling((long)nums[i]-t);
	            
	            if( (max!=null && nums[i]<=max)  || (min!=null && min<=nums[i])  )
	                return true;
	            
	            set.add((long)nums[i]);
	            if(set.size() > k)
	            {
	                set.remove((long)nums[i-k]);
	            }
	        }
	        
	        return false;
	    }
}
