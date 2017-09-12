/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC230KthSmallestElementinaBST {

	 int count =0;
	    public int kthSmallest(TreeNode root, int k) {
	        if(root == null) return 0;
	        int l = kthSmallest(root.left, k);
	        count++;
	        if(count == k) return root.val;
	        int r = kthSmallest(root.right, k);
	        return Math.max(l,r);
	    }
}
