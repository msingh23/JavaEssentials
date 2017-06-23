/**
 * 
 */
package ctci.chap4;

import ctci.chap4.BinaryTree.TreeNode;

/**
 * @author manu
 *
 */
public class ValidateBST {

	public boolean isBST(TreeNode root) {
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;

		return isBST(root, max, min);

	}

	private boolean isBST(TreeNode root, int max, int min) {
		if (root == null)
			return true;
		if (greatorThan(root, root.right, min, max) && lessThan(root, root.left, min, max)) {
			return (isBST(root.left, root.value, min) && isBST(root.right, max, root.value));

		} else {
			return false;
		}

	}

	private boolean greatorThan(TreeNode root, TreeNode right, int min, int max) {
		return (right == null) ? true : (root.value <= right.value && right.value <= max && right.value >= min);
	}

	private boolean lessThan(TreeNode root, TreeNode left, int min, int max) {
		return (left == null) ? true : (root.value >= left.value && left.value <= max && left.value >= min);
	}

}
