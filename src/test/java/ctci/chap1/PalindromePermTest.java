package ctci.chap1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromePermTest {

	private String[] in;
	private boolean[] out;
	private PalindromePerm handler;

	@Before
	public void setup() {

		in = new String[] { "Tact Coa" };
		out = new boolean[] { true };
		handler = new PalindromePerm();
	}

	@Test
	public void test() {

		for (int i = 0; i < in.length; i++) {
			Assert.assertEquals(out[i], handler.isPalindromePerm(in[i]));
		}

	}
	
	@Test
	public void test2() {

		for (int i = 0; i < in.length; i++) {
			Assert.assertEquals(out[i], handler.isPalindromePerm2(in[i]));
		}

	}

}
