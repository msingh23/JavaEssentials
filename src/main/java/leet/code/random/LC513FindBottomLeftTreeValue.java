/**
 * 
 */
package leet.code.random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author manu
 *
 */
public class LC513FindBottomLeftTreeValue {

	public int findBottomLeftValue(TreeNode root) {

		// if(root ==null) return root;

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);
		q.add(null);
		TreeNode left = root;

		while (!q.isEmpty()) {

			TreeNode pop = q.poll();
			if (pop == null) {
				if (!q.isEmpty()) {
					q.add(null);
					pop = q.poll();
					left = pop;
				} else {
					continue;
				}

			}

			if (pop.left != null)
				q.add(pop.left);
			if (pop.right != null)
				q.add(pop.right);
		}

		return left.val;

	}
}
