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

	public TreeNode getSuccessor(TreeNode root, TreeNode succ) {

		if (root != null) {
			return getSuccesor(root, succ, null);

		}
		return root;
	}

	private TreeNode getSuccesor(TreeNode root, TreeNode succ, TreeNode max) {

		if (root.value == succ.value) {
			if (root.right != null) {
				return root.right;
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
