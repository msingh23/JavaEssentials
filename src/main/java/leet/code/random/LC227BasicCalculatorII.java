/**
 * 
 */
package leet.code.random;

import java.util.Stack;

/**
 * @author manu
 *
 */
public class LC227BasicCalculatorII {
	  public int calculate(String s) {
	        Stack<Integer> st = new Stack<Integer>();
	        int i = 0;
	        while(i<s.length())
	        {
	            int val = s.charAt(i);
	            
	            if(val-'0' >=0 && val-'0'<=9)
	            {
	                int ans[]= getNumber(s, i, s.length());
	                i = ans[0];
	                if(!st.isEmpty() && st.peek() == '/')
	                {
	                	st.pop();
	                    int numA = st.pop();
	                    int numB = ans[1];
	                    if(numA<numB || numB==0)
	                    {
	                        st.push(0);
	                        continue;
	                    }
	                    st.push(numA/numB);
	                    continue;
	                }else if(!st.isEmpty() && st.peek() == '*')
	                {
	                	st.pop();
	                    int numA = st.pop();
	                    int numB = ans[1];
	                    st.push(numA*numB);
	                    continue;
	                }
	                st.push(ans[1]);
	                continue;
	            }
	            if(val!= ' ')
	            {
	                st.push(val);
	            }
	            i++;
	        }
	        
	        // if(st.size()==1){
	        //     return st.pop();
	        // }
	        //reverse stacks
	        Stack<Integer> st1 = new Stack<Integer>();
	        while(!st.isEmpty()) st1.push(st.pop());
	        st=st1;
	        
	        while(!st.isEmpty() && st.size() >1 )
	        {
	            int numA = st.pop();
	            int operator = st.pop();
	            int numB = st.pop();
	            
	            if(operator == '+')
	            {
	                st.push(numA+numB);
	            }
	            else if(operator == '-')
	            {
	                 st.push(numA-numB);
	            }
	            else if(operator == '*')
	            {
	                st.push(numA*numB);
	            }
	            else if(operator == '/'){
	                if(numA<numB || numB==0){
	                    st.push(0);
	                    continue;
	                }
	                st.push(numA/numB);
	            }
	        }
	        return st.pop();
	    }
    
    public int[] getNumber(String s, int start, int end)
    {
        StringBuffer buff = new StringBuffer();
        while(start<end && s.charAt(start)-'0' >=0 && s.charAt(start)-'0' <=9)
        {
            buff.append(s.charAt(start++)-'0');
        }
        
        return new int[]{ start, Integer.parseInt(buff.toString())};
    }
    
    public static void main(String[] args) {
		System.out.println(new LC227BasicCalculatorII().calculate("2-1+6/6"));
	}
}
