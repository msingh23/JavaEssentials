package ctci.chap5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryToStringTest {

	BinaryToString handler;

	@Before
	public void setUp() throws Exception {
		handler = new BinaryToString();
	}

	@Test
	public void test() {
		System.out.println(handler.getBinary(new Double(.32)));
		System.out.println(handler.printBinary(new Double(.32)));
	}

}
