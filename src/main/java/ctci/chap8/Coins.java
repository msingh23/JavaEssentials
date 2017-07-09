/**
 * 
 */
package ctci.chap8;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author manu
 *
 */
public class Coins {

	public enum coins {
		quarter(25), dime(10), nickel(5), penny(1);

		int value;

		coins(int cent) {
			this.value = cent;
		}

		int getValue() {
			return value;
		}
	}

	public ArrayList<ArrayList<coins>> representCents(int cent) {
		ArrayList<ArrayList<coins>> out = new ArrayList<ArrayList<coins>>();
		ArrayList<coins> curr = new ArrayList<coins>();
		representCentsHelper(cent, 0, out, curr, 0);
		return out;
	}

	private void representCentsHelper(int amount, int val, ArrayList<ArrayList<coins>> out, ArrayList<coins> curr,
			int index) {

		if (val >= amount) {
			if (val == amount) {
				ArrayList<coins> temp = new ArrayList<coins>(curr);
				out.add(temp);
			}
		} else {
			for (int i = index; i < 4; i++) {

				if (i == 0) {
					curr.add(coins.quarter);
					representCentsHelper(amount, val + coins.quarter.value, out, curr, i);
					curr.remove(curr.size() - 1);
				} else if (i == 1) {
					curr.add(coins.dime);
					representCentsHelper(amount, val + coins.dime.value, out, curr, i);
					curr.remove(curr.size() - 1);
				} else if (i == 2) {
					curr.add(coins.nickel);
					representCentsHelper(amount, val + coins.nickel.value, out, curr, i);
					curr.remove(curr.size() - 1);
				} else if (i == 3) {
					curr.add(coins.penny);
					representCentsHelper(amount, val + coins.penny.value, out, curr, i);
					curr.remove(curr.size() - 1);
				}

			}
		}

	}

	public ArrayList<ArrayList<coins>> representCentsMemoization(int cent) {
		HashMap<Integer, ArrayList<ArrayList<coins>>> mem = new HashMap<Integer, ArrayList<ArrayList<coins>>>();
		return representCentsMemoizationHelper(cent, cent, mem);
	}

	private ArrayList<ArrayList<coins>> representCentsMemoizationHelper(int total, int curr,
			HashMap<Integer, ArrayList<ArrayList<coins>>> mem) {
		// TODO Auto-generated method stub

		if (curr <= 0) {
			if (curr == 0) {
				ArrayList<coins> list = new ArrayList<coins>();
				ArrayList<ArrayList<coins>> out = new ArrayList<ArrayList<coins>>();
				out.add(list);
				mem.put(0, out);
			} else {
				return null;
			}

		} else {
			if (!mem.containsKey(curr)) {
				mem.put(curr, new ArrayList<ArrayList<coins>>());
				for (int i = 0; i < 4; i++) {
					ArrayList<ArrayList<coins>> prev = null;
					if (i == 0) {
						prev = representCentsMemoizationHelper(total, curr - coins.penny.value, mem);
						if (prev != null) {
							for (ArrayList<coins> coin : prev) {
								ArrayList<coins> temp = new ArrayList<>(coin);
								temp.add(coins.penny);
								mem.get(curr).add(temp);
							}

						}
					} else if (i == 1) {
						prev = representCentsMemoizationHelper(total, curr - coins.nickel.value, mem);
						if (prev != null) {
							for (ArrayList<coins> coin : prev) {
								ArrayList<coins> temp = new ArrayList<>(coin);
								temp.add(coins.nickel);
								mem.get(curr).add(temp);
							}
						}
					} else if (i == 2) {
						prev = representCentsMemoizationHelper(total, curr - coins.dime.value, mem);
						if (prev != null) {
							for (ArrayList<coins> coin : prev) {
								ArrayList<coins> temp = new ArrayList<>(coin);
								temp.add(coins.dime);
								mem.get(curr).add(temp);
							}
						}
					} else if (i == 3) {
						prev = representCentsMemoizationHelper(total, curr - coins.quarter.value, mem);
						if (prev != null) {
							for (ArrayList<coins> coin : prev) {
								ArrayList<coins> temp = new ArrayList<>(coin);
								temp.add(coins.quarter);
								mem.get(curr).add(temp);
							}
						}
					}
					// if(prev!=null){
					// mem.get(curr).add(prev);
					// //mem.put(curr, );
					// }
				}

			}

		}
		return mem.get(curr);
	}

	public ArrayList<ArrayList<Integer>> representCentsSimple(int n) {
		int[] denom = new int[] { 1, 5, 10, 25 };
		// ArrayList<ArrayList<Integer>> out = new
		// ArrayList<ArrayList<Integer>>();
		HashMap<Integer, ArrayList<ArrayList<Integer>>> mem = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
		representCentsSimpleHandler(n, n, mem, 0, denom);
		return mem.get(n);
	}

	private void representCentsSimpleHandler(int val, int change, HashMap<Integer, ArrayList<ArrayList<Integer>>> mem, int index, int[] denom) {
		
		ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
		if(change<0){
			return;
		}
		if(change ==0)
		{
			out.add(new ArrayList<Integer>());
			mem.put(change, out);
		}
		else{
			if(!mem.containsKey(change))
			{
				for(int i = index; i<denom.length; i++ ){
					
					representCentsSimpleHandler(val, change - denom[i], mem, index, denom);
					
					if(mem.containsKey(change - denom[i])){
						
						for(ArrayList<Integer> prev : mem.get(change - denom[i])){
							ArrayList<Integer> temp = new ArrayList<Integer>(prev);
							if(temp.size() >0 && temp.get(temp.size()-1)>denom[i]) break;
							temp.add(denom[i]);
							out.add(temp);
						}
						mem.put(change, out);
					}
				}
			}
		}
		
	}

	

}
