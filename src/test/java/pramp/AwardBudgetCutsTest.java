/**
 * 
 */
package pramp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author manu
 *
 */
public class AwardBudgetCutsTest {

	/**
	 * @throws java.lang.Exception
	 */
	public AwardBudgetCuts handler;
	double  [] grants;
	double  [] grants1;
	double newBudget;
	@Before
	public void setUp() throws Exception {
		handler = new AwardBudgetCuts();
		grants = new double [] {2, 100, 50, 120, 1000};
		grants1 = new double [] {20, 40 , 60};
		newBudget = 190;
		
	}

	@Test
	public void test() {
		Assert.assertEquals(47.0, handler.getAwardCap(grants, newBudget));
		Assert.assertEquals(60.0, handler.getAwardCap(grants1, newBudget));
	}

}
