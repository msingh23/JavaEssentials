/**
 * 
 */
package ctci.starter;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author manu
 *
 */
public class TestRunner {

	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTests.class);
		for(Failure fail : result.getFailures()){
			System.out.println(fail.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
