/**
 * 
 */
package ctci.chap1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author manu
 *
 */
public class PalindromePerm {

	public static boolean isPalindromePerm(String inp) {

		if (null != inp) {
			int countOfCharacter = 0;
			inp = inp.toLowerCase();
			Map<Character, Integer> mp = new HashMap<Character, Integer>();

			for (int i = 0; i < inp.length(); i++) {

				if (inp.charAt(i) == ' ') {
					continue;
				}

				if (mp.get(inp.charAt(i)) == null) {

					mp.put(inp.charAt(i), 1);
				} else {
					mp.put(inp.charAt(i), mp.get(inp.charAt(i)) + 1);
				}
				countOfCharacter++;

			}

			Set<Character> keys = mp.keySet();
			Iterator iter = keys.iterator();
			int count = 0;

			while (iter.hasNext()) {

				if (mp.get(iter.next()) % 2 != 0) {

					if ((countOfCharacter % 2 != 0) && count < 2) {
						count++;
					} else {
						return false;
					}

				}

			}

		}
		return true;

	}

	public static boolean isPalindromePerm2(String inp) {

		if (null != inp) {

			int vec = 0;
			for (int i = 0; i < inp.length(); i++) {

				if (checkRange(inp.charAt(i), true, true, false)) {

					int mask = 0;
					if ((inp.charAt(i) - 'A') > 26) {
						mask = (inp.charAt(i) - 'a');
					}
					if (((inp.charAt(i) - 'A') <= 26) && ((inp.charAt(i) - 'A') >= 0)) {
						mask = (inp.charAt(i) - 'A');
					}

					if (((1 << mask) & vec) > 0) {
						vec = vec & (~(1 << mask));
					} else {

						vec = vec | (1 << mask);
					}

				}

			}

			return ((vec & (vec - 1)) == 0);

		}
		return false;

	}

	private static boolean checkRange(char character, boolean isLowerRange, boolean IsUpperRange,
			boolean isOtherASCIIRange) {
		boolean result = false;
		// TODO Auto-generated method stub
		if (isLowerRange) {
			if (character >= 'a' && character <= 'z') {
				result = true;
			}
		}

		if (IsUpperRange) {
			if (character >= 'A' && character <= 'Z') {
				result = true;
			}
		}
		return result;
	}

}
