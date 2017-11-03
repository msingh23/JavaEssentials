/**
 * 
 */
package leet.code.random;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author manu
 *
 */
public class LC179LargestNumber {

	public String largestNumber(int[] nums) {
        StringBuffer buff = new StringBuffer();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            
            public int compare(Integer i1, Integer i2)
            {
                String s1 = String.valueOf(i1);
                String s2 = String.valueOf(i2);
                
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        for(Integer i : nums)
        {
            pq.add(i);
        }
        
        while(!pq.isEmpty())
        {
            int val = pq.poll();
            if(buff.length()!=0)
            {
                int lastVal =Integer.parseInt(buff.substring(0,1));
                //System.out.println(val + " " + lastVal);
                if(lastVal == val  && val ==0) continue;
            }
            buff.append(val);
        }
        return buff.toString();
    }
}
