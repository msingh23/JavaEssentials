/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author manu
 *
 */
public class LC380InsertDeleteGetRandomO1 {

	Map<Integer, Integer> map;
	List<Integer> list;

	/** Initialize your data structure here. */
	    public LC380InsertDeleteGetRandomO1() {
	        map = new HashMap<Integer, Integer>();
	        list = new ArrayList<Integer>();
	        
	    }

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val))
			return false;
		map.put(val, list.size());
		list.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;

		list.set(map.get(val), list.get(list.size() - 1));
		map.put(list.get(list.size() - 1), map.get(val));
		map.remove(val);
		list.remove(list.size() - 1);

		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Random rand = new Random();
		int randIndex = rand.nextInt(list.size());
		return list.get(randIndex);

	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
