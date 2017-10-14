/**
 * 
 */
package leet.code.random;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author manu
 *
 */
public class LC630CourseScheduleIII {

	 public int scheduleCourse(int[][] courses) {
	     
	        Arrays.sort(courses,(a,b)->(a[1]-b[1]));
	        PriorityQueue<int []> pq = new PriorityQueue<int[]>((a,b)->b[0]-a[0]);
	        int time =0;
	        for(int [] course : courses)
	        {
	            time+=course[0];
	            pq.add(course);
	            if(time>course[1])
	            {
	                time-=pq.poll()[0];
	            }
	        }
	        
	        return pq.size();
	        
	    }
	
}
