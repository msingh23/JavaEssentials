/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC98ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
        
	       return isValidBST(root,Long.MAX_VALUE, Long.MIN_VALUE);
	    }
	    
	    public boolean isValidBST(TreeNode root, long max, long min)
	    {
	        if(root==null) return true;
	        
	        if( (root.val <max && root.val>min) )
	        {
	            return isValidBST(root.left, root.val, min) &&  isValidBST (root.right, max, root.val );          
	        }
	        return false;
	    }
	    
}
