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

}
