/**
 * 
 */
package ctci.chap4;

import java.util.ArrayList;
import java.util.List;

import ctci.chap3.Queue;
import ctci.chap4.BinaryTree.TreeNode;

/**
 * @author manu
 *
 */
public class ListOfDepths {

	public void createListOfDepths(BinaryTree tree, ArrayList<ArrayList<TreeNode>> listOfList, ArrayList<TreeNode> list)
			throws Exception {
		if (null != tree) {
			Queue<TreeNode> q = new Queue<TreeNode>();
			q.enqueue(tree.root);
			q.enqueue(null);
			while (true) {
				TreeNode root = q.dequeue();
				if (root == null) {
					listOfList.add(list);
					if (q.isEmpty()) {
						break;
					}
					list = new ArrayList<TreeNode>();
					q.enqueue(null);
				} else {
					list.add(root);
					if (root.left != null)
						q.enqueue(root.left);
					if (root.right != null)
						q.enqueue(root.right);

				}
			}
		}

	}

	public List<ArrayList<TreeNode>> createListOfDepthsWithoutQueue(TreeNode root) {
		List<ArrayList<TreeNode>> listOfList = new ArrayList<ArrayList<TreeNode>>();
		if (root == null) {
			return null;
		}
		ArrayList<TreeNode> current = new ArrayList<TreeNode>();
		current.add(root);
		while (current.size() > 0) {
			ArrayList<TreeNode> prev = current;
			listOfList.add(current);
			current = new ArrayList<TreeNode>();
			for (TreeNode node : prev) {
				if (node.left != null) {
					current.add(node.left);
				}
				if (node.right != null) {
					current.add(node.right);
				}
			}
		}

		return listOfList;

	}

	public void createListOfDepthsRecursive(ArrayList<ArrayList<TreeNode>> listOfList, TreeNode root, int level) {
		if (listOfList.size() == level) {
			ArrayList<TreeNode> current = new ArrayList<TreeNode>();
			listOfList.add(current);
		}
		ArrayList<TreeNode> list = listOfList.get(level);
		list.add(root);
		if(root.left!=null){
			createListOfDepthsRecursive(listOfList, root.left, level+1);
		}
		if(root.right!=null){
			createListOfDepthsRecursive(listOfList, root.right, level+1);
		}
		
	}
}
