/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC95UniqueBinarySearchTreesII {

	
	  public List<TreeNode> generateTrees(int n) {
	        if(0 == n) return new ArrayList<TreeNode>();
	        Map<String, List<TreeNode>> map = new HashMap<>();
	        return generateTrees(map, 1, n);
	    }
	    
	    public List<TreeNode> generateTrees(Map<String, List<TreeNode>> map, int low, int high)
	    {   List<TreeNode> children = new ArrayList<TreeNode>();
	        if(low>high) 
	        {
	            children.add(null);
	            return children;
	        }
	        if(low == high) return Arrays.asList(new TreeNode(low) );
	        String key = "" + low + "." + high;
	        
	        if(!map.containsKey(key))
	        {
	            for(int i = low; i<=high; i++)
	            {
	                List<TreeNode> left = generateTrees(map, low, i-1);
	                List<TreeNode> right = generateTrees(map, i+1, high);
	                for(TreeNode l : left)
	                    for(TreeNode r : right)
	                    {
	                        TreeNode root = new TreeNode(i);
	                        root.left = l;
	                        root.right = r;
	                        children.add(root);
	                    }
	            }
	            map.put(key, children);
	        }
	        return map.get(key);
	    }
	      
}
