/**
 * 
 */
package pramp;

/**
 * @author manu
 *
 */
import java.io.*;
import java.util.*;

class RotatedArray {

	public int getIndexShifterArray(int[] inp, int num) {
		int start = 0;
		int end = inp.length - 1;
		int mid = start + (end - start) / 2;

		while (start <= end) {
			if (inp[mid] == num)
				return mid;
			if (inp[0] > inp[mid] ) 
			{
				if(mid !=end && inp[mid+1] <=num && num<= inp[end])
				{
					start =  mid+1;
				}
				else
				{
					end = mid-1;
				}
			} else if(inp[start] <= num && num <= inp[mid])
			{
				end  = mid - 1;
			}else
			{
				start = mid + 1;
			}
			mid = start + (end - start) / 2;
		}
		return -1;
	}

	static int shiftedArrSearch(int[] shiftArr, int num) {

		int pivot = getPivotIndx(shiftArr);
		
		if (pivot == -1)
			return binarySearchIndex(shiftArr, 0, shiftArr.length - 1, num);;
		if ( num >= shiftArr[pivot] && num <= shiftArr[shiftArr.length - 1]) 
		{
			return binarySearchIndex(shiftArr, pivot, shiftArr.length - 1, num);
		} else
		{
			return binarySearchIndex(shiftArr, 0, pivot - 1, num);
		}

	}

	private static int binarySearchIndex(int[] inp, int start, int end, int num) {

		int mid = start + (end - start) / 2;

		while (start <= end) {
			if (inp[mid] == num)
			{
				return mid;
			} else if (num < inp[mid])
			{
				end = mid - 1;
			} else
			{
				start = mid + 1;
			}
			mid = start + (end - start) / 2;
		}

		return -1;
	}

	public static int getPivotIndx(int[] inp) {

		int start = 0;
		int end = inp.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (mid != 0 && inp[mid - 1] > inp[mid])
			{
				return mid;
			}
			else if (inp[0] > inp[mid]) 
			{
				end = mid - 1;
			} else 
			{
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

	}

}

/*
 * 
 * [1,2,3,4,5]
 * 
 * [2,3,4,5,1] [3,4,5,1,2] [4,5,1,2,3] [5,1,2,3,4]
 * 
 * [2, 4, 5, 9, 12, 17]
 * 
 * no = 4 shiftd = [9, 12, 17, 19, [2], 4, 5] int first = 19 int last = 5
 * 
 * [9, 12, 17, 2, 4, 5],
 * 
 * [15, 16, 17, 2, 4, 5, 12],
 * 
 * [12, 15, 16, 17, 2, 4, 5],
 * 
 * 
 * first , inp[mid] 9 , 17 inp[mid], last 17, 5 start = 3 end = 6 mid = 4
 * 
 * 
 * 
 * [start pivot] last
 * 
 */
