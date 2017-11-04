/**
 * 
 */
package leet.code.random;

import java.util.HashSet;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC260SingleNumberIII {

	/*
	public int[] singleNumber(int[] nums) {
	     
        Set<Integer> set = new HashSet<Integer>();
        for(Integer n : nums)
        {
            if(set.contains(n)) set.remove(n);
            else set.add(n);
        }
        
        int [] out = new int [2];
        int i =0;
        for(Integer z : set)
            out[i++] = z;
        return out;
    }
	*/
	public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        for(Integer n : nums)
            xor^=n;
        //get last set bit
        xor&=-xor;
        int n1 = 0;
        int n2 = 0;
        for(Integer n : nums)
        {
            //we can only check if the bit is not set. if bit is set the value can't just be 1 it can be 1, 2, 4, 8 etc
            if((n & xor) == 0)
                n1 ^=n;
            else
                n2^=n;
        }
        return new int []{n1, n2};
    }
}
