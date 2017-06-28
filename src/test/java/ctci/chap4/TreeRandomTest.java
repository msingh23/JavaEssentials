/**
 * 
 */
package ctci.chap4;

import org.junit.Before;
import org.junit.Test;

/**
 * @author manu
 *
 */
public class TreeRandomTest {

	public TreeRandom handler;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		handler = new TreeRandom();
		handler.insert(10);
		handler.insert(15);
		handler.insert(5);
		handler.insert(3);
		handler.insert(4);
	}

	@Test
	public void test() throws Exception {
	    handler.printDataAndSize();
	    System.out.println();
		//System.out.println(handler.find(handler.root, 4).data);
		System.out.println("	"+handler.random().data);
		System.out.println("	"+handler.random().data);
		System.out.println("	"+handler.random().data);
		System.out.println("	"+handler.random().data);
		System.out.println("	"+handler.random().data);
		System.out.println("	"+handler.random().data);
		System.out.println("	"+handler.random().data);
		System.out.println("	"+handler.random().data);
		System.out.println("	"+handler.random().data);
		System.out.println("	"+handler.random().data);
		System.out.println("	"+handler.random().data);
		
	}

}
