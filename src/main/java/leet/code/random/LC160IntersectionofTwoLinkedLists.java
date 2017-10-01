/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC160IntersectionofTwoLinkedLists {

	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        
	        ListNode p1 = headA;
	        ListNode p2 = headB;
	        
	        int len1 = length(p1);
	        int len2 = length(p2);
	        
	        if(len1 == 0 || len2 == 0) return null;
	        
	        if(len1 -len2 > 0 )
	             p1 = move(p1, len1 -len2);
	        
	         else
	             p2 = move(p2, len2 -len1);

	        while(p1!=null && p2!=null)
	        {
	            if(p1==p2) return p1;
	            p1 = p1.next;
	            p2 = p2.next;
	        }
	        
	        return null;
	    }
	    
	    public ListNode move(ListNode node, int step)
	    {
	        while(step-- > 0)
	            node = node.next;
	        return node;
	    }
	    
	    public int length(ListNode node)
	    {
	        int len =0;
	        while(node!=null )
	        {
	             node = node.next;
	            len++;
	        }
	        return len; 
	    }
}
