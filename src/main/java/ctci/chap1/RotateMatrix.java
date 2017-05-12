/**
 * 
 */
package ctci.chap1;

/**
 * @author manu
 *
 */
public class RotateMatrix {

	public static boolean RotateMatrix(int[][] in) {

		if (in.length == 0 || in.length != in[0].length)
			return false;

		for (int i = 0; i < in.length / 2; i++) {

			for (int j = i; j < in.length - 1 - i; j++) {

				rotate(in, i, j, true);

			}

		}
		return true;
	}

	private static void rotate(int[][] in, int i, int j, boolean right) {

		int offset = in.length-1;
		if (right) {

			int temp = in[j][offset - i];
			in[j][offset - i] = in[i][j];
			int temp2 = in[offset - i][offset - j];
			in[offset - i][offset - j] = temp;
			temp = in[offset - j][offset - offset + i];
			in[offset - j][offset - offset + i] = temp2;
			in[i][j] = temp;

		}

		else {
			int temp = in[offset - j][i];
			in[offset - j][i] = in[i][j];
			int temp2 = in[offset - i][offset - j];
			in[offset - i][offset - j] = temp;
			temp = in[j][offset - i];
			in[j][offset - i] = temp2;
			in[i][j] = temp;
		}

	}

}
