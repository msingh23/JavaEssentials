package ctci.chap5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class NextNumberTest {

	public NextNumber handler;
	int n1 = 44;
	int n2 = 27;
	int out[];
	@Before
	public void setUp() throws Exception 
	{
		handler = new NextNumber();
		out = new int []{42, 49, 23, 29};
	}
	

	@Test
	public void test() {
		int [] o1 = handler.getNext(n1);
		int [] o2 = handler.getNext(n2);
		Assert.assertEquals(o1[0], 42);
		Assert.assertEquals(o1[1], 49);
		Assert.assertEquals(o2[0], 23);
		Assert.assertEquals(o2[1], 29);
		
	}

}
