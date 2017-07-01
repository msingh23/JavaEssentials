/**
 * 
 */
package pramp;

import java.util.Arrays;

/**
 * @author manu
 *
 */
public class AwardBudgetCuts {

	public double getAwardCap(double[] grants, double newBudget) {
		Arrays.sort(grants);
		double prevSum = 0;
		double cap = 0;
		int totalGrants = grants.length;
		for (int i = 0; i < totalGrants; i++) {
			cap = grants[i];
			double createBudget = prevSum + cap * (totalGrants - i);
			if (createBudget < newBudget) {
				prevSum += cap;
			} else if (createBudget > newBudget) {
				cap = (newBudget - prevSum) / (totalGrants - i);
				break;
			} else {
				break;
			}
		}
		return cap;
	}

}
