/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC91DecodeWays {
	
	 public int numDecodings(String s) 
     {
         if(null == s || s.length() == 0) return 0;
         int n = s.length();
         int [] dp = new int [n];
         dp[n-1] = Integer.valueOf(s.substring(n-1,n)) >0 ? 1 : 0;
         
         for(int i = n-2; i>=0; i--)
         {
             int single = Integer.valueOf(s.substring(i, i+1));
             int pair = Integer.valueOf(s.substring(i, i+2));
             
             if(single == 0) 
             {
                 dp[i]=0;
             }else
             {
                 dp[i] = dp[i+1];
                 if(pair>0 && pair<=26 )
                 {
                    if(i+2 == n)
                    {
                       dp[i]++; 
                    }else
                    {
                        dp[i]+=dp[i+2];
                    }
                 }
             }
         }
         return dp[0];
         
     }

}
