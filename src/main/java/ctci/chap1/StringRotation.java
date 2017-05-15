/**
 * 
 */
package ctci.chap1;

/**
 * @author manu
 *
 */
public class StringRotation {

	public static boolean isStringRotate(String s1, String s2) {

		if (null == s1 || null == s2 || s1.length() != s2.length() || s1.length() == 0 || s2.length() == 0) {
			return false;
		}

		String s1s1 = s1 + s1;

		return isSubstring(s1s1, s2);

	}

	private static boolean isSubstring(String s1s1, String s2) {

		for (int i = 0, j = 0; i < s1s1.length(); i++) {

			if (s1s1.charAt(i) == s2.charAt(j)) {
				j++;
				if (j == s2.length()) {
					return true;
				}
			} else {
				j = 0;
			}

		}

		return false;
	}

}
