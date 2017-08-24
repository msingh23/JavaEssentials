/**
 * 
 */
package leet.code.random;

import java.util.Arrays;

/**
 * @author manu
 *
 */
public class LC628MaximumProductofThreeNumbers {

    /*
    nlogn , nlogn
    public int maximumProduct(int[] nums) {
        
        int out = 1;
        int max = 1;
        int neg=0;
        int n = nums.length;
        if(n<3) return -1;
        Arrays.sort(nums);
        
        
        out*=nums[n-1];
        
        int last = nums[0]*nums[1];
        int first = nums[n-2]*nums[n-3];
        if(last>first){
            out*=last; 
        }else{
             out*=first;
        }
        return out;
        
    }
    */
    public int maximumProduct(int[] nums)
    {
        int min1= Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        
        for(int i = 0 ; i<nums.length; i++)
        {
            if(nums[i]<min1)
            {
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i]<min2){
                min2 = nums[i];
            }
            if(nums[i]>max)
            {
                max2 = max1;
                max1 = max;
                max = nums[i];
            }else if(nums[i]>max1){
                max2=max1;
                max1= nums[i];
            }else if(nums[i]>max2){
                max2= nums[i];
            }
        }
        
        return Math.max( (max * max1 * max2), (max * min1 * min2)); 
    }

}
