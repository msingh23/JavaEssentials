/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC2AddTwoNumbers {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	        
	        ListNode sum = new ListNode(-1);
	        ListNode head = sum;
	        ListNode prev = null;
	        int carry = 0;
	        
	        while(l1!= null && l2!=null)
	        {
	            int add = l1.val + l2.val + carry;
	            sum.val = (add % 10); 
	            sum.next = new ListNode(-1);
	            prev = sum;
	            sum = sum.next;
	            carry = add / 10;
	            l1 = l1.next;
	            l2 = l2.next;
	        }
	        
	        while(l1!=null)
	        {
	            int add = l1.val + carry;
	            sum.val = (add % 10);  
	            sum.next = new ListNode(-1);
	            prev = sum;
	            sum = sum.next;
	            carry = add / 10;
	            l1 = l1.next;
	        }
	        
	        while(l2!=null)
	        {
	            int add = l2.val + carry;
	            sum.val = (add % 10); 
	            sum.next = new ListNode(-1);
	            prev = sum;
	            sum = sum.next;
	            carry = add / 10;
	            l2 = l2.next;
	        }
	        
	        if(carry!=0)
	        {
	           sum.val = (carry);
	        }
	        
	        //System.out.println(sum.val);
	        if(sum.val == -1 && prev!=null)
	        {
	            prev.next = null;
	            sum = null;
	        }
	        
	        return head;
	    }
}
