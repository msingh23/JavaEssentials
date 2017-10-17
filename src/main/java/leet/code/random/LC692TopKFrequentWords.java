/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC692TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {

		List<String> list = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
		}

		// System.out.println(map);

		PriorityQueue<Object[]> pq = new PriorityQueue<Object[]>((a, b) -> (Integer) a[1] == (Integer) b[1]
				? ((String) b[0]).compareTo((String) a[0]) : (Integer) a[1] - (Integer) b[1]);

		/*
		 PriorityQueue<Object[]> pq = new PriorityQueue<Object[]>((a,b)-> {if((Integer)a[1]==(Integer)b[1])
             return ((String)b[0]).compareTo((String)a[0]);
         else 
             return (Integer)a[1] - (Integer)b[1];
          });
*/
		
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		for (Map.Entry<String, Integer> e : entry) {
			if (pq.size() > k)
				pq.poll();
			pq.add(new Object[] { e.getKey(), e.getValue() });
		}

		if (pq.size() > k)
			pq.poll();

		while (!pq.isEmpty()) {
			list.add(0, String.valueOf(pq.poll()[0]));
		}
		return list;
	}

}
