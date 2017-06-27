package ctci.chap4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class checkSubTreeTest {

	public CheckSubTree handler;

	public BinaryTree tree;
	public BinaryTree tree1;

	@Before
	public void setUp() {

		handler = new CheckSubTree();
		tree = new BinaryTree(6);
		tree.add(tree.root, 2);
		tree.add(tree.root, 8);
		tree.add(tree.root, 9);
		tree.add(tree.root, 7);
		tree.add(tree.root, 4);
		tree.add(tree.root, 5);
		tree.add(tree.root, 3);
		tree.add(tree.root, 1);
		// tree.add(tree.root, 1);

		tree1 = new BinaryTree(2);
		tree1.add(tree1.root, 4);
		tree1.add(tree1.root, 5);
	}

	@Test
	public void test() {
		Assert.assertEquals(true, handler.checkSubTree(tree.root, tree1.root));
	}

	@Test
	public void testPreOrder() {
		Assert.assertEquals(true, handler.checkSubTreePreOrder(tree.root, tree.root.left));
	}

}
