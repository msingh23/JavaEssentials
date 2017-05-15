/**
 * 
 */
package ctci.chap1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author manu
 *
 */
public class ZeroMatrix {

	public static void ZeroMatrix(int[][] inp) {

		Set<Integer> row = new HashSet<Integer>();
		Set<Integer> col = new HashSet<Integer>();

		if (null != inp) {

			for (int i = 0; i < inp.length; i++) {

				for (int j = 0; j < inp[i].length; j++) {

					if (inp[i][j] == 0) {
						row.add(i);
						col.add(j);
					}

				}

			}
			Iterator<Integer> iter = row.iterator();
			while (iter.hasNext()) {
				zero(inp, iter.next(), true);
			}
			iter = col.iterator();
			while (iter.hasNext()) {
				zero(inp, iter.next(), false);
			}

		}

	}

	private static void zero(int[][] inp, int index, boolean row) {

		if (row) {

			for (int i = 0; i < inp[index].length; i++) {

				inp[index][i] = 0;
			}

		} else {

			for (int i = 0; i < inp.length; i++) {

				inp[i][index] = 0;
			}

		}

	}

	public static void ZeroMatrix2(int[][] inp) {

		if (null != inp) {

			boolean isColZero = false;
			boolean isRowZero = false;

			for (int i = 0; i < inp.length; i++) {
				if (inp[i][0] == 0) {
					isColZero = true;
					break;
				}

			}

			for (int i = 0; i < inp[0].length; i++) {
				if (inp[0][i] == 0) {
					isRowZero = true;
					break;
				}
			}

			for (int i = 1; i < inp.length; i++) {
				for (int j = 1; j < inp[i].length; j++) {
					if (inp[i][j] == 0) {
						inp[i][0] = 0;
						inp[0][j] = 0;
					}
				}
			}

			for (int i = 1; i < inp.length; i++) {
				if (inp[i][0] == 0) {
					zero(inp, i, true);
				}
				if (isColZero) {
					inp[i][0] = 0;
				}
			}

			for (int j = 1; j < inp[0].length; j++) {
				if (inp[0][j] == 0) {
					zero(inp, j, false);
				}
				if (isRowZero) {
					inp[0][j] = 0;
				}
			}
			if (isColZero || isRowZero) {
				inp[0][0] = 0;
			}

		}

	}

}
