/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC53MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int n = nums.length;
		if (n <= 0)
			return 0;
		int sum = nums[0];
		if (max < sum)
			max = sum;
		for (int i = 1; i < n; i++) {
			if (sum + nums[i] < nums[i]) {
				sum = Math.max(nums[i], sum);
			} else {
				sum += nums[i];
			}

			if (max < sum)
				max = sum;
		}

		return max;
	}
}
