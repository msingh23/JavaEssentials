/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC156BinaryTreeUpsideDown {

	
	 public TreeNode upsideDownBinaryTree(TreeNode root) {
	     
	        TreeNode temp = root;
	        
	        while(temp!=null && temp.left!=null)
	        {
	            temp = temp.left;
	        }
	        TreeNode newRoot = temp;
	        
	        upsideDownBinaryTreeHelper(root);
	        
	        return newRoot;
	        
	    }
	    
	    public TreeNode upsideDownBinaryTreeHelper(TreeNode root)
	    {
	        if(null == root) return null ;
	        TreeNode left = upsideDownBinaryTreeHelper(root.left);
	        TreeNode right = upsideDownBinaryTreeHelper(root.right);
	        //System.out.println(root.val);
	        if(left!=null)
	        {
	           // System.out.println(left.val + " " + root.val);
	           
	            left.right = root;
	            root.left = null;
	            root.right = null;
	            left.left = right;
	        }
	        
	        return root;
	        
	    }
}
