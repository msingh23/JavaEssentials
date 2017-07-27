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
	 * n!
	 * */
	public List<String> restoreIpAddresses2(String s) {

		if (s != null && s.length() > 3 && s.length() < 13) {

			int n = s.length();

			getIp(s, 0, new StringBuffer(), n, 0, "", ans);

		}
		System.out.println(ans);
		return ans;

	}

	public void getIp(String s, int start, StringBuffer buff, int len, int dots, String domain, List<String> out) {

		if (dots == 3 && buff.charAt(buff.length()-1)!='.' && buff.length()==s.length()+3) {
			out.add(buff.toString());
			return;
		}

		for (int i = start; i < len; i++) {

			String digit = (s.substring(i, i + 1));
			buff.append(digit);
			if (Integer.valueOf(domain + digit) <= 255 && ( (domain.equals("") || false)  || Integer.valueOf(domain + digit) > Integer.valueOf(digit)) ) {


				if (dots < 3) {
					getIp(s, i + 1, buff.append("."), len, dots + 1, "", out);
					buff.deleteCharAt(buff.length() - 1);
				}
				getIp(s, i + 1, buff, len, dots, domain + digit, out);

			}
			buff.deleteCharAt(buff.length() - 1);
		}

	}
   
	List<String> ans = new ArrayList<String>();

	/*
	 * 
	 * 0(3^4)
	 */
	
	public List<String> restoreIpAddresses(String s) {

		if (s.length() <= 12 && s.length() > 3)
			restoreIpAddressesHelper(s, ans, "", 0, 0);
		System.out.println(ans);
		return ans;

	}

	public void restoreIpAddressesHelper(String s, List<String> out, String curr, int index, int count) {
		
		if(count>4){
			return;
		}
		
		if (!curr.endsWith(".") && curr.length() == s.length() + 3) {
			out.add(curr.toString());
		}

		for (int i = 1; i < 4; i++) {
			if (index + i > s.length())
				break;
			String str = s.substring(index, index + i);
			Integer val = Integer.valueOf(str);
			if (str.startsWith("0") && str.length()>1  || val >= 256 )
				break;
			restoreIpAddressesHelper(s, out, curr + str + (count >= 3 ? "" : "."), index + i, count + 1);

		}

	}

	public static void main(String[] args) {
		RestoreIPAddresses93 ip = new RestoreIPAddresses93();
		//ip.restoreIpAddresses2("25525511135");
		ip.restoreIpAddresses("0000");
	}
}
