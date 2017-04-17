/**
 * 
 */
package ctci.chap1;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author manu
 *
 */
public class IsUniqueTest {

	private String [] inp ;
	private String [] inpWithSmallChars;
	private boolean [] out ;
	private boolean [] outWithSmallChars;
	private IsUnique isUnique;
	
	@Before
	public void setup() {
		inp = new String[]{"abcde","cc","c","hello", "apple", "kite", "padle", "null", "!@#$%^&*()QWERTYP{}|ASDFGHJKL:ZXCVBNM<>?"};
		out = new boolean [] {true,false, true,false,false,true,true, false, true};
		inpWithSmallChars = new String[]{"abcde","cc","c","hello", "apple", "kite", "padle", "null"};
		outWithSmallChars = new boolean [] {true,false, true,false,false,true,true, false};


	}
	
	@Test
	public void testUniqueString() {
		for(int i=0; i<inp.length; i++){
			Assert.assertEquals(out[i], isUnique.isUnique(inp[i]));
			if(i<inpWithSmallChars.length)
			Assert.assertEquals(outWithSmallChars[i], isUnique.isUnique2(inpWithSmallChars[i]));
		}
	}

}
