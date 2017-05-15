package ctci.chap1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class StringRotationTest {

	private String in1[];
	private String in2[];
	private boolean out[];
	private StringRotation handler;

	@Before
	public void setUp() throws Exception {

		handler = new StringRotation();
		in1 = new String[] { "waterbottle", "waterbottle", "waterbottle", "stackoverflow", "stackoverflow",
				"stackoverflow", "stackoverflow", "ABCD", "ABCD","" };
		in2 = new String[] { "erbottlewat", "ottlewaterb", "bottlewater", "tackoverflows", "stackoverflwo",
				"ackoverflowst", "ackoverflowst", "CDAB", "ACBD","" };
		out = new boolean[] { true, true, true, true, false, true, true, true, false,false };
	}

	@Test
	public void test() {
		for (int i = 0; i < in1.length; i++) {
			//System.out.println(in1[i] + " , " + in2[i]);
			Assert.assertEquals(out[i], handler.isStringRotate(in1[i], in2[i]));
		}
	}

}
