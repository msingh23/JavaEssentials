/**
 * 
 */
package ctci.chap2;

import java.util.Stack;

/**
 * @author manu
 *
 */
public class Intersection<T> {

	public Node isIntersectionIterative(Node<T> head1, Node<T> head2) {
		Node<T> out = null;
		if (null == head1 || null == head2)
			return out;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		fillStack(head1, s1);
		fillStack(head2, s2);
		while (!s1.isEmpty() && !s2.isEmpty()) {
			Node s1Pop = s1.pop();
			if (s1Pop == s2.pop()) {
				out = s1Pop;
			}
		}
		return out;
	}

	private void fillStack(Node<T> head, Stack<Node> s1) {
		Node temp = head;
		while (temp != null) {
			s1.add(temp);
			temp = temp.next;
		}

	}

	public Node isIntersection(Node<T> n1, Node<T> n2) {
		Node<T> out = null;
		if (null == n1 || null == n2)
			return out;

		Node t1 = n1;
		Node t2 = n2;
		int len1 = len(t1);
		int len2 = len(t2);

		if (len1 < len2) {
			t2 = move(t2, len2 - len1);
		} else {
			t1 = move(t1, len1 - len2);
		}

		while (t1 != null && t2 != null) {
			if (t1 == t2) {
				return t1;
			}
			t1 = t1.next;
			t2 = t2.next;
		}

		return out;
	}

	private Node move(Node head, int i) {
		while (i > 0) {
			head = head.next;
			i--;
		}
		return head;
	}

	private int len(Node<T> n1) {
		Node<T> temp = n1;
		int len = 0;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}

}
