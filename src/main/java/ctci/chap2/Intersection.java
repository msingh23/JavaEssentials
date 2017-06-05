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
		Node<T> out=null;
		if (null == head1 || null == head2)
			return out;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		fillStack(head1, s1);
		fillStack(head2, s2);
		while (!s1.isEmpty() && !s2.isEmpty()) {
			Node s1Pop= s1.pop();
			if (s1Pop == s2.pop()) {
				out=s1Pop;
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

}
