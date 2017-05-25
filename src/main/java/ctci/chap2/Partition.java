/**
 * 
 */
package ctci.chap2;

/**
 * @author manu
 *
 */
public class Partition<T> {

	public void partition(LinkList list, int data) {

		if (list != null) {

			Node<Integer> head = list.head;
			Node<Integer> p1 = list.head;
			Node<Integer> p2 = null;

			while (p1 != null) {
				if (p1.data < data && p2 != null) {
					head = swap(head, p1, p2);
					list.head = head;

					p1 = p2.next;
				} else {

					p2 = p1;
					p1 = p1.next;
				}
			}

		}

	}

	private Node swap(Node head, Node p1, Node p2) {

		if (p2 != null) {
			p2.next = p1.next;
			p1.next = head;
			return p1;
			// head.next = p1;
		}
		return null;

	}

	public Node partition2(LinkList list, int data) {
		Node head = null;
		if (list != null) {

			head = list.head;
			Node tail = list.head;
			Node<Integer> p1 = list.head;

			while (p1 != null) {

				Node next = p1.next;
				if (p1.data < data) {

					p1.next = head;
					head = p1;

				} else {
					tail.next = p1;
					p1.next = null;
					tail = p1;
				}
				p1 = next;
			}

		}
		return head;

	}

}
