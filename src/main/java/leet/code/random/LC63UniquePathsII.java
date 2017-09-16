/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC63UniquePathsII {

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid.length == 0) return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int [][] mem = new int [n][m];
        for(int i =0 ; i< m; i++)
        {
           if(obstacleGrid[0][i] == 1) break;
            else mem[0][i] = 1;
        }
        
        for(int i =0 ;i < n; i++)
        {
           if(obstacleGrid[i][0] == 1) break;
            else mem[i][0] = 1;
        }
        
        for(int i = 1 ; i < n ;i ++)
        {
            for(int j = 1 ; j < m ; j++)
            {
                if(obstacleGrid[i][j] == 1)  mem[i][j] =0;
                else
                mem[i][j] = mem[i-1][j] + mem[i][j-1];
            }
                
        }
        return mem[n-1][m-1];
    }

}
