/**
 * 
 */
package ctci.chap8;

import java.util.ArrayList;

/**
 * @author manu
 *
 */
public class Parens {

	public ArrayList<String> getParens(int number) {
		ArrayList<String> out = new ArrayList<String>();
		getParensHelper(number, 0, 0, out, new StringBuffer(""));
		return out;
	}

	private void getParensHelper(int number, int pos, int neg, ArrayList<String> out, StringBuffer prefix ) {
		
		if(pos == neg && pos == number){
			out.add(prefix.toString());
		}else{
			if(pos<number)
			{
				getParensHelper(number, pos+1, neg, out, prefix.append("("));
				prefix.deleteCharAt(prefix.length()-1);
			}
			if (neg< pos && neg<number){
				getParensHelper(number, pos, neg+1, out, prefix.append(")"));
				prefix.deleteCharAt(prefix.length()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		Parens par = new Parens();
		System.out.println(par.getParens(4));
	}

}
