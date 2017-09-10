/**
 * 
 */
package leet.code.random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author manu
 *
 */
public class LC623AddOneRowtoTree {

	 public TreeNode addOneRow(TreeNode root, int v, int d) 
	    {
	        if(d==1)
	        {
	            TreeNode tn = new TreeNode(v);
	            tn.left = root;
	            //tn.right = root;
	            return tn;
	        }
	        
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.add(root);
	        q.add(null);
	        int dep = 1;
	        while(!q.isEmpty())
	        {
	           
	            TreeNode node = q.poll();
	            if(node == null && !q.isEmpty()){
	                dep++;
	                q.add(null);
	                continue;
	            } 
	             if(dep>d-1) break;
	            if(dep == d-1)
	            {
	                TreeNode left = node.left;
	                TreeNode right = node.right;
	                
	                //TreeNode newNode = new TreeNode(v);
	                node.left =  new TreeNode(v);
	                node.right =  new TreeNode(v);
	                node.left.left = left;
	                node.right.right = right;
	            }
	            if(node.left!=null) q.add(node.left);
	            if(node.right!=null) q.add(node.right);
	            
	            
	            
	            
	        }
	        
	        return root;
	        
	    }
}
