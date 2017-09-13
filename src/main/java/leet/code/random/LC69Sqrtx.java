/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC69Sqrtx {

	public int mySqrt(int x) {
		if (x == 1 || x == 0)
			return x;
		return isPerfectSquare(x, 1, x);
	}

	public int isPerfectSquare(int num, int start, int end) {

		if (start <= end) {
			int sqrt = start + (end - start) / 2;
			if (num / sqrt == sqrt)
				return sqrt;
			if ((num / sqrt) < sqrt)
				return isPerfectSquare(num, start, sqrt - 1);
			else if ((num / (sqrt + 1)) < sqrt + 1)
				return sqrt;
			else
				return isPerfectSquare(num, sqrt + 1, end);
		}
		return start;
	}

}
