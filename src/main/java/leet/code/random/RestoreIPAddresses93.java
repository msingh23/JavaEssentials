/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manu
 *
 */


public class RestoreIPAddresses93 {

	/*
	0(2^n)
	List<String> ans = new ArrayList<String>();

	public List<String> restoreIpAddresses(String s) {

		if (s != null && s.length() > 3 && s.length() < 13) {

			int n = s.length();

			getIp(s, 0, new StringBuffer(), n, 0, "", ans);

		}
		System.out.println(ans);
		return ans;

	}

	public void getIp(String s, int start, StringBuffer buff, int len, int dots, String domain, List<String> out) {

		if (dots == 3 && buff.charAt(buff.length() - 1) != '.' && buff.length() == s.length() + 3) {
			out.add(buff.toString());
			// System.out.println(buff);
			// check if the ip is valid
			return;
		}

		for (int i = start; i < len; i++) {

			String digit = (s.substring(i, i + 1));
			buff.append(digit);
			if (Integer.valueOf(domain + digit) <= 255 && ((domain.equals("") || false)  || Integer.valueOf(domain + digit) > Integer.valueOf(digit))) {

				if (dots < 3) {
					getIp(s, i + 1, buff.append("."), len, dots + 1, "", out);
					buff.deleteCharAt(buff.length() - 1);
				}
				getIp(s, i + 1, buff, len, dots, domain + digit, out);

			}
			buff.deleteCharAt(buff.length() - 1);

			

		}

	}
	
	*/

	public static void main(String[] args) {
		RestoreIPAddresses93 ip = new RestoreIPAddresses93();
		//ip.restoreIpAddresses("686431045685");
	}
}
