/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author manu
 *
 */
public class LC314BinaryTreeVerticalOrderTraversal {
	 public List<List<Integer>> verticalOrder(TreeNode root) {
	        List<List<Integer>> out = new ArrayList<List<Integer>>();
	        if(root == null) return out;
	       
	        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	        Queue<Object []> q = new LinkedList<Object []>();
	        
	        q.add(new Object []{root, 0});
	        int minIndx = Integer.MAX_VALUE;
	        int maxIndx = Integer.MIN_VALUE;
	        
	        while(!q.isEmpty())
	        {
	            Object [] elem = q.poll();
	            TreeNode node = (TreeNode)elem[0];
	            int nodeVal = node.val;
	            int nodeIndx = (Integer) elem[1];
	            minIndx = Math.min(minIndx,nodeIndx);
	            maxIndx = Math.max(maxIndx, nodeIndx);
	            
	            addToList(nodeVal, map, nodeIndx);
	            
	            if(node.left!=null)
	                q.add(new Object []{node.left, nodeIndx-1});
	             if(node.right!=null)
	                q.add(new Object []{node.right, nodeIndx+1});
	        }
	        
	        for (int i = minIndx; i<=maxIndx ; i++ )
	        {
	            out.add(map.get(i));
	        }
	        
	        return out;
	    }
	    
	    public void addToList(int val, Map<Integer, List<Integer>> map, int index)
	    {
	        List<Integer> list = map.getOrDefault(index, null);
	        if(null == list) 
	        {
	            list = new ArrayList<Integer>();
	            map.put(index, list);
	        }
	        list.add(val);
	    }
	    
	    
}
