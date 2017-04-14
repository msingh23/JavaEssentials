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
	private boolean [] out ;
	private IsUnique isUnique;
	
	@Before
	public void setup() {
		inp = new String[]{"abcde","cc","c","hello", "apple", "kite", "padle"};
		out = new boolean [] {true,false, true,false,false,true,true};

	}
	
	@Test
	public void testUniqueString() {
		for(int i=0; i<inp.length; i++){
			Assert.assertEquals(out[i], isUnique.isUnique(inp[i]));
		}
	}

}
