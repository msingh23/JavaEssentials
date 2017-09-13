/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author manu
 *
 */
public class LC103BinaryTreeZigzagLevelOrderTraversal {

	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        
	        List<List<Integer>> out = new ArrayList<List<Integer>>();
	         if(root == null) return out;
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        TreeNode odd = new TreeNode(2);
	        TreeNode even = new TreeNode(1);
	        
	        q.add(root);
	        q.add(odd);
	        boolean reverse = false;
	        
	        List<Integer> level = new ArrayList<Integer>();
	        while(!q.isEmpty())
	        {
	            
	            
	            TreeNode curr = q.poll();
	            //System.out.println(curr.val);
	           
	            if(curr == odd )
	            {
	                out.add(new ArrayList<Integer>(level)); 
	                level = new ArrayList<Integer>();
	                reverse = true;
	                if(q.isEmpty()) break;
	                q.add(even);
	            }
	             else if(curr == even)
	            {
	                out.add(new ArrayList<Integer>(level)); 
	                level = new ArrayList<Integer>();
	                reverse = false;
	                if(q.isEmpty()) break;
	                  q.add(odd);
	            }else
	             {
	                if(reverse)
	                {
	                    level.add(0, curr.val);
	                }else
	                {
	                    level.add(curr.val);
	                }
	            
	            if(curr.left!=null) q.add(curr.left);
	            if(curr.right!=null) q.add(curr.right);
	             
	             }
	        }
	        return out;
	    }
	
}
