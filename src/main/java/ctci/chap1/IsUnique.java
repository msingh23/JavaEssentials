/**
 * 
 */
package ctci.chap1;

/**
 * @author manu
 *
 */
public class IsUnique {

	public static boolean isUnique(String inp) {

		if (null == inp || inp.length() > 256)
			return false;

		// ASCII = 128; extended ASCII is 256 src http://www.asciitable.com/
		boolean[] check = new boolean[256];

		for (int i = 0; i < inp.length(); i++) {
			if (check[inp.charAt(i)])
				return false;
			check[inp.charAt(i)] = true;
		}

		return true;

	}

	public static boolean isUnique2(String inp){
		
		if(null==inp || inp.length() >26) return false;
		
		int bitVec = 0;
		
		for(int i = 0 ; i<inp.length(); i++){
			int val = inp.charAt(i)-'a';
			if( (bitVec &(1<<val)) > 0 ) return false;
			bitVec = bitVec | (1<<val);
		}
		
		return true;
	}
	
}
