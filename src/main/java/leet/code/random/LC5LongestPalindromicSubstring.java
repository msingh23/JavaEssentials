package leet.code.random;

public class LC5LongestPalindromicSubstring {
	 public String longestPalindrome(String s) {
		 // O(n^2) s = O(n^2)
	     public String longestPalindrome(String s)
	     {
	         int n = s.length();
	         String largest ="";
	         int mem [][] = new int [n][n];
	         // all indiv characs are palin
	         for(int i = 0 ; i<n; i++)
	         {
	             mem[i][i] =1;
	             if(largest.length()< i-i+1)
	             {
	                 largest = s.substring(i,i+1);
	             }
	         }
	         
	         // check length 2
	         for(int i = 0 ; i<n-1; i++)
	         {
	                 if(s.charAt(i) == s.charAt(i+1))
	                 {
	                     mem[i][i+1] = 1;
	                     if(largest.length()< 2)
	                    {
	                        largest = s.substring(i,i+2);
	                    }
	                 }      
	         }
	         
	         //check for length 3 to length n
	         
	         for(int l = 3 ; l<=n ; l++)
	         {
	             
	             for(int i = 0 ; i<= n-l ; i++)
	             {
	                 int j = i+l-1;
	                 
	                 if(s.charAt(i) == s.charAt(j))
	                 {
	                     if(mem[i+1][j-1]==1)
	                     {
	                         mem[i][j]=1;
	                         if(largest.length()< j-i+1)
	                         {
	                             largest = s.substring(i,j+1);
	                         }
	                         
	                     }
	                 }else
	                 {
	                   mem[i][j]=0;  
	                 }
	             }
	             
	         }
	         return largest;
	     }
	    
	    
	    */
	    // O(n^2) s = O(1)
	    public String longestPalindrome(String s) {
	        
	        if(s == null || s.length()==1) return s;
	    
	        String larg="";
	        
	        for(int i = 0 ; i < s.length(); i++ )
	        {
	            
	            String l1 = longestPalindromeHelper(s, i, i);
	            String l2 = longestPalindromeHelper(s, i, i+1);
	            String temp = l1.length()>l2.length() ? l1 : l2;
	            if(temp.length()>larg.length())
	            {
	                larg = temp;
	            }
	        }
	        
	        
	        return larg;
	        
	    }
	    
	    
	    public String longestPalindromeHelper(String s, int start, int end)
	    {
	        while(start >=0 && end < s.length() && s.charAt(start)==s.charAt(end))
	        {
	           start--; end++;
	        }
	        
	        return s.substring(start+1, end);
	    }
}
