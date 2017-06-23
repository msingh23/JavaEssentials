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
}
