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
public class LC131PalindromePartitioning {

	 public List<List<String>> partition(String s) {
	        Map<String, List<List<String>> > map = new HashMap<>();
	       return partition(s,map);
	        
	    }
	    
	    public List<List<String>> partition(String s ,  Map<String, List<List<String>> > map)
	    {
	        List<List<String>> _part = new ArrayList<>();
	        if(s.length()==0){
	            return _part;
	        }
	        if(s.length()==1){
	             _part.add(Arrays.asList(s));
	              map.put(s, _part);
	            return _part;
	        }
	        
	        if(!map.containsKey(s)){
	            
	            for(int i = 0 ; i < s.length(); i++)
	            {
	                String currS = s.substring(0,i+1);
	                if(isPalindrome(currS)) 
	                {
	                    List<List<String>> part = partition(s.substring(i+1), map);
	                    for(List<String> p : part)
	                    {
	                       List<String> copy = new ArrayList<String>(p);
	                        copy.add(0, currS);
	                        _part.add(copy);
	                    }
	                }
	            }
	              if(isPalindrome(s)) 
	              {
	                 _part.add(Arrays.asList(s)); 
	              }
	            map.put(s, _part);
	        }
	        return map.get(s);
	    }
	       
	    public boolean isPalindrome(String s)
	    {
	        int i = 0;
	        int j = s.length()-1;
	        while(i<=j)
	        {
	            if(s.charAt(i)!=s.charAt(j)) return false;
	            i++;
	            j--;
	        }
	        
	        return true;
	    }
}
