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
	
	/*
	 * 
	 * total subset can be calculated by either including an element in a set ot not. so [2 * 2 * 2 * .....2nth*] = 2^n
	 * 
	 * 
	 */
	
	public ArrayList<ArrayList<Integer>> getSetsBinary(int[] set)
	{
		ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
		int totalSets = 1<<set.length;
		for(int i = 0 ; i<totalSets; i++)
		{
			ArrayList<Integer> subSet = getSubSets(set, i);
			sets.add(subSet);
		}
		return sets;
	}

	private ArrayList<Integer> getSubSets(int[] set, int i) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		while(i>0)
		{
			if((i & 1) == 1){
				subset.add(set[index]);
			}
			index++;
			i= i>>1;
		}
		return subset;
	}
}
