/**
 * 
 */
package ctci.chap8;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author manu
 *
 */
public class PermutationWithDups {

	public ArrayList<String> getPerm(String inp)
	{
		HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
		ArrayList<String> out = new ArrayList<String>();
		generateMap(inp, mp);
		getPermHelper(inp, mp, out,"", inp.length());
		return out;
	}

	private void getPermHelper(String inp, HashMap<Character, Integer> mp, ArrayList<String> out, String prefix, int length) {

		if(length==prefix.length())
		{
			out.add(prefix);
			
		}else{
			
			for(Character keys: mp.keySet())
			{
				int count = mp.getOrDefault(keys, 0);
				
				if(count>0)
				{
					mp.put(keys, count-1);
					getPermHelper(inp, mp, out, prefix + keys, length);
					mp.put(keys, count);
				}
			}
		}
		
		
		
	}

	private void generateMap(String inp, HashMap<Character, Integer> mp) {

		for(int i = 0 ; i <inp.length() ; i++)
		{
			int count = mp.getOrDefault(inp.charAt(i), 0);
			mp.put(inp.charAt(i), count+1);
		}
	}
	public static void main(String[] args) {
		PermutationWithDups perm = new PermutationWithDups();
		
		System.out.println(perm.getPerm("aabbc"));
		
	}
	
}
