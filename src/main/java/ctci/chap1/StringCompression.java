/**
 * 
 */
package ctci.chap1;

/**
 * @author manu
 *
 */
public class StringCompression {

	public static String Compression(String s) {

		if (null != s) {

			StringBuilder out = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				int count = 1;
				while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
					i++;
					count++;
				}
				out.append(s.charAt(i)).append(count);
				if (out.length() > s.length()) {
					return s;
				}

			}
			if (out.length() < s.length()) {
				return out.toString();
			}
		}
		return s;
	}

}
