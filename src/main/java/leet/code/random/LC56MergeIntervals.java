/**
 * 
 */
package leet.code.random;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author manu
 *
 */


 class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }


public class LC56MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
        	@Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
                
        });
        
        List<Interval> out = new LinkedList<>();
        if(intervals.size() ==0) return out;
        Interval prev = intervals.get(0);
        out.add(prev);
        for(int i = 1 ;i <intervals.size(); i++)
        {
            Interval curr = intervals.get(i);
             //case 1: no overlap 
            if(prev.end < curr.start )
            {
                out.add(curr);
                prev = curr;
            } //case 2: half overlap
            else if(prev.end >= curr.start && prev.end < curr.end && prev.start <= curr.start )
            {
                out.get(out.size()-1).end = curr.end;
                prev = out.get(out.size()-1);
            }
           //else full overlap do nothing
            
        }
           
        return out;
    }
	
}
