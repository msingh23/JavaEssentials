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
public class LC366FindLeavesofBinaryTree {

	List<List<Integer>> out = new ArrayList<List<Integer>>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        while(root!=null)
        {
            List<Integer> leaves_lvl = new ArrayList<Integer>();
            root = postOrderCollectLeaves(root, leaves_lvl);
            out.add(leaves_lvl);
        }
        return out;
    }
    
    public TreeNode postOrderCollectLeaves(TreeNode root, List<Integer> leaves_lvl)
    {
        if(root == null) return null;
        if(root.left  == null && root.right == null)
        {
            leaves_lvl.add(root.val);
            return null;
        }
        
       root.left =  postOrderCollectLeaves(root.left, leaves_lvl);
       root.right = postOrderCollectLeaves(root.right, leaves_lvl);
        
        return root;
    }
	
}
