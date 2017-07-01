/**
 * 
 */
package pramp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author manu
 *
 */
public class FindTheDuplicates {

	public int [] getDuplicatesMequalsN(int [] arr1, int [] arr2){
		int m = 0;
		int n = 0;
		ArrayList<Integer> out = new ArrayList<Integer>();
		while(m < arr1.length && n < arr2.length){
			if(arr1[m] == arr2[n]){
				out.add(arr1[m]);
				m++; n++;
			}
			else if(arr1[m] < arr2[n]){
				m++;
			}else{
				n++;
			}
		}
		
		
		return getArrayFromList(out);
	}
	public int [] getArrayFromList(List <Integer> out){
		int [] outArray = new int [out.size()];
		int start = 0;
		for(Integer i : out){
			outArray[start++] = i;
		}
		return outArray;
	}
	
	public int [] getDuplicatesMGreaterN(int [] inp1, int [] inp2){
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		for(int i = 0 ; i <inp2.length ; i++){
			if(isExistBS(inp1, inp2[i])){
				out.add(inp2[i]);
			}
		}
		
		return getArrayFromList(out);
	}
	
	public boolean isExistBS(int [] inp1, int find){
		
		return binarySearch(inp1, 0, inp1.length-1, find);
		
	}
	
	public boolean binarySearch(int [] inp1, int start, int end, int find){
		while(start<=end){
			int mid = start + (end - start) /2 ;
			if(inp1[mid]==find){
				return true;
			}
			else if(inp1[mid] < find){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		
		return false;
	}
	
}
