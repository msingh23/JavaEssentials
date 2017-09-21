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
public class LC22GenerateParentheses {

	 public List<String> generateParenthesis(int n) {
	        
	        List<String> out = new ArrayList<String>();
	        StringBuffer buff = new StringBuffer();
	        
	        generateParenthesisHelper(n , n, buff, out );
	        return out;
	        
	    }
	    
	    public void generateParenthesisHelper(int even, int odd, StringBuffer buff, List<String> out)
	    {
	        if(even<0 || odd <0 ) return;
	        if(even ==0 && odd == 0)
	        {
	            out.add(buff.toString());
	            return;
	        }
	        if(even>0)
	        {
	            buff.append("(");
	            generateParenthesisHelper(even -1, odd, buff, out);
	            buff.deleteCharAt(buff.length()-1);
	        }
	        if(odd>even)
	        {
	            buff.append(")");
	            generateParenthesisHelper(even, odd -1, buff, out);
	            buff.deleteCharAt(buff.length()-1);
	        }
	    }
}
