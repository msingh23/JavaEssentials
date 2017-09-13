/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC210CourseScheduleII {

	 public void print( List<List<Integer>> graph)
	    {
	        for(List<Integer> l :graph )
	        {
	            System.out.println();
	            for(Integer i : l)
	                System.out.print(i);
	        }
	    }
	    
	    public void printMap(Map<Integer, Set<Integer>> out)
	    {
	        for (Map.Entry<Integer, Set<Integer>> entry : out.entrySet()) 
	        {
	            Integer key = entry.getKey();
	            Set<Integer> value = entry.getValue();
	            System.out.println(key + " "+value);
	        }
	    }
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	        
	        List<List<Integer>> graph = new ArrayList<List<Integer>>();
	        Map<Integer,Set<Integer>> in = new HashMap<Integer, Set<Integer>>();
	        Map<Integer,Set<Integer>> out = new HashMap<Integer, Set<Integer>>();
	        ArrayList<Integer> ans = new ArrayList<Integer>();
	        for(int i =0; i<numCourses; i++)
	        {
	            in.put(i, new HashSet<Integer>());
	            out.put(i, new HashSet<Integer>());
	        }
	         
	        for(int i = 0; i<prerequisites.length; i++)
	        {
	            int e1 = prerequisites[i][0];
	            int e2 = prerequisites[i][1];
	            in.get(e2).add(e1);
	            out.get(e1).add(e2);
	            //graph.get(e2).add(e1);
	            //print(graph);
	        }
	         // printMap(out);
	         // System.out.println();
	         // printMap(in);
	        List<Integer> leaves = new ArrayList<Integer>();
	        
	        //for(List<Integer> l : graph) if(l.size()==1) leaves.add(l.get(0));
	        for (Map.Entry<Integer, Set<Integer>> entry : out.entrySet()) 
	        {
	            Integer key = entry.getKey();
	            Set<Integer> value = entry.getValue();
	            if(value == null || value.size()==0) leaves.add(key);
	        }
	            
	       
	        
	        while(leaves.size()>0)
	        {
	            List<Integer> _leaves = new ArrayList<Integer>();
	            for(Integer i : leaves)
	            {
	               // System.out.println(i);
	                ans.add(i);
	                
	               Set<Integer> edges = in.get(i);
	               for(Integer j : edges)
	               {
	                   out.get(j).remove(i);
	                   if(out.get(j) == null || out.get(j).size() ==0 ) _leaves.add(j);
	               }
	                out.remove(i);
	            }
	            leaves = _leaves;
	        }
	      // System.out.println(ans);
	        return (out.size() == 0 ? ans.stream().mapToInt(i -> i).toArray() : new int []{});
	        //return ans.stream().mapToInt(i -> i).toArray();
	    }
}
