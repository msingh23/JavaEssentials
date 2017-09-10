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
public class LC133CloneGraph {

	
	
	 //* Definition for undirected graph.
	  class UndirectedGraphNode {
	      int label;
	     List<UndirectedGraphNode> neighbors;
	     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 
	  }
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	       
        if(node == null) return node;
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        Map<UndirectedGraphNode,Boolean> visited = new HashMap<UndirectedGraphNode,Boolean> ();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node,clone);
        
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        
        while(!q.isEmpty())
        {
            UndirectedGraphNode curr = q.poll();
            UndirectedGraphNode miror = map.get(curr);
            
            if(!visited.getOrDefault(curr, false))
            {
                 
            for(UndirectedGraphNode nb: curr.neighbors)
            {
                    UndirectedGraphNode ref = map.getOrDefault(nb, null);
                    if(ref == null)
                    {
                        UndirectedGraphNode ugn = new UndirectedGraphNode(nb.label);
                        map.put(nb, ugn);
                        ref = map.getOrDefault(nb, null);
                    }
                    miror.neighbors.add(ref);
                    q.add(nb);
            }
             
                visited.put(curr, true);
            }
        }
        
      return clone;
        
        
        
    }

}
