package Q5_02_Binary_to_String;

public class Question {
	public static final String ERROR = "ERROR";
	public static final int RESULT_THRESHOLD = 32;

	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return ERROR;
		}

		StringBuilder binary = new StringBuilder(".");
		while (num > 0) {
			if (binary.length() > RESULT_THRESHOLD) {
				return ERROR;
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
			return ERROR;
		}

		StringBuilder binary = new StringBuilder(".");
		double frac = 0.5;
		while (num > 0) {
			if (binary.length() > RESULT_THRESHOLD) {
				return ERROR;
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

	public static String printBinary3(double num) {
		if (num >= 1 || num <= 0) {
			return ERROR;
		}

		StringBuilder binary = new StringBuilder(".");
		while (num != (int) num) {
			if (binary.length() > 32) {
				return ERROR;
			}
			num *= 2;
			binary.append((int) num % 2);
		}
		return binary.toString();
	}

	public static void main(String[] args) {
		String bs = printBinary(.125);
		System.out.println(bs);

		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = printBinary(num);
			String binary2 = printBinary2(num);
			String binary3 = printBinary3(num);
			if (!binary.equals(ERROR) || !binary2.equals(ERROR) || !binary3.equals(ERROR)) {
				System.out.println(num + " \t: " + binary + " \t " + binary2 + " \t " + binary3);
			}
		}
	}
}
