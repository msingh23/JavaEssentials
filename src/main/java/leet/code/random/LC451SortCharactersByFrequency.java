/**
 * 
 */
package leet.code.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC451SortCharactersByFrequency {
	
	 public String frequencySort(String s) {
	        
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        PriorityQueue<Object []> pq = new PriorityQueue<Object[]>( (o1, o2) -> (int)o2[1] - (int) o1[1] );
	        for(Character ch  : s.toCharArray())
	        {
	            if(!map.containsKey(ch))
	            {
	                map.put(ch, 0);
	            }
	            
	            map.put(ch, map.get(ch)+1);
	        }
	       
	        Set<Character> keys = map.keySet();
	        for(Character key : keys)
	             pq.add(new Object[]{key, map.get(key)});
	        
	        char [] out = new char [s.length()];
	        int i = 0;
	        while(!pq.isEmpty())
	        {
	            Object[] obj = pq.poll();
	            Character ch = (Character) obj[0];
	            int count  = (int) obj[1];
	            
	            while(count>0)
	            {
	                out[i++] = (char) ch;
	                count--;
	            }
	        }
	        
	        return new String(out);
	    }
	 
     public String frequencySort2(String s) 
     {
         int [] freq = new int [256];
         Arrays.fill(freq, 0);
         int maxBucket = 0;
         for(Character ch : s.toCharArray())
         {
             freq[ch]++;
             maxBucket = Math.max(freq[ch], maxBucket);
         }
         StringBuffer bucket [] = new StringBuffer [maxBucket+1];
         
         for(int i = 0 ;i < 256; i++)
         {
             if(freq[i] > 0)
             {
                 char ch = (char) i;
                 bucket[freq[i]] = bucket[freq[i]] == null ? new StringBuffer(String.valueOf(ch)) : bucket[freq[i]].append(String.valueOf(ch));
             }
         }
         int j = 0;
         char [] out = new char[ s.length() ];
         
         for(int i = maxBucket; i>0 ; i--)
         {
             if(bucket[i] == null ) continue;
             
             for(Character ch : bucket[i].toString().toCharArray())
             {
                 int count = i;
                 while(count-- > 0)
                 {
                     out[j++] = ch;
                 }
             }
         }
         return new String(out);
     }

}
