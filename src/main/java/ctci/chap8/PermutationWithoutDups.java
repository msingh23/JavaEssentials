/**
 * 
 */
package ctci.chap8;

import java.util.ArrayList;

/**
 * @author manu
 *
 */
public class PermutationWithoutDups {

	/*
	 * 
	 * helo
	 * 
	 * 
	 * [o] 
	 * [l,o], [o,l] 
	 * [e,l,o],[l,e,o],[l,o,e],[e,o,l], [o,e,l], [o,l,e]
	 * 
	 * 
	 * 
	 */

	public ArrayList<String> getAllPermutations(String str) {
		ArrayList<String> out = new ArrayList<String>();
		StringBuffer buff = new StringBuffer();
		out = getAllPermutationsHelper(str, 0);

		return out;
	}

	private ArrayList<String> getAllPermutationsHelper(String str, int i) {
		ArrayList<String> list = new ArrayList<String>();
		if (i == str.length() - 1) {
			list.add(String.valueOf(str.charAt(i)));
			return list;
		}
		
		ArrayList<String> prevList = getAllPermutationsHelper(str, i+1);
		if(prevList!=null){
			
			for(String prevString : prevList)
			{
				for(int j = 0 ; j <= prevString.length() ; j++ )
				{
					StringBuffer buff = new StringBuffer();
					int lstart = 0;
					int lend = j-1;
					int rstart= j;
					int rend = prevString.length()-1;
					if(lstart<=lend){
						buff.append(prevString.substring(lstart, lend+1));
					}
					buff.append(str.charAt(i));
					if(rstart<=rend){
						buff.append(prevString.substring(rstart, rend+1));
					}
					list.add(buff.toString());
				}
				
			}
		}
		return list;
	}

	private void getAllPermutationsHelper(String str, ArrayList<String> out, StringBuffer buff, int index) {

		if (buff.length() == str.length()) {
			out.add(buff.toString());
		}
		if (index >= str.length()) {
			return;
		}

		for (int i = index; i < str.length(); i++) {

			buff.append(str.charAt(index));
			getAllPermutationsHelper(str, out, buff, i + 1);
			buff.deleteCharAt(buff.length() - 1);

		}

	}
	
	public ArrayList<String> getPerm(String str)
	{
		ArrayList<String> out = new ArrayList<String>();
		if(str=="" || str.length()==0)
		{
			out.add("");
			return out;
		}
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			String prefix = str.substring(0, i);
			String mid = str.substring(i,i+1);
			String suffix = str.substring(i+1);
			ArrayList<String> prevPerm = getPerm(prefix+suffix);
			for(String st : prevPerm)
			{
				out.add(mid+st);
			}
		}
		return out;
	}
	
	public ArrayList<String> getPermTopDown(String inp)
	{
		ArrayList<String> out = new ArrayList<String>();
		getPermTopDownHelper(inp, out, new StringBuffer(""), inp.length());
		return out;
	}

	private void getPermTopDownHelper(String inp, ArrayList<String> out, StringBuffer prefix, int length) {
		
		if(prefix.length() ==length)
		{
			out.add(prefix.toString());
		}else{
			for(int i = 0 ; i<inp.length(); i++)
			{
				String pre = inp.substring(0, i);
				String mid = inp.substring(i,i+1);
				String end = inp.substring(i+1);
				getPermTopDownHelper(pre+end, out, prefix.append(mid), length);
				prefix.deleteCharAt(prefix.length()-1);
			}
		}
		
		
	}

	public static void main(String[] args) {
		PermutationWithoutDups perm = new PermutationWithoutDups();
		System.out.println(perm.getAllPermutations("hel"));
		System.out.println(perm.getPerm("hel"));
		System.out.println(perm.getPermTopDown("hel"));
		
	}
}
