/**
 * 
 */
package ctci.chap1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author manu
 *
 */
public class StringPermutationOfOther {

	public static boolean isPermutationOfOther(String inp1, String inp2) {

		if (null == inp1 || null == inp2 || inp1.length() != inp2.length())
			return false;

		char[] one = inp1.toCharArray();
		char[] two = inp2.toCharArray();

		Arrays.sort(one);
		Arrays.sort(two);

		for (int i = 0; i < one.length; i++) {
			if (one[i] != two[i])
				return false;
		}
		return true;
	}

	public static boolean isPermutationOfOther2(String inp1, String inp2) {
		if (null == inp1 || null == inp2 || inp1.length() != inp2.length())
			return false;

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < inp1.length(); i++) {
			if (map.get(inp1.charAt(i)) == null) {
				map.put(inp1.charAt(i), 1);
			} else {
				
				map.put(inp1.charAt(i), map.get(inp1.charAt(i))+1);
			}

			if (map.get(inp2.charAt(i)) == null) {
				map.put(inp2.charAt(i), -1);
			} else {
				map.put(inp2.charAt(i), map.get(inp2.charAt(i)) - 1);
			}
		}

		Set<Character> key = map.keySet();
		Iterator<Character> iter = key.iterator();
		while (iter.hasNext()) {
			if (map.get(iter.next()) != 0)
				return false;
		}
		return true;
	}
}
