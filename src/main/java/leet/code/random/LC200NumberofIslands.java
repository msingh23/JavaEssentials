/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC200NumberofIslands {

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// System.out.println(grid[i][j] );
				if (grid[i][j] == '1') {
					count++;
					DFS(grid, i, j);
				}
			}
		}
		return count;
	}

	public void DFS(char[][] grid, int i, int j) {
		// System.out.println(i +" "+ j );
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
			return;

		if (grid[i][j] == '1') {
			grid[i][j] = '0';
			// vertical top
			DFS(grid, i, j - 1);
			// vertical down
			DFS(grid, i, j + 1);
			// horizontal right
			DFS(grid, i + 1, j);
			// horizontal left
			DFS(grid, i - 1, j);

		}

	}
}
