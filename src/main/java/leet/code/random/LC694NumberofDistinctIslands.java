/**
 * 
 */
package leet.code.random;

import java.util.HashSet;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC694NumberofDistinctIslands {

	public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<String>();
        
        int r = grid.length;
        if(0 == r) return 0;
        int c = grid[0].length;
        
        for(int i = 0; i<r;i++)
        {
            for(int j = 0;j<c;j++)
            {
                StringBuffer buff = new StringBuffer();
                if(grid[i][j]== 1)
                {
                    DFS(grid, i, j, r, c, buff);
                    //System.out.println(buff);
                    set.add(buff.toString());
                }
                
            }
        }
        
        return set.size();
        
    }
    
    public  void DFS(int [][] grid, int r , int c, int rend, int cend, StringBuffer buff)
    {
        
        if(r>=0 && r<rend && c>=0 && c<cend)
        {
            
            buff.append(grid[r][c]);
            if(grid[r][c] ==1)
            {
                grid[r][c] = 0;
                //left
                DFS(grid, r, c-1, rend, cend, buff);
                //top
                DFS(grid, r-1, c, rend, cend, buff);
                //right
                DFS(grid, r, c+1, rend, cend, buff);
                //down
                DFS(grid, r+1, c, rend, cend, buff);
                
            }
            
        }
        else{
             buff.append(0);
        }
    }
}
