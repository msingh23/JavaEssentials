/**
 * 
 */
package leet.code.random;

import java.util.Arrays;

/**
 * @author manu
 *
 */
public class LC73SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {

		boolean colZero = false, rowZero = false;
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; i++)
			if (matrix[i][0] == 0) {
				rowZero = true;
				break;
			}

		for (int i = 0; i < n; i++)
			if (matrix[0][i] == 0) {
				colZero = true;
				break;
			}

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}

		for (int i = 1; i < m; i++)
			if (matrix[i][0] == 0)
				Arrays.fill(matrix[i], 0);

		for (int i = 1; i < n; i++)
			if (matrix[0][i] == 0)
				for (int j = 0; j < m; j++)
					matrix[j][i] = 0;

		if (colZero)
			Arrays.fill(matrix[0], 0);
		if (rowZero)
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}

	}

}
