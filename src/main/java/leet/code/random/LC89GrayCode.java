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
public class LC89GrayCode {

	  public List<Integer> grayCode(int n) {
	        
	        List<Integer> out = new ArrayList<Integer>();
	        out.add(0);
	        for(int i = 0; i<n; i++)
	        {
	            int mask = 1<<i;
	            for(int j = out.size()-1 ; j>=0; j--)
	            {
	                out.add(mask | out.get(j));
	            }
	        }
	        return out;
	    }
}
