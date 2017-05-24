/**
 * 
 */
package ctci.chap2;

/**
 * @author manu
 *
 */
public class KthElementFromTheLast {

	static int kthG = 0;

	public Node getKthFromLast(LinkList list, int kth) {
		Node temp = list.head;
		kthG = kth;
		return findKth(temp);

	}

	private Node findKth(Node tail) {
		Node ans = null;
		if (tail == null) {

		} else {
			ans = findKth(tail.next);
			if ((ans == null) && kthG == 1) {
				return tail;
			}
			kthG--;

		}
		return ans;

	}

}
