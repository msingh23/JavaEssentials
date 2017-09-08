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
	        
	        int left = Math.max(maxPathSumHelper(root.left),0);
	        int right = Math.max(maxPathSumHelper(root.right),0);
	        int childMax = Math.max(left, right);
	        max = Math.max( root.val+left+right, max);
	        return childMax + root.val;
	        
	    }
	
}
