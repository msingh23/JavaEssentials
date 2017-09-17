/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC174DungeonGame {

	 public int calculateMinimumHP(int[][] dungeon) {
	        
	        int n = dungeon.length;
	        if(n ==0 ) return 0;
	        int m  = dungeon[0].length;
	        
	        int mem [][] = new int [n][m];
	        if(dungeon[n-1][m-1]>=0) mem[n-1][m-1] = 0;
	        else mem[n-1][m-1] = dungeon[n-1][m-1];
	        
	        //column
	        for(int i = n-2; i>=0; i--)
	        {
	            //int health = dungeon[i][m-1]
	            mem[i][m-1] = Math.min(mem[i+1][m-1] +dungeon[i][m-1], 0);
	        }
	        
	        //row
	        for(int j = m -2; j>=0 ; j--)
	        {
	            mem[n-1][j] = Math.min(mem[n-1][j+1] +dungeon[n-1][j] , 0);
	        }
	        
	        for(int i = n-2 ;i >=0 ;i --)
	            for(int j =m-2; j>=0 ; j--)
	            {
	                mem[i][j] = Math.min(Math.max(mem[i+1][j], mem[i][j+1]) + dungeon[i][j], dungeon[i][j]);
	                if( mem[i][j]>0)  mem[i][j] =0;
	            }
	            
	            return Math.abs(mem[0][0])+1;
	        
	    }
	
}
