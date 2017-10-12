/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC8StringtoIntegeratoi {

	 public int myAtoi(String str) {
	        
	        if(null == str || str.trim().length() ==0 )return 0;
	        String istr = str.trim();
	        int out = 0;
	        boolean neg = istr.charAt(0) == '-' ? true : false;
	        if(istr.charAt(0) == '-' || istr.charAt(0) == '+')
	            istr = istr.substring(1);
	        
	        for(Character ch : istr.toCharArray())
	        {
	            if(ch - '0' >=0 && ch - '0' <=9)
	            {
	                //check for overflow, underflow
	                if(!neg)
	                {
	                    if(Integer.MAX_VALUE / 10 < out  || out*10 > Integer.MAX_VALUE - (ch - '0'))
	                    {
	                        return Integer.MAX_VALUE;
	                    }
	                }else
	                {
	                    if(Integer.MIN_VALUE / 10 > -out || -out*10 <  Integer.MIN_VALUE + (ch - '0')  )
	                    {
	                        return Integer.MIN_VALUE;
	                    }
	                }
	                out*=10;
	                out+=(ch - '0');
	            }
	            else
	            {
	                break;
	            }
	        }
	           return neg ? -out : out; 
	    }
	
}
