/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author manu
 *
 */
public class LC20ValidParentheses {

	public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(Character ch : s.toCharArray())
        {
            if(ch == ')' ||  ch == '}' || ch == ']')
            {
                if(st.isEmpty() || map.get(ch)!=st.peek() ) return false;
                //remove the element is match
                st.pop();
                
            }
            else
                st.add(ch);
        }
        return st.isEmpty();
    }
}
