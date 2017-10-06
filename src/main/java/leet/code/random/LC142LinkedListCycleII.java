/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC142LinkedListCycleII {

public ListNode detectCycle(ListNode head) {
        
        ListNode temp = head;
        if(null == temp) return null;
        ListNode slow = temp;
        ListNode fast = temp;
        
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow)
            {
                 slow = head;
        
                while(slow!=fast)
                {
                    //System.out.println(slow.val);
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
            
           
        }
        return null;
    }
	
}
