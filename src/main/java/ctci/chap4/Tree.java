/**
 * 
 */
package ctci.chap4;

import ctci.chap4.Tree.TreeNode;

/**
 * @author manu
 *
 */
public class Tree {

	TreeNode root;

	public class TreeNode {
		int data;
		TreeNode parent;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
			parent = null;
			left = null;
			right = null;
		}

		public void addLeftNode(TreeNode node) {
			this.left = node;
			node.parent = this;
		}

		public void addRightNode(TreeNode node) {
			this.right = node;
			node.parent = this;
		}

		public TreeNode getSibling() {
			if (this.parent == null) {
				return null;
			}
			return this.parent.left == this ? this.parent.right : this.parent.left;

		}
	}

	public Tree(TreeNode node) {
		root = node;

	}

}
