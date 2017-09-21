/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC7ReverseInteger {

	
	 public int reverse(int x) {
	        
	        boolean negative = false;
	        if(x < 0) negative = true;
	        
	        x = Math.abs(x);
	        int rev = 0;
	        while(x>0)
	        {
	            
	            if(rev !=0 && (Integer.MAX_VALUE / rev ) < 10) return 0;
	            rev*=10;
	            rev +=  (x % 10);
	            x = x/10;
	            
	        }
	        
	        return !negative ? rev : -rev;
	        
	        
	    }
}
