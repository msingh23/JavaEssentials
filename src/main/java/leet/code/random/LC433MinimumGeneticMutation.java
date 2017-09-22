/**
 * 
 */
package leet.code.random;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC433MinimumGeneticMutation {

	public int minMutation(String start, String end, String[] bank) {
	       Set<String> set = new HashSet<String>();
	        Set<Character> gen = new HashSet<Character>();
	        gen.add('A'); gen.add('C'); gen.add('G'); gen.add('T');
	        for(String str : bank) set.add(str);
	        Queue<String> q = new LinkedList<String>();
	        Queue<Integer> count = new LinkedList<Integer>();
	        count.add(0);
	        q.add(start);
	        //int mutate = 0;
	        while(!q.isEmpty())
	        {
	            String parent = q.poll();
	            int mutate = count.poll();
	            //System.out.println(parent);
	            if(parent.equals(end)) return mutate;
	            for(Character g : gen)
	            {
	                char [] arr = parent.toCharArray();
	                for(int i = 0 ;i < arr.length; i++)
	                {
	                    if(arr[i]!=g)
	                    {
	                        char temp = arr[i];
	                        arr[i]=g;
	                        if(set.contains(String.valueOf(arr) ))
	                        {
	                            q.add(String.valueOf(arr));
	                            count.add(mutate+1);
	                            set.remove(String.valueOf(arr));
	                        }
	                        arr[i] = temp;
	                    }
	                }
	                //System.out.println(g);
	            }
	            
	        }
	        
	        return -1;
	        
	    }
	
}
