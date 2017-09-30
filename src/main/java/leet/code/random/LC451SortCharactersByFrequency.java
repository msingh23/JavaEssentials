/**
 * 
 */
package leet.code.random;

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
        
        
        // int [] upper = new int [26];
        // int [] lower = new int [26];
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
       
        /*
        for(Character ch  : s.toCharArray())
        {
            if(ch>=65  && ch<=90)
                upper[ch-'A']++;
            if(ch>=97 && ch<=122)
                lower[ch-'a']++;
        }
       
        for(int i = 0; i < 26; i++)
        {
            if(upper[i] > 0)
                pq.add(new Object[]{'A' + i, upper[i]});
            if(lower[i] > 0)
                pq.add(new Object[]{'a' + i, lower[i]});
        }
        */
        
        Set<Character> keys = map.keySet();
        for(Character key : keys)
             pq.add(new Object[]{key, map.get(key)});
        /*
        Iterator< Character> iter = keys.iterator();
        
        while(iter.hasNext())
        {
            char key = iter.next();
            pq.add(new Object[]{key, map.get(key)});
        }
        */
        
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

}
