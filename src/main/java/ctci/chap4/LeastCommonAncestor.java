/**
 * 
 */
package ctci.chap4;

import ctci.chap4.Tree.TreeNode;

/**
 * @author manu
 *
 */
public class LeastCommonAncestor {

	public TreeNode LCAWithParent(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		int leftDepth = getDepth(p);
		int rightDepth = getDepth(q);

		if (leftDepth - rightDepth > 0) {
			p = moveUp(p, Math.abs(leftDepth - rightDepth));
		} else {
			q = moveUp(q, Math.abs(leftDepth - rightDepth));
		}
		TreeNode left = p;
		TreeNode right = q;

		while (left != null && left != right) {
			left = left.parent;
			right = right.parent;
		}
		return left;
	}

	private TreeNode moveUp(TreeNode p, int abs) {

		TreeNode temp = p;
		while (temp != null && abs != 0) {
			abs--;
			temp = temp.parent;
		}
		return temp;
	}

	private int getDepth(TreeNode p) {
		TreeNode temp = p;
		int depth = 0;
		while (temp != null) {
			depth++;
			temp = temp.parent;
		}
		return depth;
	}

}
