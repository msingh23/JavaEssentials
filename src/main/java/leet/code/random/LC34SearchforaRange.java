/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC34SearchforaRange {
	 public int[] searchRange(int[] nums, int target) {
	        int l = bsl(nums, target);
	        int r = bsr(nums, target);
	        return new int[]{l,r};
	    }
	    
	    public int bsl(int[] nums, int target)
	    {
	        int start = 0;
	        int end = nums.length-1;
	        while(start<=end)
	        {
	            int mid = start + (end- start) /2 ;
	            if(nums[mid] == target && mid>0 && nums[mid-1] != target) return mid;
	            if(nums[mid] == target && mid ==start) return mid;
	            if(nums[mid]<target)
	                start = mid+1;
	            else 
	                end = mid-1;
	        }
	        return -1;
	    }
	    
	    public int bsr(int [] nums, int target)
	    {
	        int start = 0;
	        int end = nums.length-1;
	        while(start<=end)
	        {
	            int mid = start + (end- start) /2 ;
	            if(nums[mid] == target && mid+1< nums.length && nums[mid+1] != target) return mid;
	             if(nums[mid] == target && mid ==end) return mid;
	            if(nums[mid]>target)
	                 end = mid-1;
	            else 
	                start = mid+1;
	        }
	        return -1;
	    }
}
