/**
 * 
 */
package ctci.chap4;

import ctci.chap4.BinaryTree.TreeNode;

/**
 * @author manu
 *
 */
public class CheckSubTree {

	public boolean checkSubTree(TreeNode t1, TreeNode t2) {

		if (t1 == null || t2 == null) {
			return false;
		}

		if (t1.value == t2.value) {
			return contains(t1, t2);
		}

		return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);

	}

	private boolean contains(TreeNode t1, TreeNode t2) {

		if (t2 != null && t1 == null) {
			return false;
		}
		if ((t1 == null && t2 == null) || t2 == null) {
			return true;
		}

		if (t1.value != t2.value) {
			return false;
		}

		if (t1 != null && t2 != null) {
			return contains(t1.left, t2.left) && contains(t1.right, t2.right);
		}

		return true;

	}

}
