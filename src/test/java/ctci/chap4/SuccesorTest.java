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
public class SuccesorTest {

	/**
	 * @throws java.lang.Exception
	 */

	public Succesor handler;
	public BinaryTree tree;

	@Before
	public void setUp() throws Exception {

		handler = new Succesor();

		tree = new BinaryTree(5);
		tree.add(tree.root, 3);
		tree.add(tree.root, 8);
		tree.add(tree.root, 9);
		tree.add(tree.root, 2);
		tree.add(tree.root, 4);
		tree.add(tree.root, 1);
	}

	@Test
	public void test() {

		Assert.assertEquals(5, handler.getSuccessor(tree.root, tree.root.left.right).value);
		Assert.assertEquals(null, handler.getSuccessor(tree.root, tree.root.right.right));
		Assert.assertEquals(9, handler.getSuccessor(tree.root, tree.root.right).value);
	}

}
