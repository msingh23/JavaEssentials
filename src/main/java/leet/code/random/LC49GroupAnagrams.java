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
public class LC49GroupAnagrams {

	/*
	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> out = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String word : strs) {
			int[] freq = new int[26];
			for (int i = 0; i < word.length(); i++) {
				freq[word.charAt(i) - 'a'] += 1;
			}

			StringBuffer key = new StringBuffer("");

			for (int i = 0; i < 26; i++)
				key = key.append(freq[i]);

			if (!map.containsKey(key.toString()))
				map.put(key.toString(), new ArrayList<String>());
			map.get(key.toString()).add(word);

		}

		return new ArrayList<List<String>>(map.values());

	}
*/
	 public static List<List<String>> groupAnagrams(String[] strs) { 
		   int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z
		    
		            List<List<String>> res = new ArrayList<>();
		            HashMap<Integer, Integer> map = new HashMap<>();
		            for (String s : strs) {
		                int key = 1;
		                for (char c : s.toCharArray()) {
		                    key *= prime[c - 'a'];
		                }
		                List<String> t;
		                if (map.containsKey(key)) {
		                    t = res.get(map.get(key));
		                } else {
		                    t = new ArrayList<>();
		                    res.add(t);
		                    map.put(key, res.size() - 1);
		                }
		                t.add(s);
		            }
		            return res;
		    }
	
	
}
