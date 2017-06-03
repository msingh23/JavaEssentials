/**
 * 
 */
package ctci.chap2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author manu
 *
 */
public class PalindromeTest {

	/**
	 * @throws java.lang.Exception
	 */
	private Palindrome handler;
	private LinkList<Character> in;
	private LinkList<Character> in2;

	@Before
	public void setUp() throws Exception {
		handler = new Palindrome();
		in = new LinkList<Character>('m');
		in.addNode('a');
		in.addNode('r');
		in.addNode('a');
		in.addNode('m');
		// in.addNode('a');
		// in.addNode('a');
		in2 = new LinkList<Character>('m');
		in2.addNode('a');
		in2.addNode('r');
		in2.addNode('a');
		in2.addNode('m');
		in2.addNode('a');
	}

	@Test
	public void test() {
		assertEquals(true, handler.isPalindrome(in.head));
		assertEquals(false, handler.isPalindrome(in2.head));
	}

	@Test
	public void test2() {
		assertEquals(false, handler.isPalindrome(in2.head));
	}

}