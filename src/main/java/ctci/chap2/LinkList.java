/**
 * 
 */
package ctci.chap2;

/**
 * @author manu
 *
 */
public class LinkList<T> {

	public Node<T> head = null;

	public LinkList(T data) {
		if (head == null) {
			head = new Node(data);
		}
	}

	public void addNode(T data) {

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node<T>(data);
	}

	public void addNode(Node<T> node) {

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	public void removeNode(T data) {
		Node curr = head;
		Node prev = null;
		while (null != curr && null != curr.next && curr.data != data) {
			prev = curr;
			curr = curr.next;
		}
		if (prev == null && data == head.data) {
			head = head.next;
		} else if (data == curr.data) {
			prev.next = curr.next;
		}
	}

}
