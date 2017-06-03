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

}
