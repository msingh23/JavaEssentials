package ctci.chap1;
/**
 * 
 */

/**
 * @author manu
 *
 */
public class OneEditDistanceString {

	public static boolean isOneDistanceAwayStrings(String s1, String s2) {

		if (null == s1 || null == s2 || Math.abs(s1.length() - s2.length()) > 2) {
			return false;
		}
		int edits = 0;
		int i = 0, j = 0;
		for (; i < s1.length() && j < s2.length(); i++, j++) {

			if (s1.charAt(i) != s2.charAt(j)) {

				switch (requiredEdit(s1, i, s2, j)) {
				case 1: {
					i--;
					edits++;
					break;
				}

				case 2: {
					j--;
					edits++;
					break;
				}

				case 3: {
					edits++;
					break;

				}
				case -1: {
					return false;
				}

				}

			}
			if (edits >= 2) {
				return false;
			}
		}

		return true;
	}

	private static int requiredEdit(String s1, int i, String s2, int j) {

		boolean next = false, i2j = false, j2i = false;
		if (i + 1 >= s1.length() && j + 1 > s2.length()) {
			return 3;
		}

		if (i + 1 >= s1.length()) {
			return 1;
		}

		if (j + 1 >= s2.length()) {
			return 2;
		}

		if (s1.charAt(i + 1) == s2.charAt(j + 1)) {
			next = true;
		}

		if (s1.charAt(i) == s2.charAt(j + 1)) {
			i2j = true;
		}

		if (s2.charAt(j) == s1.charAt(i + 1)) {
			j2i = true;
		}

		if (next && i2j) {
			if (s1.length() < s2.length()) {
				return 1;
			}
		}

		if (next && j2i) {
			if (s2.length() < s1.length()) {
				return 2;
			}
		}

		if (i2j) {
			return 1;
		}
		if (j2i) {
			return 2;
		}
		if (next) {
			return 3;
		}

		return -1;
	}

	public static boolean isOneDistanceAwayStrings2(String s1, String s2) {

		if (null == s1 || null == s2) {
			return false;
		}

		int i = 0, j = 0, count = 0;

		while (i < s1.length() && j < s2.length()) {

			if (s1.charAt(i) != s2.charAt(j)) {

				if (s1.length() != s2.length()) {

					if (s1.length() < s2.length()) {

						j++;
					} else {
						i++;
					}

				} else {
					i++;
					j++;
				}
				count++;
			} else {
				j++;
				i++;
			}

		}
		count = count + s1.length() - i + s2.length() - j;
		System.out.println(s1 + " :: " + s2 + " :: " + count);
		return count < 2;

	}

}
