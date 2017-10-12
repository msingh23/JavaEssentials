/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC29DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        long divd = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);
        if(dividend == 0 || divs > divd) return 0;
        boolean neg = (dividend < 0 && divisor > 0 ) || (dividend > 0 && divisor < 0 ) ? true : false;
        
        long q =0;
        long m = 1;
        long start = divs;
        
        while(divd >= start)
        {
           
            if(divs<=divd)
            {
                divs = divs<<1;
                m = m<<1;
                
            }else
            {
                while(divs >divd)
                {
                    m = m >>1;
                    divs = divs >>1;
                }
                divd = divd - divs;
                q+=m;
            }
        }
        
        return q>Integer.MAX_VALUE ? (neg ? Integer.MIN_VALUE : Integer.MAX_VALUE) : (neg ? -(int)q: (int)q) ;
        
    }
}
