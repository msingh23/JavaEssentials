/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC347TopKFrequentElements {

	
	/*
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
    */
	
	 public static List<Integer> topKFrequent(int[] nums, int k) {
	        List<Integer>[] buck = new List[nums.length+1];
	        List<Integer> out = new ArrayList<Integer>();
	         Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
	         for(int n : nums)
	        {
	            freq.put(n , freq.getOrDefault(n, 0)+1);
	                
	        }
	        
	         for(Integer key : freq.keySet())
	        {
	            int count = freq.get(key);
	             if(buck[count]==null)
	                  buck[count] = new ArrayList<>(); 
	             buck[count].add(key);
	             
	        }
	        
	        for(int i = nums.length;i>=0 ;i --)
	        {
	            if(buck[i]!=null )
	            {
	                for(Integer key : buck[i])
	                {
	                    if(out.size() == k) break;
	                    out.add(key);
	                }
	            }
	        }
	        
	        return out;
	        
	    }
	 
	 public static void main(String[] args) {
		System.out.println(topKFrequent(new int []{1,1,1,2,2,3}, 2));
	}
}
