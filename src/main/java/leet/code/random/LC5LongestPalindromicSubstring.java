package leet.code.random;

public class LC5LongestPalindromicSubstring {
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
	    
	    public static void main(String[] args) {
	    	LC5LongestPalindromicSubstring z = new LC5LongestPalindromicSubstring();
			System.out.println(z.longestPalindrome("aaaa"));
		}
}
