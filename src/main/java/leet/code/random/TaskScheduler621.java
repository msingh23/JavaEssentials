/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author manu
 *
 */
public class TaskScheduler621 {

//public int leastInterval(char[] tasks, int n) {
//        
//        Integer [] freq = new Integer [26];
//        Arrays.fill(freq, 0);
//        for(int i = 0 ; i <tasks.length; i++)
//        {
//            freq[tasks[i]-'A']+=1;
//        }
//        Arrays.sort(freq,Collections.reverseOrder());
//        
//        boolean empty = false;
//        int cooling = n+1;
//        int totalInterval= 0;
//        while(!empty)
//        {   empty = true;
//            cooling = n+1;
//            for(int i = 0 ; i <26 && cooling>0 ; i ++)
//            {
//                if(freq[i]>0){
//                    empty= false;
//                    freq[i]-=1;
//                    cooling--; 
//                    totalInterval++;
//                }
//                
//            }
//            if(cooling>0 && !isEmpty(freq))
//            {
//                totalInterval+=cooling;
//                
//            }
//            System.out.println(totalInterval);
//        }
//        return totalInterval;
//    }
//
//private boolean isEmpty(Integer[] freq) {
//	
//	for(int i = 0 ;i < freq.length;i++)
//	{
//		if(freq[i]>0)
//		{
//			return false;
//		}
//	}
//	return true;
//}
	
	public int leastInterval(char[] tasks, int n) {
		int [] freq = new int [26];
		for(int i = 0 ; i <tasks.length ;i++ )
		{
			freq[tasks[i]-'A']+=1;
		}
		
		PriorityQueue<Integer> pTask = new PriorityQueue<Integer>((a,b)->b-a);
		for(int i = 0 ; i <26 ;i++ )
		{
			if(freq[i]>0)
			{
				pTask.add(freq[i]);
			}
		}
		int window = n+1;
		
		int total = 0;
		while(!pTask.isEmpty())
		{
			ArrayList<Integer> list = new ArrayList<Integer>();
			window = n+1;
			while(window>0 && !pTask.isEmpty())
			{
				list.add(pTask.poll());
				window--;
			}
			
			for(int i = 0 ;i<list.size();i++)
			{
				int val = list.get(i);
				val--;
				total++;
				if(val>0)
				{
					pTask.add(val);
				}
			}
			
			if(!pTask.isEmpty())
			total+=window;
		}
		return total;
	}

public static void main(String[] args) {
	TaskScheduler621 t = new TaskScheduler621();
	System.out.println(t.leastInterval(new char[]{'A','A','A','A','A','A','A','A','A','A','A','A','B','B','B','B','B','B','B','B','B','B','B','B','C','C','C'}, 1));
}
	
}
