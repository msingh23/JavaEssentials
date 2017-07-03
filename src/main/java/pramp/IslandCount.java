/**
 * 
 */
package pramp;

/**
 * @author manu
 *
 */
public class IslandCount {

	public int getIslandCount(int[][] inp) {

		int count = 0;
		for (int i = 0; i < inp.length; i++) {
			for (int j = 0; j < inp[i].length; j++) {
				if (inp[i][j] == 1) {
					count++;
					dfsAndNegate(inp, i, j);
				}
			}
		}
		return count;
	}

	private void dfsAndNegate(int[][] inp, int i, int j) {

		if (inp[i][j] == 1) {
			inp[i][j] = -1;
			if (i - 1 >= 0 && j - 1 >= 0) {
				dfsAndNegate(inp, i - 1, j);
				dfsAndNegate(inp, i, j - 1);
			}

			if (i + 1 < inp[i].length && j + 1 < inp.length) {
				dfsAndNegate(inp, i + 1, j);
				dfsAndNegate(inp, i, j + 1);
			}

		}

	}

}
