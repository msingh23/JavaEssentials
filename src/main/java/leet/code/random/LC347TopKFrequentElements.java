/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author manu
 *
 */
public class LC347TopKFrequentElements {

	
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        List<Integer> out = new ArrayList<Integer>();
        PriorityQueue<int []> pq = new PriorityQueue<int[]>((a, b)->a[0]-b[0]);
        for(int n : nums)
        {
            freq.put(n , freq.getOrDefault(n, 0)+1);
                
        }
        
        for(Integer key : freq.keySet())
        {
            if(pq.size() >k) pq.poll();
            pq.add(new int []{freq.get(key), key});
        }
        
        if(pq.size() > k) pq.poll();
        while(!pq.isEmpty())
        {
            out.add(pq.poll()[1]);
        }
        return  out;
    }
}
