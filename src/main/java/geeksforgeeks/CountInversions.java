/**
 * 
 */
package geeksforgeeks;

/**
 * @author manu
 *
 */
public class CountInversions {

	public int getInversion(int [] arr){
	
		int count = 0;
		for(int i = 0 ; i < arr.length -1 ; i++){
		
			for(int j = i+1; j < arr.length ; j++){
				if(arr[i]>arr[j]){
					count++;
				}
			}
		}
		return count;
		
	}
	
	public int getInversionMerge(int [] arr){
		
		
		//int mid = arr.length-1/2;
		
		return mergeCountInv(arr, 0,arr.length-1);
	}

	private int mergeCountInv(int[] arr, int start,  int end) {
		
		 int countInv = 0;
		if(start<end){
			int mid = start+ (end-start)/2;
			countInv = mergeCountInv(arr, start, mid);
			countInv += mergeCountInv(arr, mid+1, end);
			countInv += merge(arr, start, mid, end);
		}
		return countInv;
	}

	private int merge(int[] arr, int start, int mid, int end) {
		
		int [] temp = new int [end-start+1];
		int first = start;
		int second = mid+1;
		int point = 0;
		int count = 0;
		
		while(first<=mid && second<=end){
			if(arr[first]>arr[second]){
				count +=mid-first+1;
				temp[point++] = arr[second++];
			}else {
				temp[point++] = arr[first++];
			}
			
		}
		
		while(first<=mid)
		{
			temp[point++] = arr[first++];
		}
		while(second<=end)
		{
			temp[point++] = arr[second++];
			
		}
		
		for(int i = start; i <= end ; i++)
		{
			arr[i] = temp[i-start];
		}
		return count;
	}
	
}
