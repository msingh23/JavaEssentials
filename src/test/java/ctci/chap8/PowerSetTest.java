package ctci.chap8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PowerSetTest {
	
	public PowerSet handler;
	int [] set; 

	@Before
	public void setUp() throws Exception {
		handler = new PowerSet();
		set = new int[]{1,2,3, 4};
	}

	@Test
	public void test() {
		System.out.println(handler.getSet(set));
		System.out.println(handler.getSetsBinary(set));
	}

}
