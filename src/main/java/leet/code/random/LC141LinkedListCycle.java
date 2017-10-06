/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC141LinkedListCycle {

	public boolean hasCycle(ListNode head) {

		ListNode temp = head;
		if (null == temp)
			return false;

		ListNode slow = temp;
		ListNode fast = temp.next;

		while (fast != null && fast.next != null) {
			if (fast == slow)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}

		return false;
	}

}
