/**
 * 
 */
package ctci.chap2;

import java.util.Stack;

/**
 * @author manu
 *
 */
public class Palindrome<T> {

	public boolean isPalindrome(Node head) {

		Node p1 = head;
		Node p2 = head;
		return checkPalindrome(p1, p2) == null ? false : true;

	}

	private Node checkPalindrome(Node head, Node tail) {
		if (tail == null) {
			return head;
		}

		Node com = checkPalindrome(head, tail.next);
		if (com != null) {
			if (com.data == tail.data) {
				if (com.next == null) {
					return com;
				}
				return com.next;
			}
		}
		return null;

	}

	public boolean isPalindrome2(Node head) {

		int len = lengthListList(head);
		return palindromRecurse(head, len).ans;

	}

	private Result palindromRecurse(Node head, int len) {

		if (len == 0) {
			return new Result(head, true);
		}
		if (len == 1) {
			return new Result(head.next, true);
		}

		Result res = palindromRecurse(head.next, len - 2);
		if (!res.ans) {
			return res;
		}
		res.ans = res.back.data == head.data;
		res.back = res.back.next;
		return res;
	}

	private class Result {
		private Node back;
		private Boolean ans;

		public Result(Node back, Boolean ans) {
			// TODO Auto-generated constructor stub
			this.back = back;
			this.ans = ans;
		}
	}

	private int lengthListList(Node head) {
		int length = 0;
		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	public boolean isPalindrome3(Node head) {

		Node<T> p1 = null;
		Node<T> p2 = null;
		Stack<T> stack = new Stack<T>();

		if (head != null) {
			p1 = head;
			p2 = head.next;
			stack.push(p1.data);

		}
		boolean odd = false;
		while (p2 != null && p2.next != null) {
			if (p2.next.next == null) {
				odd = true;
			}
			p1 = p1.next;
			stack.push(p1.data);
			p2 = p2.next.next;
		}

		if (odd) {
			stack.pop();
		}
		while (p1 != null && p1.next != null) {
			if (p1.next.data != stack.pop()) {
				return false;
			}
			p1 = p1.next;
		}
		return true;
	}

}
