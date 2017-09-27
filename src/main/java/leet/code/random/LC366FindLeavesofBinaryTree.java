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

	/*
	 * List<List<Integer>> out = new ArrayList<List<Integer>>(); public
	 * List<List<Integer>> findLeaves(TreeNode root) {
	 * 
	 * while(root!=null) { List<Integer> leaves_lvl = new ArrayList<Integer>();
	 * root = postOrderCollectLeaves(root, leaves_lvl); out.add(leaves_lvl); }
	 * return out; }
	 * 
	 * public TreeNode postOrderCollectLeaves(TreeNode root, List<Integer>
	 * leaves_lvl) { if(root == null) return null; if(root.left == null &&
	 * root.right == null) { leaves_lvl.add(root.val); return null; }
	 * 
	 * root.left = postOrderCollectLeaves(root.left, leaves_lvl); root.right =
	 * postOrderCollectLeaves(root.right, leaves_lvl);
	 * 
	 * return root; }
	 * 
	 */

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		findLeavedAndRemove(root, out, 0);
		return out;
	}

	public int findLeavedAndRemove(TreeNode root, List<List<Integer>> out, int count) {
		if (null == root)
			return 0;
		if (root.left == null && root.right == null) {
			if (out.size() - 1 < count) {
				out.add(count, new ArrayList<Integer>());
			}
			out.get(count).add(root.val);
			return count + 1;
		}

		int left = findLeavedAndRemove(root.left, out, count);
		int right = findLeavedAndRemove(root.right, out, count);

		int max = Math.max(left, right);

		if (out.size() - 1 < max) {
			out.add(max, new ArrayList<Integer>());
		}
		out.get(max).add(root.val);
		return max + 1;

	}
}
