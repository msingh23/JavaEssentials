/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC114FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		root = flattenHelp(root);
	}

	public TreeNode getRightMost(TreeNode root) {
		TreeNode temp = root;
		while (temp != null && temp.right != null)
			temp = temp.right;
		return temp;
	}

	public TreeNode flattenHelp(TreeNode root) {
		if (null == root)
			return null;

		TreeNode left = flattenHelp(root.left);
		TreeNode right = flattenHelp(root.right);

		if (null == left && null == right)
			return root;

		if (null != left && null != right) {
			TreeNode lastOfLeft = getRightMost(left);
			root.right = left;
			root.left = null;
			lastOfLeft.right = right;
			return root;
		}
		if (null == right) {
			root.right = left;
			root.left = null;
			return root;
		}
		if (null == left) {
			return root;
		}

		return root;

	}

}
