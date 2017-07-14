package geeksforgeeks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CountInversionTest {

	CountInversions handler;
	int [] arr;
	int out;
	@Before
	public void setUp() throws Exception {
		handler = new CountInversions();
		arr= new int []{2, 4, 1, 3, 5};
		out = 3;
	}

	@Test
	public void test() {
		Assert.assertEquals(out, handler.getInversionMerge(arr));
	}

}
