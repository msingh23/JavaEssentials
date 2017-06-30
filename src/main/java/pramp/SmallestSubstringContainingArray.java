/**
 * 
 */
package pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manu
 *
 */
public class SmallestSubstringContainingArray {

	public String getSmallestSubString(String inp, Character[] arr) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int tail = 0, start = 0;
		int unique = 0;
		String res = "";

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], 0);
		}

		for (; tail < inp.length(); tail++) {

			int count = map.getOrDefault(inp.charAt(tail), -1);
			if (count >= 0) {
				if (count == 0)
					unique++;
				map.put(inp.charAt(tail), count + 1);
			}

			while (unique == arr.length) {
				int frequency = map.getOrDefault(inp.charAt(start), -1);
				if (frequency > 1) {
					map.put(inp.charAt(start), frequency - 1);

				} else if (frequency == 1) {
					break;
				}
				start++;
			}

			String shrink = inp.substring(start, tail + 1);

			if (unique == arr.length && (res.equalsIgnoreCase("") || res.length() > shrink.length())) {
				res = shrink;
			}
		}

		return res;

	}

}
