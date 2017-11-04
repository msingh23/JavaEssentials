/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manu
 *
 */
public class LC229MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
        List<Integer> out = new ArrayList<Integer>();
        if(nums.length ==0 ) return out;
        int c1=0, c2=0, c3=0 ,v1=nums[0], v2=nums[0] ,v3=nums[0];
        
        for(int n : nums)
        {
         
            if(v1 == n) c1++;
            else if(v2 == n) c2++;
            else if(v3 == n) c3++;
           
            if(c1==0)
            {
                c1++;
                v1=n;
            }
           
            else if(c2==0)
            {
                c2++;
                v2=n;
            }
            
            else if(c3==0)
            {
                c3++;
                v3=n;
            }
            else
            {
                c1--;c2--;c3--;
            }
            
            
        }
        
        int len = nums.length;
        c1=0;c2=0;c3=0;
        for(int n : nums)
        {
            if(n==v1) c1++;
            else if(n==v2) c2++;
            else if(n==v3) c3++;
        }
        
        
        if(c1 > len/3) out.add(v1);
        if(c2 > len/3) out.add(v2);
        if(c3 > len/3) out.add(v3);
        return out;
    }
}
