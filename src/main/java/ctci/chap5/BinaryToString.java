/**
 * 
 */
package ctci.chap5;

/**
 * @author manu
 *
 */
public class BinaryToString {

	public String getBinary(Double inp) {
		if (inp < 0 || inp > 1) {
			return new String("Error");
		}

		StringBuffer buff = new StringBuffer(".");
		while (inp > 0) {
			inp = 2 * inp;
			if (buff.length() > 32) {
				return "Error";
			}

			if (inp >= 1) {
				buff.append("1");
				inp -= 1;
			} else {
				buff.append("0");
			}

		}

		return buff.toString();

	}
	
	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
	
	public static String printBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() >= 32) {
				return "ERROR";
			}
			if (num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	}	

}
