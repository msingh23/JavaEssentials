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
	        
	        int r = dungeon.length;
	        int c = dungeon[0].length;
	        int [][] health = new int [r][c];
	        
	        health[r-1][c-1] = dungeon[r-1][c-1] >=0 ? 0 : dungeon[r-1][c-1];

	        for(int i = c-2 ;i >=0;i--)
	            health[r-1][i] = Math.min( health[r-1][i+1]+dungeon[r-1][i], 0); 
	        
	         for(int i = r-2 ;i >=0;i--)
	            health[i][c-1] = Math.min( health[i+1][c-1]+dungeon[i][c-1], 0); 
	        
	        for(int i = r-2; i>=0 ; i--)
	            for(int j = c-2 ; j>=0; j--)
	                 health[i][j] = Math.min(Math.max(health[i+1][j], health[i][j+1]) + dungeon[i][j], 0 );
	      
	        
	        return health[0][0] <0 ? 1 + Math.abs(health[0][0]) : 1;
	    }
	
}
