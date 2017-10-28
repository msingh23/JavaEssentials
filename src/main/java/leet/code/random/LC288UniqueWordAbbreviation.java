/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC288UniqueWordAbbreviation {

	 Map<String, String> map = new HashMap<String, String>();
	    
	    private String getAbbr(String str)
	    {
	        return str.length()>2 ? (str.substring(0,1) + (str.length()-2) + str.substring(str.length()-1,str.length()) ) : str;
	        
	    }
	    
	    public void ValidWordAbbr(String[] dictionary) {
	        for(String word : dictionary)
	        {
	            String key = getAbbr(word);
	            if(map.containsKey(key) && (map.get(key)==null || !map.get(key).equals(word)) )
	            {
	                map.put(key, null);
	            }
	            else
	            {
	                map.put(key, word);
	            }
	        }
	           
	    }
	    
	    public boolean isUnique(String word) {
	        String key = getAbbr(word);
	        if(map.containsKey(key) ) 
	        {
	         
	            if( map.get(key)==null ) return false;
	            else
	            {
	                if(map.get(key).equals(word)) return true;
	                return false;
	            }
	        }else
	        {
	            return true;
	        }
	    }
	
}
