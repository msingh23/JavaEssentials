/**
 * 
 */
package ctci.chap8;

import java.util.HashMap;

/**
 * @author manu
 *
 */
public class RobotInGrid {

	public boolean findPath(int [][] grid)
	{
		return findPathHelper(grid, 0, 0);
	}
	public class coordinates{
		int x; 
		int y;
		public coordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(obj instanceof coordinates)
			{
				return this.x == ((coordinates)obj).x && this.y == ((coordinates)obj).y;
				
			}
			return false;
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}
	}

	private boolean findPathHelper(int[][] grid, int i, int j) {
		if(i>= grid.length || j>=grid[i].length || grid[i][j] ==1){
			return false;
		}
		
		if(i == grid.length-1 && j == grid[i].length-1)
		{
			return true;
		}
		return findPathHelper(grid, i+1, j) || findPathHelper(grid, i, j+1);
	}
	
	public boolean findPathMemoization(int[][] grid)
	{
		HashMap<coordinates, Boolean> mp = new HashMap<coordinates, Boolean>();
		return findPathMemoizationHelper(grid, 0 , 0, mp);
	}

	private boolean findPathMemoizationHelper(int[][] grid, int i, int j, HashMap<coordinates, Boolean> mp) {
		
		if(i == grid.length || j == grid[i].length || grid[i][j] ==1){
			return false;
		}
		if(i == grid.length-1 && j == grid[i].length-1 ){
			return true;
		}
		coordinates cor = new coordinates(i, j);
		if(!mp.containsKey(cor))
		{
			mp.put(cor, findPathMemoizationHelper(grid, i+1, j, mp) || findPathMemoizationHelper(grid, i, j+1, mp));
		}
		return mp.get(cor);
	}
	
}
