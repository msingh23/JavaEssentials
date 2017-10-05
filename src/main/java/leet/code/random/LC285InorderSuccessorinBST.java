/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC285InorderSuccessorinBST {
	
	 public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        
	        TreeNode succ = null;
	        if(root.val>p.val)
	            succ = root;
	       
	        return inorderSuccessorHelper(root,p, succ);
	    }
	    
	    public TreeNode inorderSuccessorHelper(TreeNode root, TreeNode p, TreeNode succ)
	    {
	        if(root == null || p == null) return null;
	        if(root.val == p.val)
	        {
	         TreeNode next = left(root.right);
	         if(next == null)
	            return succ;
	         else return next;
	        }
	        
	        if(root.val > p.val)
	        {
	            return inorderSuccessorHelper(root.left, p, root);
	        }
	        else{
	            return inorderSuccessorHelper(root.right, p, succ);
	        }
	            
	    }
	    
	    public TreeNode left(TreeNode root)
	    {
	        if(root == null) return null;
	        if(root.left!=null)
	            return left(root.left);
	        else return root;
	        
	    }

}
