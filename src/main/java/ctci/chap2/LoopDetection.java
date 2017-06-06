/**
 * 
 */
package ctci.chap2;

/**
 * @author manu
 *
 */
public class LoopDetection<T> {

	public Node getLoopStartNode(Node<T> head) {
		Node out = null;
		if (null == head)
			return null;
		Node slow = head;
		Node fast = head;
		boolean detect = false;
		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				detect = true;
				break;
			}

		}

		if (detect) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			out = fast;
		}

		return out;
	}

}
