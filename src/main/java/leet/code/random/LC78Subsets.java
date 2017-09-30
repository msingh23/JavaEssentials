/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author manu
 *
 */
public class LC78Subsets {

	 public List<List<Integer>> subsets(int[] nums) {
	        
	        List<List<Integer>> sets = new ArrayList<List<Integer>>();
	        
	        int n = nums.length;
	        
	         subsetsHelper(nums, 0, n, sets);
	            
	        return sets;
	    }
	    
	    public void subsetsHelper(int[] nums, int curr, int end, List<List<Integer>> sets )
	    {
	        if(curr == end)
	        {
	            sets.add(new ArrayList<Integer>());
	            return;
	        }
	        
	        subsetsHelper(nums, curr + 1, end, sets);
	        int n = sets.size();
	        for(int i= 0 ;i < n ;i++)
	        {
	            List<Integer> subSet = sets.get(i);
	            if(subSet.size() > 0)
	            {
	                List<Integer> temp = new ArrayList<Integer>(subSet);
	                temp.add(nums[curr]);
	                sets.add(temp);
	            }
	        }
	        sets.add(new ArrayList<Integer>(Arrays.asList(nums[curr])));
	      
	    }
	
	
}
