/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC148SortList {

	public ListNode sortList(ListNode head) {

		if (head != null && head.next != null) {
			ListNode mid = getMid(head);
			ListNode second = mid.next;
			mid.next = null;
			ListNode p1 = sortList(head);
			ListNode p2 = sortList(second);
			// System.out.println(p1.val + " "+ p2.val);
			return merge(p1, p2);
		}
		return head;
	}

	public ListNode merge(ListNode p1, ListNode p2) {
		ListNode head = new ListNode(0);
		ListNode temp = head;

		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				temp.next = p1;
				p1 = p1.next;
				temp = temp.next;
				// temp.next = null;
			} else {
				temp.next = p2;
				p2 = p2.next;
				temp = temp.next;
				// temp.next = null;
			}
		}
		if (p1 != null) {
			temp.next = p1;
		}
		if (p2 != null) {
			temp.next = p2;
		}

		return head.next;

	}

	public ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = slow;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		return prev;
	}
}
