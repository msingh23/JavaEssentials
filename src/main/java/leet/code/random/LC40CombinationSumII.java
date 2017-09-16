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
public class LC40CombinationSumII {

	 List<List<Integer>> out = new ArrayList<List<Integer>>();
	    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        Arrays.sort(candidates);
	        combinationSum2Helper(candidates, 0, 0 ,new ArrayList<Integer>(), target);
	        return out;
	    }
	    
	    public void combinationSum2Helper(int[] candidates, int indx, int currSum, List<Integer> list, int target)
	    {
	        if(currSum == target)
	        {
	            out.add(new ArrayList<Integer>(list));
	            return;
	        }
	        if(currSum>target) return;
	        
	        
	        for(int i = indx; i < candidates.length; i++)
	        {
	            if(i>indx && candidates[i-1]==candidates[i]) continue;
	            list.add(candidates[i]);
	            combinationSum2Helper(candidates,i+1, currSum+candidates[i], list, target);
	            list.remove(list.size()-1);
	        }
	    }
}
