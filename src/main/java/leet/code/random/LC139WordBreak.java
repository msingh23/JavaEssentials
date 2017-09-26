package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC139WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for(String word : wordDict) map.put(word, true);
        return wordBreak(s, map);
    }
    
    public boolean wordBreak(String s, Map<String, Boolean> map)
    {
        if(null == s ) return false;
        if(!map.containsKey(s))
        {
            int n = s.length();
            map.put(s, false);
            for(int i = 1; i<n ; i++)
            {
                String left = s.substring(0,i);
                String right = s.substring(i,n);
                if(map.getOrDefault(left, false) &&  wordBreak(right, map) )
                {
                    map.put(s, true);
                    break;
                }
               
            }
           
        }
        return map.get(s);
    }
	
	public static void main(String[] args) {
		LC139WordBreak lc = new LC139WordBreak();
		List<String> ls = new ArrayList<String>(new ArrayList<String>(Arrays.asList("leet","code")));
				
		System.out.println(lc.wordBreak("leetcode",Arrays.asList("leet","code")));
	}
}
