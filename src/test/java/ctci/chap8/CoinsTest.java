package ctci.chap8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CoinsTest {
	
	
	public Coins handler;
	int [] in;
	int [] out;
	
	@Before
	public void setUp() throws Exception {
		handler= new Coins();
		in = new int []{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14, 15,20, 99};
		out = new int[]{1,1,1,1,1,2,2,2,2,2,4, 4, 4,  4,4, 6,9,213};
	}

	@Test
	public void test() {
		for(int i = 0 ; i< in.length ;i++)
		{
			Assert.assertEquals(out[i], handler.representCentsSimple(in[i]).size());
			Assert.assertEquals(out[i], handler.getWays(in[i]));
			
		}
	}

}
