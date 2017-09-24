/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC235LowestCommonAncestorofaBinarySearchTree {

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null ) return null;
        
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p , q);
        else return root;
         
    }
	
}
