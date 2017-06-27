/**
 * 
 */
package ctci.chap4;

import java.util.ArrayList;
import java.util.LinkedList;

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
		ArrayList<TreeNode> centerList = new ArrayList<TreeNode>();

		ArrayList<TreeNode> rootlistLeft = new ArrayList<TreeNode>();
		ArrayList<TreeNode> rootlistRight = new ArrayList<TreeNode>();
		ArrayList<ArrayList<TreeNode>> center = new ArrayList<ArrayList<TreeNode>>();
		centerList.add(root);
		if (left == null && right == null) {
			center.add(centerList);
		}

		if (left != null) {
			for (ArrayList<TreeNode> llist : left) {
				rootlistLeft = new ArrayList<TreeNode>();
				rootlistLeft.addAll(centerList);
				rootlistLeft.addAll(llist);
				if (right != null) {
					for (ArrayList<TreeNode> rlist : right) {
						rootlistRight = new ArrayList<TreeNode>();
						rootlistRight.addAll(rootlistLeft);
						rootlistRight.addAll(rlist);
						center.add(rootlistRight);

					}
				} else {
					center.add(rootlistLeft);
				}

			}
		}

		if (right != null) {
			for (ArrayList<TreeNode> rlist : right) {
				rootlistRight = new ArrayList<TreeNode>();
				rootlistRight.addAll(centerList);
				rootlistRight.addAll(rlist);
				if (left != null) {
					for (ArrayList<TreeNode> llist : left) {
						rootlistLeft = new ArrayList<TreeNode>();
						rootlistLeft.addAll(rootlistRight);
						rootlistLeft.addAll(llist);
						center.add(rootlistLeft);

					}
				} else {
					center.add(rootlistRight);
				}

			}
		}

		return center;

	}

	public ArrayList<LinkedList<TreeNode>> getNode(TreeNode node) {
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
		if (node == null) {
			res.add(new LinkedList<TreeNode>());
			return res;
		}

		ArrayList<LinkedList<TreeNode>> left = getNode(node.left);
		ArrayList<LinkedList<TreeNode>> right = getNode(node.right);

		LinkedList<TreeNode> prefix = new LinkedList<TreeNode>();
		prefix.add(node);

		for (LinkedList<TreeNode> lll : left) {
			for (LinkedList<TreeNode> rll : right) {
				ArrayList<LinkedList<TreeNode>> weave = new ArrayList<LinkedList<TreeNode>>();
				weaveList(lll, rll, prefix, weave);
				res.addAll(weave);
			}

		}
		return res;
	}

	private void weaveList(LinkedList<TreeNode> lll, LinkedList<TreeNode> rll, LinkedList<TreeNode> prefix,
			ArrayList<LinkedList<TreeNode>> weave) {

		if (lll.size() == 0 || rll.size() == 0) {
			LinkedList<TreeNode> res = new LinkedList<TreeNode>();
			res.addAll(prefix);
			res.addAll(lll);
			res.addAll(rll);
			weave.add(res);
			return;
		}

		TreeNode first = lll.removeFirst();
		prefix.addLast(first);
		weaveList(lll, rll, prefix, weave);
		lll.addFirst(prefix.removeLast());

		TreeNode Second = rll.removeFirst();
		prefix.add(Second);
		weaveList(lll, rll, prefix, weave);
		rll.addFirst(prefix.removeLast());

	}
}
