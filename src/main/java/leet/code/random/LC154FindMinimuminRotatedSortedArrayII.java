/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC154FindMinimuminRotatedSortedArrayII {

	/*
	 * with duplicates
	 */
	
	 public int findMin(int[] nums) {
	        
	        int start = 0;
	        int end = nums.length -1;
	        
	        while(start<=end)
	        {
	            if(nums[start] < nums[end]) break;
	           
	            int mid = start + ( end - start ) / 2;
	            
	            if(nums[mid] == nums[end]) end --;
	            
	            else if(nums[mid]> nums[end]) start = mid+1;
	            
	            else end = mid;
	        }
	        
	       return nums[start];
	    }
	
}
