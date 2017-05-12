/**
 * 
 */
package ctci.chap1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author manu
 *
 */
public class RotateMatrixTest {

	/**
	 * @throws java.lang.Exception
	 */

	private int[][] in;
	private int[][] out;
	private RotateMatrix handler;

	@Before
	public void setUp() throws Exception {
		
		in= new int[][]{{1,2,3,4,5},
						{6,7,8,9,10},
						{11,12,13,14,15},
						{16,17,18,19,20},
						{21,22,23,24,25}};
						
		out = new int[][]{{21,16,11,6,1},
						  {22,17,12,7,2},
						  {23,18,13,8,3},
						  {24,19,14,9,4},
						  {25,20,15,10,5}};

		handler = new RotateMatrix();
	}

	@Test
	public void test() {
		handler.RotateMatrix(in);
		//print(in);
		Assert.assertArrayEquals(in, out);
	}

	private void print(int[][] in2) {
		for (int i = 0; i < in2.length; i++) {

			for (int j = 0; j < in2[i].length; j++) {
				System.out.print(in2[i][j]);
				System.out.print(" ");

			}
			System.out.println();
		}
	}

}
