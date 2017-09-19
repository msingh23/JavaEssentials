/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author manu
 *
 */
public class LC340LongestSubstringwithAtMostKDistinctCharacters {

	 public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        
	        int n = s.length();
	        int start = 0;
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        TreeMap<Integer, Character> mapRev = new TreeMap<Integer, Character>();
	        int max = 0;
	        int curr = 0;
	        
	        if(k ==0) return 0;
	        /*
	        char minkey = 'z';
	        int minIndex = Integer.MAX_VALUE;
	        int minIndex2 = Integer.MAX_VALUE;
	        */
	    
	    
	        while(curr < n)
	        {
	            char c = s.charAt(curr);
	            if(!map.containsKey(c))
	            {
	                if(map.size()==k)
	                {
	                    //start = updateMap(map) +1;
	                    //start = minIndex +1;
	                    //map.remove(minkey);
	                    start  = mapRev.firstKey() +1;
	                    map.remove(mapRev.get(start-1));
	                    mapRev.remove(start-1);
	                    
	                }
	            }
	            
	            if(map.get(c)!=null)
	                mapRev.remove(map.get(c));
	           
	            map.put(c,curr);
	            mapRev.put(curr, c);
	            max = Math.max(curr-start+1, max);
	            curr++;
	        }
	        
	        return max;
	    }

}
