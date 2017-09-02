/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC140WordBreakII {

	/*
	 * brute force
	public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> out = new ArrayList<String>();
        wordBreakHelper(s, wordDict, out, "");
        return out;
    }
    public void wordBreakHelper(String s, List<String> wordDict, List<String> out, String buff){
       
        if(s.equals("") )
        {
            return ;
        }
            for(String word : wordDict)
            {
                int len = word.length();
                int end =  len;
                
                if(end<=s.length())
                {
                    if(s.substring(0, end).equals(word))
                    {
                       
                        if(end==s.length())
                        {
                            out.add(buff + s.substring(0, end));
                            //return;
                        }
                        wordBreakHelper(s.substring(end), wordDict, out, buff+s.substring(0, end) + " " );
                        
                    }
                }
            }
       
    }
	    */
	
	 public List<String> wordBreak(String s, List<String> wordDict) 
	    {
	        Map<String, List<String>> mp = new HashMap<String, List<String>>();
	        
	        return wordBreakHelper(s, mp, wordDict);
	    }
	    
	     public List<String> wordBreakHelper(String s,  Map<String, List<String>> mp, List<String> wordDict)
	     {
	         if(mp.get(s)==null)
	         {
	             
	             if(s.equals(""))
	             {
	                 return Arrays.asList("");
	             }
	             
	             List<String> ls = new ArrayList<String>();
	             for(String word : wordDict)
	             {
	                 if(word.length()>s.length()) continue;
	                 if(s.substring(0,word.length()).equals(word) )
	                 {
	                     List<String> ps = wordBreakHelper(s.substring(word.length()), mp, wordDict);
	                     for(String w : ps)
	                     {
	                         ls.add(s.substring(0,word.length()) + (w.equals("")?"":" " + w));
	                     }
	                 }
	             }
	             mp.put(s, ls);
	             
	         }
	        return mp.get(s);
	     }
	    public static void main(String[] args) {
			LC140WordBreakII lc = new LC140WordBreakII();
			System.out.println(lc.wordBreak("catsanddog", (List<String>) Arrays.asList("cat","cats","and","sand","dog")));
		}
	
}
