/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC72EditDistance {

	 public int minDistance(String word1, String word2) {
	        
	        int m = word1.length();
	        int n = word2.length();
	        
	        int [][] mem = new int [m+1][n+1];
	        
	        for(int i = 1; i <= n ; i++) mem[0][i] = i;
	        for(int i = 1; i <=m ; i++) mem[i][0] = i;
	        mem[0][0] = 0;
	        
	        for(int i = 1 ;i <=m ; i++)
	            for(int j = 1; j<=n ;j++)
	            {
	                if( word1.charAt(i-1) == word2.charAt(j-1) )
	                {
	                    mem[i][j] = mem[i-1][j-1];
	                }
	                else
	                {
	                    int replace = mem[i-1][j-1];
	                    int delete = mem[i-1][j];
	                    int insert = mem[i][j-1];
	                    
	                    mem[i][j] = 1 + Math.min(Math.min(replace, delete), insert);
	                }
	            }
	        
	        return mem[m][n];
	        
	    }
}
