/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC126WordLadderII {
	 public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	        
	        Set<String> set = new HashSet<String>(wordList);
	        Map<String, List<String>> neigh = new HashMap<String, List<String>>();
	        Map<String, Integer> distance = new HashMap<String, Integer>();
	        List<List<String>> out= new ArrayList<List<String>>();
	        
	        Queue<String> q = new LinkedList<String>();
	        q.add(beginWord);
	        distance.put(beginWord, 0);
	        Boolean found = false;
	        
	        while(!q.isEmpty())
	        {
	         int count =  q.size();   
	            for(int i = 0 ;i < count; i++)
	            {
	                String curr = q.poll();
	                 System.out.println(curr);
	                List<String> n = getNeigh(curr,set);
	                neigh.put(curr, new ArrayList<String>());
	                for(String ns : n)
	                {
	                    neigh.get(curr).add(ns);
	                    if(!distance.containsKey(ns))
	                    {
	                        distance.put(ns, distance.get(curr) + 1);
	                         if(ns.equals(endWord))
	                        {
	                            found = true;
	                        }else
	                            q.add(ns);
	                    }
	                }
	            }
	            if(found) break;
	        }
	        DFS(beginWord, endWord, neigh, distance, out, new ArrayList<String>());
	        return out;
	    }
	    public void DFS(String beginWord, String endWord, Map<String, List<String>> neigh, Map<String, Integer>distance, List<List<String>>out, List<String> curr)
	    {
	        curr.add(beginWord);
	        if(beginWord.equals(endWord))
	        {
	            out.add(new ArrayList<String>(curr));
	            return;
	        }
	        if(neigh.get(beginWord) == null) return;
	        for(String ns : neigh.get(beginWord))
	        {
	            if(distance.get(ns) == distance.get(beginWord)+1)
	            {
	                DFS(ns, endWord, neigh, distance, out, curr);
	               curr.remove(curr.size()-1);
	            }
	        }
	    }
	    
	    public List<String> getNeigh(String curr, Set<String> set)
	    {
	        List<String> n = new ArrayList<String>();
	        for(int i = 0; i < curr.length(); i++)
	        {
	            for(char c  = 'a'; c <= 'z'; c++)
	            {
	                StringBuffer buff = new StringBuffer(curr);
	                if(c!=buff.charAt(i))
	                {
	                    buff.setCharAt(i, c);
	                    if(set.contains(buff.toString()))
	                    {
	                        n.add(buff.toString());
	                    }
	                }
	            }
	        }
	        return n;
	        
	    }
}
