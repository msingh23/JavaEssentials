/**
 * 
 */
package ctci.chap4;

import ctci.chap4.BinaryTree.TreeNode;

/**
 * @author manu
 *
 */
public class Succesor {

	public class Max {
		TreeNode max = null;
	}

	public TreeNode getSuccesorBinarySearch(TreeNode root, TreeNode succ) {
		Max max = new Max();
		if (root != null) {
			return getSuccessBS(root, succ, max);
		}
		return root;
	}

	private TreeNode getSuccessBS(TreeNode root, TreeNode succ, Max max) {

		if (root == null) {
			return null;
		}

		if (root.value == succ.value) {
			if (succ.right != null) {
				return min(succ.right);
			} else {
				return max.max;
			}
		}

		if (succ.value < root.value) {
			max.max = root;
			return getSuccessBS(root.left, succ, max);
		}
		return getSuccessBS(root.right, succ, max);

	}

	private TreeNode min(TreeNode right) {
		TreeNode min = right;
		while (min.left != null) {
			min = min.left;
		}
		return min;
	}

	public TreeNode getSuccessor(TreeNode root, TreeNode succ) {

		if (root != null) {
			return getSuccesor(root, succ, null);

		}
		return root;
	}

	private TreeNode getSuccesor(TreeNode root, TreeNode succ, TreeNode max) {

		if (root.value == succ.value) {
			if (root.right != null) {
				return min(root.right);
			} else {
				return max;
			}
		}

		TreeNode left = null;
		TreeNode right = null;
		if (root.left != null) {
			left = getSuccesor(root.left, succ, root);
		}
		if (root.right != null) {
			right = getSuccesor(root.right, succ, max);
		}
		if (right != null) {
			return right;
		}
		if (left != null) {
			return left;
		} else {
			return null;
		}
	}

}
