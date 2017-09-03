/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC374GuessNumberHigherorLower {

	public int guessNumber(int n) {

		int start = 1;
		int end = n;
		int mid = n;
		mid = start + (end - start) / 2;
		int response = guess(mid, n);

		while (response != 0) {
			if (response == -1) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			mid = start + (end - start) / 2;
			response = guess(mid, n);
		}

		return mid;

	}

	private int guess(int mid, int n) {

		return n == mid ? 0 : n < mid ? -1 : 1;
	}
}
