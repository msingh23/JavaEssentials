package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139WordBreak {
	public boolean wordBreak(String s, List<String> wordDict)
    {
        Set<String> set = new HashSet<String>();
        for(String word : wordDict ) set.add(word);
        
        return wordBreakHelper(s, set);
    }
public boolean wordBreakHelper(String s, Set<String> set) {
		if(s.equals("") || set.contains(s)) return true;

		boolean ans = false;
		for (int i = 1; i < s.length(); i++) {
			String s1 = s.substring(0, i);
			String s2 = s.substring(i);
//			System.out.println(s1);
//			System.out.println(s2);
//			System.out.println();
			if ( set.contains(s1) && wordBreakHelper(s2, set)) {
				return true;
			} 
		}
		return ans;
	}
	
	public static void main(String[] args) {
		LC139WordBreak lc = new LC139WordBreak();
		List<String> ls = new ArrayList<String>(new ArrayList<String>(Arrays.asList("leet","code")));
				
		System.out.println(lc.wordBreak("leetcode",Arrays.asList("leet","code")));
	}
}
