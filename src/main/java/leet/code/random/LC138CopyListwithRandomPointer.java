/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC138CopyListwithRandomPointer {

	
	
	 // Definition for singly-linked list with a random pointer.
	  class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  };
	 
	 Map<Integer, RandomListNode> map = new HashMap<Integer,RandomListNode >();
	    public RandomListNode copyRandomList(RandomListNode head) {
	        return copyRandomListHelp(head);
	    }
	    
	     public RandomListNode copyRandomListHelp(RandomListNode head) 
	     {
	         if(null == head) return null;
	         if(map.containsKey(head.label))
	         {
	             return map.get(head.label);
	         }
	         
	         RandomListNode clone = new RandomListNode(head.label);
	         map.put(head.label, clone);
	         clone.next = copyRandomListHelp(head.next);
	         clone.random = copyRandomListHelp(head.random);
	         return clone;
	     }
}
