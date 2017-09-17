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
public class LC15ThreeSum {

	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> out = new ArrayList<List<Integer>>();
	        
	        Arrays.sort(nums);
	        
	        for(int i =0 ;i < nums.length-2; i++)
	        {
	            //List<Integer> pair = new ArrayList<Integer>();
	            if(i>0 && nums[i]==nums[i-1]) continue;
	            //pair.add(nums.add(nums[i]));
	            int one = nums[i];
	            int start = i+1;
	            int end = nums.length-1;
	            
	            while(start<end)
	            {
	                if(one + nums[start] + nums[end] == 0)
	                {
	                    List<Integer> trip = new ArrayList<Integer>();
	                    trip.add(one);
	                    trip.add(nums[start]);
	                    trip.add(nums[end]);
	                    out.add(trip);
	                    start++;
	                    end--;
	                    while(start<end && nums[start] == nums[start-1]) start++;
	                    while(start<end && nums[end] == nums[end+1]) end--;
	                  
	                }else
	                {
	                    if(nums[start] + nums[end] + one > 0) end--;
	                    else start++;
	                }
	                
	            }
	            
	        }

	        return out;
	    }
}


