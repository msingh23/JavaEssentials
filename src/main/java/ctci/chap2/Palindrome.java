/**
 * 
 */
package ctci.chap2;

/**
 * @author manu
 *
 */
public class Palindrome {

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

}
