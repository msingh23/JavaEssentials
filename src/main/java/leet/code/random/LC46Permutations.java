/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author manu
 *
 */
public class LC46Permutations {

	 public List<List<Integer>> permute(int[] nums) {
	        
	        List<List<Integer>> list = new LinkedList<List<Integer>>();
	        int n = nums.length;
	        if(n==0) return list;
	        list.add(Arrays.asList(nums[n-1]));
	        
	        
	        for(int i = n-2 ;i >=0 ; i--)
	        {
	           int no = nums[i];
	           List<List<Integer>> _list = new LinkedList<List<Integer>>();
	           for(List<Integer> perm : list)
	           {
	               for(int j = 0 ;j <= perm.size(); j++)
	               {
	                   List<Integer> _perm = new ArrayList<Integer>(perm);
	                   _perm.add(j, no);
	                   _list.add(_perm);
	               }
	           }
	            list = _list;            
	        }
	        return list;
	    }
}
