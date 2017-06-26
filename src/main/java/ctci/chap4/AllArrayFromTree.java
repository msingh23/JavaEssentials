/**
 * 
 */
package ctci.chap4;

import java.util.ArrayList;

import ctci.chap4.BinaryTree.TreeNode;

/**
 * @author manu
 *
 */
public class AllArrayFromTree {

	public ArrayList<ArrayList<TreeNode>> getAllArray(TreeNode root) {
		if (root == null) {
			return null;
		}

		ArrayList<ArrayList<TreeNode>> left = getAllArray(root.left);
		ArrayList<ArrayList<TreeNode>> right = getAllArray(root.right);
		ArrayList<TreeNode> rootlistLeft = new ArrayList<TreeNode>();
		ArrayList<TreeNode> rootlistRight = new ArrayList<TreeNode>();
		ArrayList<ArrayList<TreeNode>> center = new ArrayList<ArrayList<TreeNode>>();
		rootlistLeft.add(root);

		for (ArrayList<TreeNode> list : left) {
			rootlistLeft.addAll(list);
		}

		for (ArrayList<TreeNode> list : right) {
			rootlistLeft.addAll(list);
			rootlistRight.addAll(list);
		}

		for (ArrayList<TreeNode> list : left) {
			rootlistRight.addAll(list);
		}

		center.add(rootlistLeft);
		center.add(rootlistRight);
		return center;

	}

}
