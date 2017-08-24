/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author manu
 *
 */
public class LC352DataStreamasDisjointIntervals {

	
	/**
	 * Definition for an interval.
	 * */
	  public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
	  
	 
	  public class SummaryRanges {
		   //Set<Interval> intervals = new HashSet<Interval>();
		   TreeMap<Integer, Interval> mp = new TreeMap<Integer, Interval>((a,b)->a-b);
		   
		    
		    public class IntervalMerger{
		        Interval curr = null;
		        Interval prev = null;
		    }

		    /** Initialize your data structure here. */
		    public SummaryRanges() {
		        
		        
		        
		    }
		    
		    public void addNum(int val) {
	            
	            if(mp.containsKey(val)) return;
		        Integer prev = mp.lowerKey(val);
		        Integer after = mp.higherKey(val);
		        if (prev!=null && after!=null && mp.get(prev).end+1 ==val && mp.get(after).start ==val+1) {
	             
	                mp.get(prev).end =mp.get(after).end;
	                mp.remove(after);
	            }
	                
		        else if(prev!=null && mp.get(prev).end+1 >=val) {
	                mp.get(prev).end = Math.max(mp.get(prev).end, val);
		        }
		        else if(after!=null && mp.get(after).start ==val+1){
	                mp.put(val, new Interval(val, mp.get(after).end));
	                mp.remove(after);
		        } 
		        else {
		            Interval curr = new Interval(val, val);
		            mp.put(val, curr);
		    }
		    }  
		    public List<Interval> getIntervals() {
	            
		        return new ArrayList<>(mp.values());
		        
		    }
		    
		    
		    public void print(List<Interval> ls){
		    	for(Interval i : ls){
		    		System.out.print("[" + i.start +","+i.end+"]");
		    		System.out.print(",");
		    		
		    		
		    	}
		    	System.out.println();
		    }     
	    }
	        
	  

	public static void main(String[] args) {
		LC352DataStreamasDisjointIntervals ds = new LC352DataStreamasDisjointIntervals();
		SummaryRanges sr = ds.new SummaryRanges();
		sr.addNum(1);
		sr.print(sr.getIntervals());
		sr.addNum(3);
		sr.print(sr.getIntervals());
		sr.addNum(7);
		sr.print(sr.getIntervals());
		sr.addNum(2);
		sr.print(sr.getIntervals());
		sr.addNum(6);
		sr.print(sr.getIntervals());
		
	}
	
}
