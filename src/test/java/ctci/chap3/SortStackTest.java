package ctci.chap3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SortStackTest {

	public SortStack handler;
	public Stack<Integer> stack;
	public Stack<Integer> ans;

	@Before
	public void setUp() throws Exception {
		handler = new SortStack();
		stack = new Stack<Integer>();
		ans = new Stack<Integer>();
		stack.push(5);
		stack.push(0);
		stack.push(11);
		stack.push(6);
		stack.push(9);
		stack.push(2);
		stack.push(12);

		ans.push(0);
		ans.push(2);
		ans.push(5);
		ans.push(6);
		ans.push(9);
		ans.push(11);
		ans.push(12);
	}

	@Test
	public void test() throws Exception {
		handler.sortN2(stack);
		assertTrue(StackUtils.equals(stack, ans));
	}

	@Test
	public void testNLogN() throws Exception {
		Stack sort = handler.SortStackNLogN(stack);
		assertTrue(StackUtils.equals(sort, ans));
	}

}
