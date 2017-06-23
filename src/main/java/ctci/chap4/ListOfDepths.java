/**
 * 
 */
package ctci.chap4;

import java.util.ArrayList;

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
			while (!q.isEmpty() && q.peek() != null) {
				TreeNode root = q.dequeue();
				if (root == null) {
					listOfList.add(list);
					list = new ArrayList<TreeNode>();
					q.enqueue(null);
				} else {
					list.add(root);
					q.enqueue(root.left);
					q.enqueue(root.right);
				}
			}
		}

	}
}
