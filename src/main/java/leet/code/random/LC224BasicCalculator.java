/**
 * 
 */
package leet.code.random;

import java.util.Stack;

/**
 * @author manu
 *
 */
public class LC224BasicCalculator {


	/*
	 public int calculate(String s) {
	        
	        return calculate(s, 0, 0);
	        
	    }
	    
	    public int calculate(String s, int index, int prev)
	    {
	        if(index == s.length())
	            return prev;
	        int val = s.charAt(index);
	        int curr = 0;
	        if(val == '(')
	        {
	            return calculate(s, index+1, prev);
	        }
	        else if(val == '+')
	        {
	            int next  = calculate(s, index+1, 0);
	            return prev+next;
	        }
	        else if(val=='-')
	        {
	            int next  = calculate(s, index+1, 0);
	            return prev-next;
	        }else if(val-'0'>=0 && val-'0' <=9)
	        {
	            int [] ans = getNumber(s, index, s.length());
	            index = ans[0];
	            curr = ans[1];
	            return calculate(s, index, curr);
	        }
	        else if(val==' ')
	        {
	            return calculate(s, index+1, prev);
	        }
	        return prev;
	    }*/
	
	public int calculate(String s) {
        
	       
        Stack<Integer> st = new Stack<Integer>();
        int result = 0; 
        int sign =1;
        
        int i =0;
       
        while(i<s.length())
        {
            int val = s.charAt(i);
            if(val-'0'<=9 && val-'0'>=0)
            {
                int [] ans = getNumber(s,i, s.length());
                i = ans[0];
                result += (sign * ans[1]);
                continue;
            }
            if(val == '+')
            {
                sign =1;
            }
            if(val == '-')
            {
             sign =-1; 
            }
            if(val == '(')
            {
                st.push(result);
                st.push(sign);
                sign =1;
                result =0;
            }
            if(val == ')')
            {
                result = (st.pop()*result) + (st.pop());
                //st.push(result);
            }
            i++;
        }
        
	      return result;  
	    }
    public int[] getNumber(String s, int start, int end)
    {
        StringBuffer buff = new StringBuffer();
        
        while(start<end && (s.charAt(start)-'0') >=0 && (s.charAt(start)-'0')<=9)
        {
            buff.append(s.charAt(start));
            start++;
        }
        
        return new int[]{start, Integer.valueOf(buff.toString())};
    }
	 public static void main(String[] args) {
		LC224BasicCalculator bc = new  LC224BasicCalculator();
		System.out.println(bc.calculate("1-(5)"))	;
		}
}
