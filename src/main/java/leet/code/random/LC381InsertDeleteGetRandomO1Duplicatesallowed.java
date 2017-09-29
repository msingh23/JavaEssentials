/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC381InsertDeleteGetRandomO1Duplicatesallowed {

	

    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public LC381InsertDeleteGetRandomO1Duplicatesallowed() {
        map = new HashMap<Integer, Set<Integer>>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ans = true;
        if(map.containsKey(val) && map.get(val).size() >0) ans = false;
        if(!map.containsKey(val))
        {
            map.put(val, new LinkedHashSet<Integer>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return ans;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        //System.out.println(map);
        if(!map.containsKey(val) || map.get(val).size() == 0) return false;
        Set<Integer> listIndex =  map.get(val);
        int indexToRemove = listIndex.iterator().next();
       
        //update map to reflect changes for the removes val
         listIndex.remove(indexToRemove);
       //update map to reflect changes for the swapped val
        if(indexToRemove != list.size() -1)
        {
            //swap
            list.set(indexToRemove,list.get(list.size() -1));
            Set<Integer> swappedList = map.get(list.get(indexToRemove));
            swappedList.remove(list.size() -1);
            swappedList.add(indexToRemove);
        }
        //remove last ement from list
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        
        Random ran = new Random();
        int index = ran.nextInt(list.size());
        return list.get(index);
    }
}
