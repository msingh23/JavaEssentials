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
		if (root == null) {
			return true;
		}

		if (isBST(root.left) && isBST(root.right)) {
			return lessThan(root, root.left) && greatorThan(root, root.right);
		} else {
			return false;
		}
	}

	private boolean greatorThan(TreeNode root, TreeNode right) {
		return (right == null) ? true : root.value <= right.value;
	}

	private boolean lessThan(TreeNode root, TreeNode left) {
		return (left == null) ? true : root.value >= left.value;
	}

}
