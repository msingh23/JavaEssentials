/**
 * 
 */
package leet.code.random;

import java.util.Stack;

/**
 * @author manu
 *
 */
public class LC98ValidateBinarySearchTree {

	 /*
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
    */
    /*
    public boolean isValidBST(TreeNode root) {
        
      if(root==null) return true;
       return isValidBST(root.left,root, null) && isValidBST(root.right,null, root);
    }
    
    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min)
    {
        if(root==null) return true;
        
        if( (max==null || root.val <max.val) && (min == null || root.val>min.val) )
        {
            return isValidBST(root.left, root, min) &&  isValidBST (root.right, max, root );          
        }
        return false;
    }
    */
    
    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode pre = null;
        
        while(root!=null || !st.isEmpty())
        {
            
            while(root!=null)
            {
                st.add(root);
                root = root.left;
            }
            
            if(!st.isEmpty())
            {
                 root = st.pop();
                 if(pre!=null && pre.val >= root.val) return false;
                 //System.out.println(root.val);
                 pre = root;
                 root = root.right;
            }
           
        }
        
        return true;
       
    }
	    
	    
}
