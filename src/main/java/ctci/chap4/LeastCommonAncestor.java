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
		// if (!contain(root, p) && !contain(root, q)) {
		// return null;
		// }
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

	private boolean contain(TreeNode root, TreeNode q) {
		if (root == null) {
			return false;
		}
		if (root == q) {
			return true;
		}
		return contain(root.left, q) || contain(root.right, q);
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

	public TreeNode LCAWithParentNoRoot(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return null;
		}

		if (contain(p, q)) {
			return p;
		}

		if (contain(q, p)) {
			return q;
		}
		TreeNode parent = p.parent;
		TreeNode sibling = p.getSibling();
		while (!contain(sibling, q) && parent != null) {
			sibling = parent.getSibling();
			parent = parent.parent;
		}
		return parent;

	}

}
