/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC116PopulatingNextRightPointersInEachNode {

	/*
	 * public void connect(TreeLinkNode root) {
	 * 
	 * if(root == null) return; Queue<TreeLinkNode> q = new
	 * LinkedList<TreeLinkNode>(); q.add(root); q.add(null); TreeLinkNode prev =
	 * null;
	 * 
	 * while(!q.isEmpty()) { TreeLinkNode curr = q.poll();
	 * 
	 * if(curr == null) { if(!q.isEmpty()) { q.add(null); } } if(prev!=null) {
	 * prev.next = curr; } if(curr!=null && curr.left!=null) q.add(curr.left);
	 * if(curr!=null && curr.right!=null) q.add(curr.right); prev = curr;
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	public void connect(TreeLinkNode root) {

		TreeLinkNode currLvl = root;

		while (currLvl != null && currLvl.left != null) {
			TreeLinkNode lvl = currLvl;

			while (lvl != null) {
				lvl.left.next = lvl.right;
				if (lvl.next != null)
					lvl.right.next = lvl.next.left;
				lvl = lvl.next;

			}
			currLvl = currLvl.left;

		}

	}
}
