/**
 * 
 */
package pramp;

/**
 * @author manu
 *
 */
public class BasicRegexParser {

	public boolean parse(String text, String pattern) {

		if (text != null && pattern != null) {
			return parseHelper(text, pattern, 0, 0);
		}
		return false;
	}

	public boolean parseHelper(String t, String p , int t1, int p1){
		
		//check the lengths first:: base case
		if(t1 >= t.length() ){
			
			if(p1 >= p.length() ) return true;
			
			else
				if(p1 + 1 < p.length() && p.charAt(p1+1) == '*'){
					return parseHelper(t, p, t1, p1+2);
				}
				else return false;
		}
		
		if(p1 >= p.length() && t1< t.length()) return false;
		
		if(p1+1 < p.length() && p.charAt(p1+1)=='*' ){
			
			if(p.charAt(p1) == '.' || p.charAt(p1) == t.charAt(t1)){
				return parseHelper(t, p, t1+1, p1) || parseHelper(t, p, t1, p1+2);
			}else{
				return parseHelper(t, p, t1, p1+2);
			}
		}else if(p.charAt(p1) == '.' || p.charAt(p1) == t.charAt(t1)){
			return parseHelper(t, p, t1+1, p1+1);
		}else{
			return false;
		}
		
	}

}
