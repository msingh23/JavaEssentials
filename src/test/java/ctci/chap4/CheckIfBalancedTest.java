package ctci.chap4;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CheckIfBalancedTest {

	public CheckIfBalanced handler;
	public BinaryTree tree;
	public BinaryTree tree2;
	public BinaryTree tree3;

	@Before
	public void setUp() throws Exception {

		handler = new CheckIfBalanced();
		tree = new BinaryTree(5);
		tree.add(tree.root, 3);
		tree.add(tree.root, 8);
		tree.add(tree.root, 9);
		tree.add(tree.root, 2);
		tree.add(tree.root, 4);
		tree.add(tree.root, 1);

		tree2 = new BinaryTree(5);
		tree2.add(tree2.root, 3);
		tree2.add(tree2.root, 8);
		tree2.add(tree2.root, 2);
		tree2.add(tree2.root, 1);

		tree3 = new BinaryTree(5);
		tree3.add(tree3.root, 3);
		tree3.add(tree3.root, 2);
		tree3.add(tree3.root, 4);
		tree3.add(tree3.root, 1);
	}

	@Test
	public void test() {
		Assert.assertEquals(handler.checkIfBalanced(tree.root) == -1, false);
		Assert.assertEquals(handler.checkIfBalanced(tree2.root) == -1, true);
		Assert.assertEquals(handler.checkIfBalanced(tree3.root) == -1, true);
	}

}
