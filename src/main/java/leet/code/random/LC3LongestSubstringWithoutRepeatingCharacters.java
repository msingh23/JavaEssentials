/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC3LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String max = "";
		int i = 0;
		int j = 0;

		while (j < s.length()) {
			Character ch = s.charAt(j);
			int idxSeen = map.getOrDefault(ch, -1);
			if (idxSeen == -1 || idxSeen < i) {
				map.put(ch, j);
			} else {
				i = idxSeen + 1;
				map.put(ch, j);
			}

			if ((j - i + 1) > max.length())
				max = s.substring(i, j + 1);
			j++;
		}
		// System.out.println(max);
		return max.length();

	}
}
