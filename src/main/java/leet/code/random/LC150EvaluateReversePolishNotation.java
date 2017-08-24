package leet.code.random;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC150EvaluateReversePolishNotation {

	 public int operation(int val1, int val2, String operator)
	    {
	        switch (operator){
	                
	            case "+": 
	                {
	                    return val1 + val2;
	                    //break;
	                }
	            case "-":
	                {
	                    return val2 - val1;
	                   // break;
	                }
	            case "*":
	                {
	                    return val1 * val2;
	                    //break;
	                }
	            case "/":
	                {
	                    return val2 / val1;
	                    //break;
	                }
	        }
	        return 0;
	    }
	    
	    public int evalRPN(String[] tokens) {
	        
	        Set<String> operators = new HashSet<String>();
	        Stack<Integer> st = new Stack<Integer>();
	        operators.add("+");
	        operators.add("-");
	        operators.add("*");
	        operators.add("/");
	        
	        for(String str : tokens)
	        {
	            if(!operators.contains(str))
	            {
	                st.push(Integer.valueOf(str));
	            }else
	            {
	                st.push(operation(st.pop(), st.pop(), str));
	                
	            }
	        }
	        
	        return st.pop();
	    }
}
