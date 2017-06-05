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

	public boolean isIntersectionIterative(Node<T> head1, Node<T> head2) {
		if (null == head1 || null == head2)
			return false;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		fillStack(head1, s1);
		fillStack(head2, s2);
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if (s1.pop() == s2.pop()) {
				return true;
			}
		}
		return false;
	}

	private void fillStack(Node<T> head, Stack<Node> s1) {
		Node temp = head;
		while (temp != null) {
			s1.add(temp);
			temp = temp.next;
		}

	}

}
