/**
 * 
 */
package ctci.chap8;

import java.util.ArrayList;

/**
 * @author manu
 *
 */
public class PowerSet {

	public ArrayList<ArrayList<Integer>> getSet(int[] set) {
		return getSetHelper(set, 0);
	}

	private ArrayList<ArrayList<Integer>> getSetHelper(int[] set, int index) {
		if (set.length == index) {
			ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
			out.add(new ArrayList<Integer>());
			return out;
		}

		ArrayList<ArrayList<Integer>> prevSubsets =  getSetHelper(set, index+1);
		ArrayList<ArrayList<Integer>> currSubsets =  new ArrayList<ArrayList<Integer>>();
		for(int i = 0 ;i<prevSubsets.size();i++)
		{
			ArrayList<Integer> subset = new ArrayList<>();
			subset.addAll(prevSubsets.get(i));
			subset.add(set[index]);
			currSubsets.add(subset);
		}
		currSubsets.addAll(prevSubsets);
		
		return currSubsets;
	}
}
