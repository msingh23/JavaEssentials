/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC117PopulatingNextRightPointersinEachNodeII {

	 public void connect(TreeLinkNode root) {
	        
	        TreeLinkNode currLvl = root;
	        
	        while(currLvl!=null )
	        {
	            TreeLinkNode lvl = currLvl;
	            
	            while(lvl!=null)
	            {
	                if(lvl.left!=null)
	                {
	                   TreeLinkNode left= lvl.left;
	                    if(lvl.right == null)
	                    {
	                        while(lvl.next!=null )
	                        {
	                            if(lvl.next.left == null && lvl.next.right == null)
	                                lvl = lvl.next;
	                            else
	                            {
	                               left.next = lvl.next.left!=null ? lvl.next.left : lvl.next.right;
	                                break;
	                            }
	                        }
	                    }
	                    else
	                    {
	                        lvl.left.next = lvl.right;
	                    }
	                }
	                if(lvl.right!=null)
	                {
	                   TreeLinkNode right= lvl.right;
	                      while(lvl.next!=null)
	                        {
	                            if(lvl.next.left==null && lvl.next.right == null)
	                                lvl = lvl.next;
	                            else
	                            {
	                                right.next = lvl.next.left!=null? lvl.next.left : lvl.next.right;
	                                break;
	                            }
	                               
	                        }
	                }
	                if(lvl!=null)
	                    lvl = lvl.next;
	            }
	            if(currLvl.left!=null)
	                currLvl = currLvl.left;
	            else if(currLvl.right!=null)
	                currLvl = currLvl.right;
	            else currLvl = currLvl.next;
	            
	        }
	        
	    }
	 
	 public void connect2(TreeLinkNode root) 
	    {
	        TreeLinkNode currLvl = root;
	        TreeLinkNode head = null;
	        TreeLinkNode prev = null;
	        
	        while(currLvl !=null )
	        {
	            TreeLinkNode curr = currLvl;
	            while(curr!=null)
	            {
	                if(curr.left!=null)
	                {
	                    if(prev!=null)
	                    {
	                        prev.next = curr.left;
	                    }
	                    else
	                    {
	                        head = curr.left;
	                    }
	                    prev = curr.left;
	                }
	                
	                if(curr.right!=null)
	                {
	                    if(prev!=null)
	                    {
	                        prev.next = curr.right;
	                    }
	                    else
	                    {
	                        head = curr.right;
	                    }
	                    prev = curr.right;
	                }
	                
	                curr = curr.next;
	            }
	            currLvl = head;
	            head = null;
	            prev = null;
	        }
	    }
}
