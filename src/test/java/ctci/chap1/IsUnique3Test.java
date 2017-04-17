/**
 * 
 */
package ctci.chap1;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author manu
 *
 */
public class IsUnique3Test {
	private String[] inp;
	private boolean[] out;
	private IsUnique isUnique;

	@Before
	public void setup() {

		inp = new String[] { "ZYXWUVAbCsfgh", "avbnhjkoi", "ABBffjjffug", "AbnjlhklpA", "<>ZCCZ><", "cc", "mnkl" };
		out = new boolean[] { true, true, false, false, false, false, true };

	}

	@Test
	public void testUniqueString() {
		for (int i = 0; i < inp.length; i++) {
			Assert.assertEquals(out[i], isUnique.isUnique3(inp[i]));

		}
	}

}
