/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC153FindMinimuminRotatedSortedArray {

	public int findMin(int[] nums) {

		int start = 0;
		int end = nums.length - 1;
		int pivot = -1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid > 0 && nums[mid] < nums[mid - 1]) {
				pivot = mid;
				break;
			}
			if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
				pivot = mid + 1;
				break;
			}

			if (nums[mid] > nums[start])
				start = mid + 1;
			else
				end = mid - 1;
		}

		if (pivot == -1)
			return nums[0];
		else
			return nums[0] < nums[pivot] ? nums[0] : nums[pivot];

	}

}
