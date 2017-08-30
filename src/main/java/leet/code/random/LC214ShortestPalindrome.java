/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC214ShortestPalindrome {
	/*
	///O(nlogn) 
	 public String shortestPalindrome(String s) {
			
		 int j = 0;
		 int i = s.length() - 1;
		    for (; i >= 0; i--) {
		    	System.out.println(s.charAt(j));
		        if (s.charAt(i) == s.charAt(j)) { j += 1; }
		    }
		    System.out.println();
		    if (j == s.length()) { return s; }
		    String suffix = s.substring(j);
		    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
		 }
		 */
	   /*
	    * O(n^2)
	    * public String shortestPalindrome(String s) {
		     
	        int maxLen =0;
	        int maxi =0, maxj =0;
	        String shortPalin = "";
	     
	        for(int i = maxj-1 ; i<s.length()-1 ;i++)
	        {
	            //calcualte the largest laindrome with center i , i
	            // eg dad
	            int ans [] = getLargestPalin(s, i, i);
	             //calcualte the largest laindrome with center i , i+1
	            // eg daad
	            int ans2 [] = getLargestPalin(s, i, i+1);
	            int left = ans[0];
	            int right = ans[1];
	            
	            int left1 = ans2[0];
	            int right1 = ans2[1];
	            
	            if(right-left+1>maxLen && left ==0){
	                maxLen=right-left+1;
	                maxi=left;
	                maxj=right;
	            }
	            if(right1-left1+1>maxLen && left1 ==0){
	                maxLen=right1-left1+1;
	                maxi=left1;
	                maxj=right1;
	            }
	        }
	      
	          shortPalin = concatBegin(s, maxj+1, s.length()-1);  
	        
	        return shortPalin;
	    }
	    
	    public String concatBegin(String s, int start, int end)
	    {
	        StringBuffer buff = new StringBuffer(s);
	        
	        while(end<s.length() && start<=end)
	        {
	            buff.insert(0, s.charAt(start++));
	        }
	        
	        return buff.toString();
	    }
	    
	    public int [] getLargestPalin(String s, int begin, int end)
	    {
	        while(begin>=0 && end < s.length() && s.charAt(begin) == s.charAt(end))
	        {
	            begin--;
	            end++;
	        }
	        
	        return new int[]{begin+1, end-1};
	    }*/
    
	/*
	 * KMP inspired 0(n)
	 */
	
	 public String shortestPalindrome(String s) 
     {
         
         String ss = s + "." + new StringBuffer(s).reverse();
         int n = ss.length();
         int [] tab = new int[n];
         kmpTable(ss, tab);
         return new StringBuffer(s.substring(tab[n-1])).reverse() + s;
         
     }
    public void kmpTable(String s, int [] tab) 
    {
        int  j = 0;
        tab[0]=0;
        for(int i = 1 ;i<s.length(); i++ )
        {
            if(s.charAt(i)==s.charAt(j))
            {
                tab[i] = tab[i-1]+1;
                j++;
            }
            else
            {
                j=tab[i-1];
                while(j>0 && s.charAt(i)!=s.charAt(j)) 
                {
                     j = tab[j-1];
                }
                if(s.charAt(i)==s.charAt(j))
               {
                	j++;
                    tab[i]=j;
                   
               }
                
                
            }
        }
        
           
    }
	
    public static void main(String[] args) {
    	String s = "aacecaaa";
		LC214ShortestPalindrome palin = new LC214ShortestPalindrome();
		System.out.println(palin.shortestPalindrome(s));
	}
	
}
