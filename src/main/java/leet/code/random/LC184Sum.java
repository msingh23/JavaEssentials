/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author manu
 *
 */
public class LC184Sum {

public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n-3; i++)
        {
            if(i>0 && nums[i-1] == nums[i]) continue;
            for(int j = i+1; j <n-2; j++)
            {
                if(j>i+1 && nums[j-1] == nums[j]) continue;
                int p = j+1;
                int q = n-1;
            
                int sum = target - nums[i] - nums[j];
               //System.out.println(sum);
                while(p<q)
                {
                    int total = nums[p] + nums[q];
                   // System.out.println(total + " " + sum);
                    if(total == sum) 
                    {
                        out.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        while(p+1<q && nums[p] == nums[p+1]) p++;
                        while(p<q-1 && nums[q-1] == nums[q]) q--;
                        p++;
                        q--;
                    }else if(total<sum) p++;
                    else q--;
                }
            }
                
        }
        return out;
    }
	
}
