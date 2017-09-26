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
public class LC199BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<Integer>();
        if(root == null) return out;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        TreeNode prev = null;
        
        while(!q.isEmpty())
        {
            
            TreeNode curr = q.poll();
            
            if(curr==null)
            {
                if(!q.isEmpty())
                {
                    q.add(null);
                }
                if(prev!=null)  out.add(prev.val);
            }else{
                  prev = curr;
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            
          
            
        }
        
        return out;
        
    }
}
