/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC143ReorderList {

	public void reorderList(ListNode head) {
        if(head == null || head.next ==null) return ;
        ListNode slow = head, pre = null;;
        ListNode fast = head;
        
        while(fast!=null && fast.next !=null)
        {
            pre=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(pre!=null) pre.next = null;
         pre = null; ListNode curr= slow;
        
        while(curr!=null)
        {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        
        ListNode rhead = pre;
        ListNode fhead = head;
        while(rhead !=null && fhead!=null)
        {
            ListNode ftemp = fhead.next;
            ListNode rtemp = rhead.next;
            fhead.next = rhead;
            if( ftemp!=null)
                fhead.next.next = ftemp;
            fhead = ftemp;
            rhead = rtemp;
        }
        
        //return head;
    }
}
