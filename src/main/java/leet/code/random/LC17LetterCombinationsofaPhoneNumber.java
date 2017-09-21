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
public class LC17LetterCombinationsofaPhoneNumber {
	 public List<String> letterCombinations(String digits) {
	        Map<Character , List<Character>> map = new HashMap<Character, List<Character>>();
	        List<String> out = new ArrayList<String>();
	        if(digits == null || digits.length() ==0) return out;
	        map.put('1', new ArrayList<Character>(Arrays.asList('~')));
	        map.put('2', new ArrayList<Character>(Arrays.asList('a','b','c')));
	        map.put('3', new ArrayList<Character>(Arrays.asList('d','e','f')));
	        map.put('4', new ArrayList<Character>(Arrays.asList('g','h','i')));
	        map.put('5', new ArrayList<Character>(Arrays.asList('j','k','l')));
	        map.put('6', new ArrayList<Character>(Arrays.asList('m','n','o')));
	        map.put('7', new ArrayList<Character>(Arrays.asList('p','q','r','s')));
	        map.put('8', new ArrayList<Character>(Arrays.asList('t','u','v')));
	        map.put('9', new ArrayList<Character>(Arrays.asList('w','x','y','z')));
	        map.put('0', new ArrayList<Character>(Arrays.asList(' ')));
	        
	        letterCombinationsHelper(0, map, out, digits, new StringBuffer(""));
	        return out;
	    }
	    
	    public void letterCombinationsHelper(int start, Map<Character , List<Character>> map, List<String> out, String digit, StringBuffer buff )
	    {
	        if(start == digit.length() ) {
	            out.add(buff.toString());
	            return;
	        }
	        for(Character c : map.get(digit.charAt(start)))
	        {
	            buff.append(c);
	            letterCombinationsHelper(start+1, map, out, digit, buff);
	            buff.deleteCharAt(buff.length()-1);
	        }
	    }
}
