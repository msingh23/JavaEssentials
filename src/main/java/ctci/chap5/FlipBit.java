/**
 * 
 */
package ctci.chap5;

/**
 * @author manu
 *
 */
public class FlipBit {

	public int getLongestSequence(int no) {
		int max = 0;
		int consOnes = 0;
		int curr = 0;
		boolean flip = false;
		int mask = 1;
		int prevBit = -1;
		int currBit = -1;

		while (no > 0) {

			currBit = no & mask;

			if (currBit == 1) {
				consOnes++;
				curr++;
			} else if (currBit == 0) {
				if (!flip) {
					flip = true;
					curr = consOnes;
					consOnes = 0;
				} else {
					if (prevBit == 0) {
						consOnes = 0;
					}
					curr = consOnes;
				}
			}
			prevBit = currBit;
			if (curr + 1 > max) {
				max = curr + 1;
			}

			no = no >>> 1;
		}
		/*
		 * if (!flip) { if (consOnes > max) { max = consOnes; } }
		 */

		return max;
	}

	public int getLongestSequenceSimple(int n) {
		if (n == -1) {
			return Integer.BYTES * 8;
		}
		int max = 0;
		int prevOnes = 0;
		int currOnes = 0;
		while (n > 0) {

			if ((n & 1) == 1) {
				currOnes++;
			} else {
				prevOnes = (n >> 2) == 0 ? 0 : currOnes;
				currOnes = 0;

			}
			max = Math.max(1 + prevOnes + currOnes, max);
			n = n >>> 1;
		}
		return max;
	}

}
