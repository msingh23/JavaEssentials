/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC234PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {

		if (null == head)
			return true;

		ListNode slow = head;
		ListNode prev = null;
		ListNode fast = head.next;
		boolean odd = head.next == null ? true : false;

		while (fast != null && fast.next != null) {

			ListNode next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;
			fast = fast.next;
			if (fast != null && fast.next != null) {
				fast = fast.next;
			} else {
				odd = true;
			}

		}
		ListNode next = slow;
		if (odd) {
			slow = slow.next;
		} else {
			if (slow.val != slow.next.val)
				return false;
			else {
				// System.out.println("even");
				slow = slow.next.next;
			}
		}

		boolean ans = true;
		while (slow != null && prev != null) {

			ListNode temp = prev.next;
			if (slow.val != prev.val)
				ans = false;

			slow = slow.next;
			prev.next = next;
			next = prev;
			prev = temp;
		}

		return ans;
	}

}
