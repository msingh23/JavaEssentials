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

	public Node getKthNodeFromLast2(LinkList list, int kth) {
		Node p1 = null;
		Node p2 = null;

		if (null != list) {

			p1 = list.head;
			p2 = list.head;
			int count = 1;

			while (p1.next != null) {

				if (count < kth) {
					count++;
				} else {
					p2 = p2.next;
				}
				p1 = p1.next;

			}

		}

		return p2;
	}

}
