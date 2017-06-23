package ctci.chap4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BuildMinimalTreeTest {

	public BuildMinimalTree handler;
	int inp[];

	@Before
	public void setUp() throws Exception {
		handler = new BuildMinimalTree();
		inp = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	}

	@Test
	public void test() {
		BinaryTree bt = new BinaryTree(1);
		bt.root = handler.buildminimalTree(inp, 0, inp.length - 1);
		Assert.assertEquals(bt.getHeight(bt.root), 4);
	}

}
