package ctci.chap5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ConversionTest {

	public Conversion handler;
	int x;
	int y ;
	int z;
	int v;
	int p;
	int q;
	
	
	@Before
	public void setUp() throws Exception {
		handler = new Conversion();
		x = 29;
		y = 15;
		z = 0;
		v = 0;
		p = 1;
		q = 0;
	}

	@Test
	public void test() {
		Assert.assertEquals(2, handler.getDifferenceOfBits(x, y));
		Assert.assertEquals(0, handler.getDifferenceOfBits(z, v));
		Assert.assertEquals(1, handler.getDifferenceOfBits(p, q));
	}

}
