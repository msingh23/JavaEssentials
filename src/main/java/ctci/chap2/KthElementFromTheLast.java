/**
 * 
 */
package ctci.chap2;

/**
 * @author manu
 *
 */
public class KthElementFromTheLast {

	public class kThVal {
		private int val;

		public kThVal(int val) {
			this.val = val;
		}
	}

	// static int kthG = 0;

	public Node getKthFromLast(LinkList list, int kth) {
		Node temp = list.head;
		kThVal k = new kThVal(kth);

		// kthG = kth;
		return findKth(temp, k);

	}

	private Node findKth(Node tail, kThVal k) {
		Node ans = null;
		if (tail == null) {

		} else {
			ans = findKth(tail.next, k);
			if ((ans == null) && k.val == 1) {
				return tail;
			}
			k.val--;

		}
		return ans;

	}

}
