/**
 * 
 */
package ctci.chap1;

/**
 * @author manu
 *
 */
public class URLifyString {

	public static char[] replaceInString(char[] inp, int len) {
		if (null != inp) {
			int spaces = 0;
			for (int i = 0; i < len; i++) {
				if (inp[i] == ' ')
					spaces++;
			}
			String pattern = "%20";
			int current = len + ((pattern.length() - 1) * spaces);
			if (current < inp.length) {

				inp[current] = '\0';

			}
			current--;
			for (int i = len - 1; i >= 0; i--) {
				if (inp[i] == ' ') {
					replace(inp, current, pattern, true);
					current -= pattern.length();
				} else {
					replace(inp, current, String.valueOf(inp[i]), true);
					current--;
				}
			}
		}
		return String.valueOf(inp).trim().toCharArray();
	}

	private static void replace(char[] inp, int current, String pattern, boolean reverse) {

		if (reverse) {

			for (int i = pattern.length() - 1; i >= 0; i--) {
				inp[current--] = pattern.charAt(i);
			}

		}

	}

}
