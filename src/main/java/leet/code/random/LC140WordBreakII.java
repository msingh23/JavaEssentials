/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	/*
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
	     */
	     public List<String> wordBreak(String s, List<String> wordDict) 
	     {
	         Set<String> set = new HashSet<String>(wordDict);
	         Map<String, List<String>> map= new HashMap<String, List<String>>();
	         return wordBreakHelper(s,set, map);
	     }
	    
	   public List<String> wordBreakHelper(String s, Set<String> set, Map<String, List<String>> map )
	   {
	       //base
	       if(s.equals("") || s.length() == 0)
	       {
	           return new ArrayList<String>(Arrays.asList("*"));
	       }

	       if(!map.containsKey(s))
	       {
	           List<String> ls = new LinkedList<String>();
	            for(int i = 1; i <= s.length(); i++)
	           {
	               if( set.contains(s.substring(0, i)) )
	               {
	                   List<String> ahead = wordBreakHelper(s.substring(i), set, map);
	                   if(ahead!=null)
	                   {
	                       for(String line: ahead)
	                       {
	                           if(line.equals("*"))
	                           {
	                                 ls.add(s.substring(0, i));
	                           }else{
	                               ls.add(s.substring(0, i)+" "+line);
	                           }
	                       }
	                          
	                   }
	               }
	           }
	           map.put(s, ls);
	       }
	       return map.get(s);
	   }
	   
	    public static void main(String[] args) {
			LC140WordBreakII lc = new LC140WordBreakII();
			System.out.println(lc.wordBreak("catsanddog", (List<String>) Arrays.asList("cat","cats","and","sand","dog")));
		}
	
}
