/**
 * 
 */
package ctci.chap4;

import ctci.chap4.BinaryTree.TreeNode;

/**
 * @author manu
 *
 */
public class CheckIfBalanced {

	public int checkIfBalanced(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = checkIfBalanced(root.left) + 1;
		int right = checkIfBalanced(root.right) + 1;

		if (left == -1 || right == -1)
			return -1;

		return Math.abs(left - right) > 1 ? -1 : Math.max(left, right);

	}

}
