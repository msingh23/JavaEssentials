/**
 * 
 */
package ctci.chap4;

import ctci.chap4.BinaryTree.TreeNode;

/**
 * @author manu
 *
 */
public class BuildMinimalTree {

	public BinaryTree.TreeNode buildminimalTree(int[] inp, int start, int end) {
		if (start <= end) {
			int middle = start + (end - start) / 2;
			BinaryTree bt = new BinaryTree(inp[middle]);
			TreeNode root = bt.root;
			root.left = buildminimalTree(inp, start, middle - 1);
			root.right = buildminimalTree(inp, middle + 1, end);
			return root;
		}
		return null;

	}

}
