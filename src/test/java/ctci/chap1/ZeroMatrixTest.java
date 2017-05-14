/**
 * 
 */
package ctci.chap1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author manu
 *
 */
public class ZeroMatrixTest {

	private int[][][] inp;
	private int[][][] out;

	private ZeroMatrix handler;

	@Before
	public void setup() {
		inp = new int[][][]{{ {3, 5, 0, 4},
							  {2, 1, 9, 7},
							  {3, 2, 1, 0},
							  {8, 5, 0, 4}},
								{ {1,0},
								  {1,1}},
								{ {0, 5, 0, 4},
								  {2, 1, 9, 7},
								  {3, 2, 1, 0},
								  {8, 5, 0, 4}} };
								  
		out = new int [][][]{{ {0, 0, 0, 0},
			  				   {2, 1, 0, 0},
			  				   {0, 0, 0, 0},
			  				   {0, 0, 0, 0}  },{
			  					   {0,0},
								   {1,0} },
										{ {0, 0, 0, 0},
										  {0, 1, 0, 0},
										  {0, 0, 0, 0},
										  {0, 0, 0, 0}}};

	}

	@Test
	public void test() {
		
		for(int i = 0;i<inp.length;i++){
			print(inp[i]);
			handler.ZeroMatrix2(inp[i]);
			print(inp[i]);
			Assert.assertArrayEquals(out[i], inp[i]);
		}

	}

	private void print(int[][] is) {
		for(int i = 0 ; i<is.length;i++){
			for(int j=0;j<is[i].length;j++){
				System.out.print(is[i][j]);
			}
		System.out.println();
		}
		
	}

}
