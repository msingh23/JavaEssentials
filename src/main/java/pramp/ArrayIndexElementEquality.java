/**
 * 
 */
package pramp;

/**
 * @author manu
 *
 */
public class ArrayIndexElementEquality {

	
	public int getEqualityIndex(int [] inp){
		
		return binarySearch(inp, 0 , inp.length);
		
		
	}
	
	public int binarySearch(int [] inp, int start, int end){
		
		if(start<=end){
			
			int mid = start + (end - start) / 2;
			
			if(inp[mid]==mid){
				return mid;
			}
			else if(inp[mid]>mid){
				return binarySearch(inp, start, mid-1);
			}
			else if(inp[mid] < mid){
				return binarySearch(inp, mid + 1, end);
			}
			
		}
		return -1;
	}
	
}
