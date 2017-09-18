/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC161OneEditDistance {

	public boolean isOneEditDistance(String s, String t) {

		// if(s.length() == 0 && t.length() ==0 ) return false;
		if (s.length() < t.length())
			return isOneEditDistance(t, s);

		int diff = s.length() - t.length();
		if (diff > 1)
			return false;

		int s1 = 0, t1 = 0;
		boolean first = true;

		while (s1 < s.length() && t1 < t.length()) {
			if (s.charAt(s1) != t.charAt(t1)) {
				if (!first)
					return false;
				if (diff == 0)
					t1++;
				s1++;
				first = false;
			} else {
				s1++;
				t1++;
			}
		}

		if (s1 < s.length() && first)
			return true;
		return !first && true;

	}
}
