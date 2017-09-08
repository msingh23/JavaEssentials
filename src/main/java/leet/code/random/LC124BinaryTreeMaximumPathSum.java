/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC124BinaryTreeMaximumPathSum {

	  Integer max = Integer.MIN_VALUE;
	    public int maxPathSum(TreeNode root) {
	        maxPathSumHelper(root);
	        return max;
	    }
	    public int maxPathSumHelper(TreeNode root)
	    {
	        if(root==null) return 0;
	        
	        int left = maxPathSumHelper(root.left);
	        int right = maxPathSumHelper(root.right);
	        int childMax = Math.max(left, right);
	        //consider both child and one of the larger childs.
	        max = Math.max(Math.max(childMax+root.val, root.val + left+ right ), max);
	        //if both childs are negative then ignore them
	        if(left <0 && right <0) 
	        {
	            max= Math.max(root.val, max);
	            return root.val;
	        }
	        return childMax + root.val;
	        
	    }
	
}
