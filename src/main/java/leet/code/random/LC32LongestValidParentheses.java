/**
 * 
 */
package leet.code.random;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author manu
 *
 */
public class LC32LongestValidParentheses {

	/*
    public int longestValidParentheses(String s) 
    {
        int max = s.length();
        
        while(max>1)
        {
            for(int i = 0 ; i <= s.length()-max; i++)
            {
                
                int f = 0;
                int b = 0;
                
                boolean found = true;
                
                //System.out.println(i +" " + max );
                for(int j = i ; j<i+max ; j++ )
                {
                    
                    Character ch = s.charAt(j);
                    
                    if(ch == '(')
                        f++;
                    
                    if(ch == ')')
                        b++;
                    
                    if(b>f)
                    {
                        found = false;
                        break;
                    }
                }
                
                if(b==f) return max;
                
            }
            max--;
        }
        return 0;
    }
   */
	/*
    public int longestValidParentheses(String s) 
    {
        int n = s.length();
        int [] dp = new int [n];
        Arrays.fill(dp, 0);
        int max = 0;
        
        for(int i = 1 ; i <n; i ++)
        {
            Character ch = s.charAt(i);
            if(ch==')')
            {
                    Character prev = s.charAt(i-1);
                    //case 1 prev is '('
                    if(prev == '(')
                    {
                        dp[i] = 2 + ((i-2) >=0 ? dp[i-2] : 0);
                    }
                    //case 2 prev os ')'
                    if(prev == ')')
                    {
                       
                        if(i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(')
                        {
                             dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2>=0 ? dp[i-dp[i-1]-2] : 0);
                            
                        }
                        
                    }
                
                max = Math.max(max, dp[i]);
            }
        } 
          
        return max;
    }
    */
    
  //using stacks
    public int longestValidParentheses(String s) 
    {
        Stack<Integer> index = new Stack<Integer>();
        index.add(-1);
        int max = 0;
        int i = 0;
        for(Character ch : s.toCharArray())
        {
           if(ch == ')')
           {
              // System.out.print(index +" ");
                  //remove first valid (
                    index.pop();
                   if(index.isEmpty())
                   {
                       index.push(i);
                   }else
                   {
                       max = Math.max(i - index.peek() , max);
                   }
                //   System.out.println(i+" "+ max + " " +index);
               
           }else
               index.push(i);
            i++;
        }
        
        return max;
        
    }
}
