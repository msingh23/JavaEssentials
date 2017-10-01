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
	
	   public ListNode reverseList2(ListNode head) 
	     {
	        return reverseListHealper(head, null);
	     }
	     public ListNode reverseListHealper(ListNode curr, ListNode prev) 
	     {
	         if(null == curr) return prev;
	         
	         ListNode next = curr.next;
	         curr.next = prev;
	         prev = curr;
	         return reverseListHealper(next, prev);
	         
	     }

}
