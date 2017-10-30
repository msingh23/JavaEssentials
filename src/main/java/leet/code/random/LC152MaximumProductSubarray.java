/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC152MaximumProductSubarray {

public int maxProduct(int[] nums) {
        
        if(nums.length == 0) return 0;
        int max = nums[0], pos =nums[0] , neg = nums[0];
        for(int i = 1 ;i < nums.length; i++)
        {
           if(nums[i]<0)
           {
               int temp = pos;
               pos = neg;
               neg = temp;
           }
            pos = Math.max(pos * nums[i],nums[i]);
            neg = Math.min(neg * nums[i], nums[i]);
            max = Math.max(max, pos);
        }
        return max;
    }
	
}
