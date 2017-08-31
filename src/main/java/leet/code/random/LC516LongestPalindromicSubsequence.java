package leet.code.random;

public class LC516LongestPalindromicSubsequence {

	 /*
    O(2^n *n)
    
    public int longestPalindromeSubseq(String s) {
         if(s == null || s.length() == 1) return s.length();
	     Map<String, Integer> mp= new HashMap<String, Integer>(); 
         
        return longestPalindromeSubseqHelp(s, 0, "", mp);
	        
	    }
	    
   public int longestPalindromeSubseqHelp(String s, int start, String buff,  Map<String, Integer> mp)
  {
      int left = 0, right = 0;
      if(start==s.length())
      {
          if(mp.containsKey(buff))
          {
              return mp.get(buff);
          }
          //System.out.println(buff);
         if(isPalin(buff))
         {
             mp.put(buff,buff.length());
             return buff.length();
         }
          mp.put(buff,0);
          return 0;
      }
      
      String add = String.valueOf(s.charAt(start));
     
      left = longestPalindromeSubseqHelp(s, start+1, buff, mp );
      right = longestPalindromeSubseqHelp(s, start+1, buff+add.toString(), mp);
      
      return left >right ? left : right;
      
  }
	    
	    public String longestPalindromeHelper(String s, int start, int end)
	    {
	        while(start >=0 && end < s.length() && s.charAt(start)==s.charAt(end))
	        {
	           start--; end++;
	        }
	        
	        return s.substring(start+1, end);
	    }
    
    public boolean isPalin(String s)
    {
       int i = 0, j = s.length()-1;
        while(i<j)
        {
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
            
        return true;
    }
    */
    
      /*
    O(2^n )
    public int longestPalindromeSubseq(String s) 
    {
        return longestPalindromeSubseqHelper(s, 0, s.length()-1);
        
    }
    
    public int longestPalindromeSubseqHelper(String s, int start, int end)
    {
        if(start==end)
        {
            return 1;
        }
        if(start>end)
        {
            return 0;
        }
        
        return s.charAt(start) == s.charAt(end)? 2+longestPalindromeSubseqHelper(s, start+1, end-1) : Math.max(longestPalindromeSubseqHelper(s, start+1, end), longestPalindromeSubseqHelper(s, start, end-1));
    }
    
    */
    
    /*
    
    */
    
    /*
        O(n^2)  recursive
    
     public int longestPalindromeSubseq(String s)
     {
         int n = s.length();
        int [][] map = new int [n][n];
         for(int i = 0 ; i < n ;i ++)
             for(int j = 0 ; j < n ; j ++)
                 map[i][j] = -1;
         return longestPalindromeSubseqHelper(s, 0 , n-1, map);
     }
    
    public int longestPalindromeSubseqHelper(String s , int start, int end, int [][] map )
    {
        if(start==end)
        {
            //map.put(""+i+":"+j , 1);
            return 1;
        }
        if(start>end)
        {
            //map.put(""+i+":"+j , 0);
            return 0;
        }
        
        if(map[start][end]==-1)
        {
            Integer len = s.charAt(start) == s.charAt(end)? 2+ longestPalindromeSubseqHelper(s, start+1, end -1, map) : Math.max(longestPalindromeSubseqHelper(s, start+1, end, map), longestPalindromeSubseqHelper(s, start, end -1, map));
            map[start][end]  = len;
        }
        return map[start][end];
    }
    */
	
	public int longestPalindromeSubseq(String s)
    {
        int n = s.length();
        int [][] mem = new int [n][n];
        
        for(int i = 0 ; i < n ; i ++)
            for(int j = 0 ; j <n ; j ++)
            {
                if(i==j) mem[i][j] = 1;
            }
                          
        for(int i = n-1 ; i >=0 ; i--)
            for(int j = i+1 ; j <n ; j ++)
            {
                if(s.charAt(i) == s.charAt(j))
                {
                    mem[i][j] = 2 + mem[i+1][j-1];
                }
                else
                {
                    mem[i][j] = Math.max(mem[i+1][j] , mem[i] [j-1]);
                }
            }
        
        return mem[0][n-1];
        
    }
	
   public static void main(String[] args) {
	LC516LongestPalindromicSubsequence lc = new LC516LongestPalindromicSubsequence();
	System.out.println(lc.longestPalindromeSubseq("bbbab"));
}
}
