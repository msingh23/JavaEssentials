/**
 * 
 */
package ctci.chap4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author manu
 *
 */
public class ValidateBSTTest {

	/**
	 * @throws java.lang.Exception
	 */

	public ValidateBST handler;
	public BinaryTree tree;
	public BinaryTree tree2;
	public BinaryTree tree3;
	public BinaryTree tree4;

	@Before
	public void setUp() throws Exception {
		handler = new ValidateBST();

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
		tree2.root.left.left.value = 100;

		tree3 = new BinaryTree(5);
		tree3.add(tree3.root, 3);
		tree3.add(tree3.root, 2);
		tree3.add(tree3.root, 4);
		tree3.add(tree3.root, 1);
		tree3.root.value = 3;

		tree4 = new BinaryTree(10);
		tree4.add(tree4.root, 15);
		tree4.add(tree4.root, 14);
		tree4.add(tree4.root, 5);
		tree4.add(tree4.root, 6);
		tree4.add(tree4.root, 3);
		tree4.add(tree4.root, 8);
		tree4.add(tree4.root, 7);
		tree4.root.right.left.value = 8;
		tree4.root.left.right.right.value = 70;
		tree4.root.left.right.right.left.value = -1;

	}

	@Test
	public void test() {
		Assert.assertEquals(true, handler.isBST(tree.root));
		Assert.assertEquals(false, handler.isBST(tree2.root));
		Assert.assertEquals(false, handler.isBST(tree3.root));
		Assert.assertEquals(false, handler.isBST(tree4.root));
	}

}
