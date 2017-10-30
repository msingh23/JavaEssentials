/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC540SingleElementinaSortedArray {
	 public int singleNonDuplicate(int[] nums) {
	      
	      // 0 1 2
	      //   | 
	      // 0 1 2 3
	          
	        int start = 0;
	        int end = nums.length-1;
	        while(start<=end)
	        {
	            
	            int mid = start + (end-start)/2;
	            //split start to mid
	            int first = mid-start+1;
	            //split mid+1 to end
	            int second = end - mid;
	            
	            if(mid > 0 && nums[mid]==nums[mid-1])
	            {
	                if(first%2==0)
	                {
	                    start = mid+1;
	                }
	                else
	                {
	                    end = mid-2;
	                }
	            }else if(mid<end && nums[mid]==nums[mid+1])
	            {
	                if((second+1)%2==0)
	                {
	                     end = mid-1;
	                }
	                else
	                {
	                    start = mid+2;
	                }
	            }else return nums[mid];
	        }
	        return nums[start];
	    }
	
	
}
