/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC166FractiontoRecurringDecimal {

	public String fractionToDecimal(int num, int den) {
        StringBuffer buff = new StringBuffer();
        if (num == 0) {
            return "0";
        }
        boolean neg = (num> 0 ) ^ (den> 0 ) ? true : false;
        //System.out.println(neg);
        long numerator = Math.abs((long)num);
        long denominator = Math.abs((long)den);
        if(neg) buff.append("-");
        buff.append(numerator / denominator);
        numerator %= denominator;
        
        if(numerator == 0) 
            return buff.toString();
        buff.append(".");
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(numerator, buff.length());
        while(numerator>0)
        {
            numerator*=10;
            long q = numerator / denominator;
            long rem = numerator % denominator;
            buff.append(q);
            if(map.containsKey(rem))
            {
                //System.out.println(buff);
                buff.insert(map.get(rem), "(");
                buff.append(")");
                return buff.toString();
                
            }else
            {
                map.put(rem, buff.length());
            }
            numerator = rem;
        }
        return buff.toString();
    }
}
