/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC206ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

}
