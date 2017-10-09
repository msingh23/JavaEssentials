/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC76MinimumWindowSubstring {
	 /*
    public boolean contains(String s, String t)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(Character ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        for(Character ch : t.toCharArray())
        {
            if(map.containsKey(ch))
            {
                map.put(ch , map.get(ch)-1);
                if(map.get(ch) == 0)
                    map.remove(ch);
            }else
                return false;
        }
        
        //if(map.size() > 0) return false;
        return true;
    }
    
    public String minWindow(String s, String t) {
        
        int len = t.length();
        int n = s.length();
        
        while(len <= n)
        {
            for(int i = 0 ; i <= n - len ; i++)
            {
                String ans = s.substring(i , i + len);
                boolean ret = contains(ans, t);
                //System.out.println(s + " "+ ans + " "+ t);
                if(ret)
                    return ans;
            }
            len++;
        }
        return "";
    }
    */
    
     public String minWindow(String s, String t) 
     {
         Map<Character, Integer> count = new HashMap<Character, Integer>();
         for(Character ch : t.toCharArray())
             count.put(ch, count.getOrDefault(ch, 0)+1);
         
         int uniq = 0;
         LinkedList<Integer> indx = new LinkedList<Integer>();
         int min = s.length() + 1;
         String ans = new String("");
         
         for(int i = 0; i < s.length(); i++)
         {
             Character ch = s.charAt(i);
             if(count.containsKey(ch))
             {
                 int val = count.get(ch);
                 if(val>0)
                     uniq++;
                 count.put(ch, count.get(ch) -1);
                 indx.add(i);
                 
                 
                 while(uniq == t.length())
                 {
                     
                     int start = indx.peekFirst();
                     int end = indx.peekLast();
                     
                     if(end-start+1 <min)
                     {
                         min = end-start+1;
                         ans = s.substring(start, end +1);
                     }
                     
                     indx.poll();
                     if(count.get(s.charAt(start)) == 0)
                         uniq--;
                     count.put(s.charAt(start), count.get(s.charAt(start))+1);
                 }
             }
         }
         
         return ans;
         
         
     }

}
