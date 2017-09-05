/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC10RegularExpressionMatching {

	public boolean isMatch(String s, String p) {

		int ss = 0, ps = 0, se = s.length(), pe = p.length();

		return isMatch(s, ss, se, p, ps, pe);
		// return true;
	}

	public boolean isMatch(String s, int ss, int se, String p, int ps, int pe) {
		if (ss >= se) {
			if (ps >= pe) {
				return true;
			} else if (ps + 1 < pe && p.charAt(ps + 1) == '*') {
				return isMatch(s, ss, se, p, ps + 2, pe);
			} else {
				return false;
			}

		} else if (ps >= pe)
			return false;

		if (s.charAt(ss) != p.charAt(ps)) {
			if (p.charAt(ps) == '.') {
				if (ps + 1 < pe && p.charAt(ps + 1) == '*') {
					return isMatch(s, ss + 1, se, p, ps, pe) || isMatch(s, ss, se, p, ps + 2, pe);
				} else {
					return isMatch(s, ss + 1, se, p, ps + 1, pe);
				}

			} else {

				if (ps + 1 < pe && p.charAt(ps + 1) == '*') {
					return isMatch(s, ss, se, p, ps + 2, pe);
				} else {
					return false;
				}
			}
		} else {

			if (ps + 1 < pe && p.charAt(ps + 1) == '*') {
				return isMatch(s, ss + 1, se, p, ps, pe) || isMatch(s, ss, se, p, ps + 2, pe);
			} else {
				return isMatch(s, ss + 1, se, p, ps + 1, pe);
			}

		}

	}
}
