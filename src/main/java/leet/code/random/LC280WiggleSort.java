/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC280WiggleSort {

	public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
       if ((i % 2 == 1) && (nums[i-1] > nums[i])) {
           int cache = nums[i];
           nums[i] = nums[i-1];
           nums[i-1] = cache;
       }
        else if ((i % 2 == 0) && (nums[i] > nums[i - 1])) 
        {
            int cache = nums[i];
           nums[i] = nums[i-1];
           nums[i-1] = cache;
        }
   }
   }
}
