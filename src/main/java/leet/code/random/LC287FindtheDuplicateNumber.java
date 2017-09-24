/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC287FindtheDuplicateNumber {

	
	 public int findDuplicate(int[] nums) {
	        
	        
	        //find the cycle using floyd cycle detection
	        
	        int slow = nums[0];
	        int fast = nums[nums[0]];
	        while(slow!=fast)
	        {
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        }
	        
	        
	        fast = 0;
	        
	        while(slow!=fast)
	        {
	            slow = nums[slow];
	            fast = nums[fast];
	        }
	        
	        return slow;
	    }
}
