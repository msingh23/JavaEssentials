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
        PriorityQueue<Integer> maxH = new PriorityQueue<Integer>((a,b)->a-b);
        for(int i = 0 ; i<nums.length; i++){
            maxH.add(nums[i]);
            if(maxH.size()>k){
                maxH.poll();
            }
        }
        return maxH.peek();
    }
	
}
