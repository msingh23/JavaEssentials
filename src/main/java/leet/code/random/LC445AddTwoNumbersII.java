/**
 * 
 */
package leet.code.random;

import java.util.Stack;

/**
 * @author manu
 *
 */
public class LC445AddTwoNumbersII {
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
     {
         Stack<ListNode> s1 = new Stack<ListNode>();
         Stack<ListNode> s2 = new Stack<ListNode>();
         
         while(l1!=null) 
         {
             s1.add(l1);
             l1 = l1.next;
         }
         while(l2!=null) 
         {
             s2.add(l2);
             l2 = l2.next;
         }
         
         int sum = 0;
         ListNode tail = new ListNode(0);
         while(!s1.isEmpty() || !s2.isEmpty() )
         {
             if(!s1.isEmpty())
             {
                 sum += s1.peek().val;
                 s1.pop();
             }
             if(!s2.isEmpty())
             {
                 sum+=s2.peek().val;
                 s2.pop();
             }
             tail.val = sum%10;
             sum /= 10;
             ListNode curr = new ListNode(0);
             curr.next = tail;
             tail = curr;
         }
         
         if(sum!=0)
         {
             tail.val = (sum);
             return tail;
         }
         
         return tail.next;
         
     }

}
