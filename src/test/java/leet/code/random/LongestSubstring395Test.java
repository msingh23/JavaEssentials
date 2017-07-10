package leet.code.random;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LongestSubstring395Test {

	public LongestSubstring395 handler;
	String inp []; 
	int [] k;
	int out[];
	@Before
	public void setUp() throws Exception {
		handler = new LongestSubstring395();
		inp = new String [] {"aaabbbcdefcdefgggggggggggggggcde"};
		k = new int []{3};
		out = new int []{15};
		}
		
	

	@Test
	public void test() {
		for(int i = 0 ; i < inp.length; i++)
		{
			Assert.assertEquals(out[i], handler.longestSubstring(inp[i], k[i]));
		}
	}

}
