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
public class LC30SubstringwithConcatenationofAllWords {

	
	 /*
	  * O(Slen * window)
	   public List<Integer> findSubstring(String s, String[] words) {
	       Map<String, Integer> map = new HashMap<String, Integer>();
	       for(String word : words)
	           map.put(word, map.getOrDefault(word, 0) +1);
		
	       int n = s.length();
	       int m = words[0].length();
	       List<Integer> out = new ArrayList<Integer>();
	       for(int i = 0; i<= n-(m * words.length); i++ )
	       {
	           boolean contain = true;
	           Map<String, Integer> copy = new HashMap<String, Integer>(map);
	           for(int j = i ; j < i + (m * words.length) ; j+=m )
	           {
	               String key = s.substring(j, j+m);
	               
	               if(copy.containsKey(key))
	               {
	                   copy.put(key, copy.get(key)-1);
	                   if(copy.get(key) == 0)
	                       copy.remove(key);
	               }else 
	               {
	                   contain = false;
	                   break;
	               }
	           }
	           if(contain)
	               out.add(i);
	           
	       }
	       
	       return out;
	       
	    }
	    */
	 // O(sLen/wordlen) * wordlen = O(sLen)
	/*
	 * 
	 * Use wordlen passes to try window from various start indexes upto len of each word.
	 * this would ensure that combinationsa re tries.
	 */
	    
	      public static List<Integer> findSubstring(String s, String[] words) {
	        List<Integer> res = new ArrayList<>();
	        if(words == null || words.length == 0 || s.length() == 0) return res;
	        int wordLen = words[0].length();
	        int numWord = words.length;
	        int windowLen = wordLen * numWord;
	        int sLen = s.length();
	        HashMap<String, Integer> map = new HashMap<>();
	        int count = 0;
	        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

	        for(int i = 0; i < wordLen; i++) {  // Run wordLen scans
	            
	            Map<String, Integer> copy = new HashMap<String, Integer>();
	            int start = i;
	            for(int j = i; j <=sLen; j+=wordLen)
	            {
	                if(j+wordLen>sLen) break;
	                String key = s.substring(j, j+wordLen);
	                if(!map.containsKey(key))
	                {
	                    copy = new HashMap<>();
	                    start = j + wordLen;
	                    count = 0;
	                }else
	                {
	                    copy.put(key, copy.getOrDefault(key, 0)+1);
	                    if(copy.get(key) >map.get(key)) count++;
	                    if(j + wordLen - start == windowLen) 
	                    {
	                        if(count==0)
	                        {
	                            res.add(start);
	                        }
	                        
	                        //remove previous
	                        String prev = s.substring(start, start+wordLen);
	                        
	                        if(copy.get(prev)>map.get(prev)) count--;
	                        start = start+wordLen;
	                        copy.put(prev, copy.get(prev)-1);
	                       
	                        if(copy.get(prev) == 0)
	                            copy.remove(prev);
	                    }
	                }
	            }
	   
	        }
	        return res;
	    }

}
