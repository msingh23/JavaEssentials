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
	
	public boolean findPathMemoizationPath(int[][] grid)
	{
		StringBuffer path = new StringBuffer();
		HashMap<coordinates, Boolean> map = new HashMap<coordinates, Boolean>();
		path.append(0);
		path.append(0);
		path.append(" ");
		boolean ans = findPathMemoizationPathHelper(grid, 0, 0 , map, path);
		System.out.println(path.toString());
		return ans;
	}

	private boolean findPathMemoizationPathHelper(int[][] grid, int r, int c, HashMap<coordinates, Boolean> map,
			StringBuffer path) {
		
		
		if((r == grid.length) || (c == grid[r].length) || grid[r][c] == 1)
		{
			 return false;
		}
		
		if((r == grid.length-1) && (c == grid[r].length -1))
		{
			return true;
		}
		coordinates cor = new coordinates(r, c);
				
		if(!map.containsKey(cor))
		{
			path.append(r+1);
			path.append(c);
			path.append(" ");
			boolean stepRight = findPathMemoizationPathHelper(grid, r+1, c, map, path);
			if(!stepRight)
			{
				path.delete(path.length()-3, path.length());
				path.append(r);
				path.append(c+1);
				path.append(" ");
				boolean stepBot = findPathMemoizationPathHelper(grid, r, c+1, map, path);
				if(!stepBot)
				{
					path.delete(path.length()-3, path.length());
				}
				map.put(cor, stepBot);
				
			}else{
				
				map.put(cor, true);;
			}
			
			
		}
		
		return map.get(cor);
		
		
	}
	
}
