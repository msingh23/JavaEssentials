/**
 * 
 */
package leet.code.random;

import java.util.PriorityQueue;

/**
 * @author manu
 *
 */
public class KthLargestElementinanArray215 {

	 public int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> maxH = new PriorityQueue<Integer>((a,b)->b-a);
	        for(int i = 0 ; i<nums.length; i++){
	            maxH.add(nums[i]);
	        }
	        
	        int kthLargest = -1;
	        while(k>0){
	            kthLargest = maxH.poll();
	            k--;
	        }
	        return kthLargest;
	    }
	
}
