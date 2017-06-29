package ctci.chap5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class InsertionTest {

	public Insertion handler;
	int m;
	int n;
	int ans;

	@Before
	public void setUp() throws Exception {
		handler = new Insertion();
		m = (int) (Math.pow(2, 10));
		n = (int) (int) (Math.pow(2, 4) + (int) Math.pow(2, 0) + (int) Math.pow(2, 1));
		ans = (int) (Math.pow(2, 10)) + (int) Math.pow(2, 6) + (int) Math.pow(2, 3) + (int) Math.pow(2, 2);
	}

	@Test
	public void test() {
		Assert.assertEquals(ans, handler.insertion(m, n, 6, 2));
	}

}
