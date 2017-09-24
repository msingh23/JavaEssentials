/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manu
 *
 */
public class LC545BoundaryofBinaryTree {

	
	  List<Integer> out = new ArrayList<Integer>(); 
	    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	    
	      if(root!=null)
	      {
	          out.add(root.val);
	          addLeft(root.left, out);
	          addLeaf(root.left, out);
	          addLeaf(root.right, out);
	          addRight(root.right, out);
	      }
	        return out;
	    }
	    
	   
	    public void addLeft(TreeNode root, List<Integer> out)
	    {
	        if(root == null ) return;
	        if(root.left == null && root.right == null) return;
	        out.add(root.val);
	        if(root.left ==null)
	             addLeft(root.right, out);
	        else 
	             addLeft(root.left, out);
	    }
	    
	    public void addLeaf(TreeNode root, List<Integer> out)
	    {
	        if(root == null) return;
	        if(root.left == null && root.right == null)
	        {
	            out.add(root.val);
	            return;
	        }
	        
	        addLeaf(root.left, out);
	        addLeaf(root.right, out);
	    }
	     public void addRight(TreeNode root, List<Integer> out)
	     {
	         if(root == null || (root.left == null && root.right == null) ) return ;
	         
	         if(root.right==null)
	             addRight(root.left, out);
	         
	         addRight(root.right, out);
	         out.add(root.val);
	     }
	   
}
