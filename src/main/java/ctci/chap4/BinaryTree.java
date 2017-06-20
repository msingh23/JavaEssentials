/**
 * 
 */
package ctci.chap4;

/**
 * @author manu
 *
 */
public class BinaryTree {

	public TreeNode root;

	public class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			this.value = value;
			left = null;
			right = null;
		}

	}

	public BinaryTree(int data) {
		root = new TreeNode(data);
	}

	public TreeNode add(TreeNode root, int value) {
		if (root != null) {

			if (value <= (root.value)) {
				TreeNode left = add(root.left, value);
				root.left = left;
				return root;
			} else {
				TreeNode right = add(root.right, value);
				root.right = right;
				return root;
			}

		} else {
			return new TreeNode(value);
		}
	}

	public void add2(TreeNode root, int value) {
		if (root != null) {

			if (value <= (root.value)) {
				if (root.left == null) {
					root.left = new TreeNode(value);
				} else {
					add2(root.left, value);
				}
			} else {
				if (root.right == null) {
					root.right = new TreeNode(value);
				} else {
					add2(root.right, value);
				}

			}

		} else {
			root = new TreeNode(value);
		}
	}

	public void InOrderTraversal(TreeNode root) {
		if (root != null) {
			InOrderTraversal(root.left);
			System.out.print(root.value + "-->");
			InOrderTraversal(root.right);
		}

	}

	public void PreOrderTraversal(TreeNode root) {
		if (root != null) {
			System.out.print(root.value + "-->");
			PreOrderTraversal(root.left);
			PreOrderTraversal(root.right);
		}
	}

	public void PostOrderTraversal(TreeNode root) {
		if (root != null) {
			PostOrderTraversal(root.left);
			PostOrderTraversal(root.right);
			System.out.print(root.value + "-->");
		}
	}

}
