/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manu
 *
 */
public class LC241DifferentWaystoAddParentheses {

	
	public List<Integer> diffWaysToCompute(String input) 
    {
        List<Integer> out = new ArrayList<Integer>();
        for(int i = 0; i<input.length();i++)
        {
            int curr = input.charAt(i);
            if(curr == '*' || curr == '-' || curr == '+')
            {
                String left = input.substring(0, i);
                String right = input.substring(i+1);
                
                List<Integer> leftList = diffWaysToCompute(left);
                List<Integer> rightList = diffWaysToCompute(right);
                
                for(Integer leftL : leftList)
                {
                	for(Integer rightL : rightList)
                	{
                		switch(curr)
                        {
                            case '*':
                                    out.add(leftL*rightL);
                                    break;
                            case '-':
                                out.add(leftL-rightL);
                                break;
                            case '+':
                                out.add(leftL+rightL);
                                break;
                        }
                		
                	}
                }
                
            }
        }
        
        if(out.size()==0) out.add(Integer.valueOf(input));
        return out;
    }
    
    public static void main(String[] args) {
		System.out.println(new LC241DifferentWaystoAddParentheses().diffWaysToCompute("2*3-4*5"));
	}
}
