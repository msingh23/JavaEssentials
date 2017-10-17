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

	/*
	public List<String> topKFrequent(String[] words, int k) {

		List<String> list = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
		}

		// System.out.println(map);

	
		/*
		 PriorityQueue<Object[]> pq = new PriorityQueue<Object[]>((a,b)-> {if((Integer)a[1]==(Integer)b[1])
             return ((String)b[0]).compareTo((String)a[0]);
         else 
             return (Integer)a[1] - (Integer)b[1];
          });
*/
	/*	
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
	*/
    class TrieNode
    {
        String word;
        TrieNode[] trie;
        TrieNode()
        {
            trie = new TrieNode[26];
            word = null;
        }
    }
     public List<String> topKFrequent(String[] words, int k) 
     {
         
         Map<String, Integer> map = new HashMap<String, Integer>();
         TrieNode [] bucket = new TrieNode[words.length+1];
         for(String word : words)
             map.put(word, map.getOrDefault(word, 0) +1);
         
         for(String key : map.keySet())
         {
             if(bucket[map.get(key)] == null)
                 bucket[map.get(key)] = new TrieNode();
             addWord(key, bucket[map.get(key)]);
         }
         
         List<String> list = new ArrayList<String>();
         for(int i = words.length; i>=0; i--)
         {
             if(bucket[i]!=null)
                 getWord(bucket[i], list, k);
         }
         return list;
     }
    
    public void getWord(TrieNode node, List<String> list, int k)
    {
        if(node.word!=null)
            list.add(node.word);
        
        if(list.size() == k)
            return;
        
        for(int i = 0; i <26 ; i++)
        {
            if(node.trie[i] != null)
                getWord(node.trie[i], list, k);
        }
        
    }
    
    public void addWord(String word, TrieNode node)
    {
        for(Character c : word.toCharArray())
        {
            if(node.trie[c-'a'] == null)
                node.trie[c-'a'] = new TrieNode();
            node= node.trie[c-'a'];
        }
        node.word = word;
        
    }

}
