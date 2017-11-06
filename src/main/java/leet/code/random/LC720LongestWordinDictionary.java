/**
 * 
 */
package leet.code.random;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC720LongestWordinDictionary {

public String longestWord(String[] words) {
        
        PriorityQueue<String> pq = new PriorityQueue<String>();
        Set<String> set = new HashSet<String>();
        for(String word : words)
            pq.add(word);
        
        String out = "";
        while(!pq.isEmpty())
        {
            String curr = pq.poll();
                if(curr.length() ==1 || set.contains(curr.substring(0,curr.length()-1)) )
                {
                   if(out.length()<curr.length())
                   {
                      out = curr; 
                   }
                    set.add(curr);
                }
        }
        return out;
    }
}
