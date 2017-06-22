package ctci.exta;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapSortTest {

	public HeapSort handler;
	int[] in;
	int[] outDesc;
	int[] outAsc;

	@Before
	public void setUp() throws Exception {
		handler = new HeapSort();
		in = new int[] { 13, 7, 6, 45, 21, 9, 2, 100 };
		outDesc = new int[] { 100, 45, 21, 13, 9, 7, 6, 2 };
		outAsc = new int[] { 2, 6, 7, 9, 13, 21, 45, 100 };
	}

	@Test
	public void testSortAsc() throws Exception {
		handler.sort(in, 0);
		Assert.assertArrayEquals(in, outAsc);
	}

	@Test
	public void testSortDsc() throws Exception {
		handler.sort(in, 1);
		Assert.assertArrayEquals(in, outDesc);
	}

}
