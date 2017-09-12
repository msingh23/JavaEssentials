/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC105ConstructBinaryTreefromPreorderandInorderTraversal {

	 public TreeNode buildTree(int[] preorder, int[] inorder) {
	        
	        int n = preorder.length;
	        //if(n==0) return null;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	        int ind =0;
	        for(Integer i : inorder) map.put(i, ind++);
	        
	        return buildTree(preorder, 0, n-1, inorder, 0, n-1, map);
	    }
	    
	    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map)
	    {
	        if(is > ie ) return null;
	        
	            TreeNode root = new TreeNode(preorder[ps]);
	            int split = map.get(preorder[ps]);
	            root.left = buildTree(preorder, ps+1, ps + (split-is), inorder, is, split-1 , map);
	            root.right = buildTree(preorder, ps+ (split-is) +1, pe , inorder, split+1, ie, map );
	            return root;
	        
	    }
	
}
