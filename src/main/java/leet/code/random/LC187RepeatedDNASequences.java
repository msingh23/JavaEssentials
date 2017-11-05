/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC187RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 10; i<=s.length();i++)
        {
            map.put(s.substring(i-10,i), map.getOrDefault(s.substring(i-10,i),0)+1);
        }
        
        List<String> out = new ArrayList<>();
        for(String key : map.keySet())
            if(map.get(key)>1)
                out.add(key);
        return out;
    }
}
