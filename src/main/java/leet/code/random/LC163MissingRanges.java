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
public class LC163MissingRanges {

public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        List<String> out = new ArrayList<String>();
        long low = lower;
        long up = upper;
        //if(0 == n) return out;
        int i =0;
        //while(n > 0 && nums[i]<low) i++;
        while(n > 0 && i<n)
        {
            
           if(nums[i]>low && low<up)
           {
               StringBuffer buff = new StringBuffer("");
               buff.append(low);
               if(nums[i]-low>1)
               {
                 buff.append("->");
                 buff.append(nums[i]-1);    
               }
              
               out.add(buff.toString());
               low = nums[i];
           }
            else if(nums[i] == low)
            {
                low++; i++;
            }
            else if(nums[i]<low) i++;
        }
        if(low<=up )
        {
            StringBuffer buff = new StringBuffer("");
            buff.append(low);
            if(up-low>0)
            {
                buff.append("->");
                buff.append(upper);
            }
            
            out.add(buff.toString());
        }
        
        return out;
    }
}
