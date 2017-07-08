package ctci.chap8;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TowerOfHanoiTest {
	
	public TowerOfHanoi handler;
	
	Stack<Integer> A ;
	Stack<Integer> B ;
	Stack<Integer> C ;
	Stack<Integer> out ;
	@Before
	public void setUp() throws Exception {
		handler = new TowerOfHanoi();
		A  = new Stack<Integer>();
		A.push(4);A.push(3);A.push(2);A.push(1);
		B = new Stack<Integer>();
		C = new Stack<Integer>();
		out = new Stack<Integer>();
		out.addAll(A);
		

	}

	@Test
	public void test() {
		handler.towerOfHanoi(A, B, C);
		while(!C.isEmpty()){
			Assert.assertEquals(out.pop(), C.pop());
		}
	}

}
