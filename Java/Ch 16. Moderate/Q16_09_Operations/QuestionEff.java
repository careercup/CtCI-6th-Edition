package Q16_09_Operations;

import CtCILibrary.AssortedMethods;
import java.util.function.IntBinaryOperator;

public class QuestionEff {
	/* a constant = -1 (hexadecimal notation is needed to avoid "-" operation) */
	private static final int NEGATIVE_ONE = 0xffffffff;
	/* bit shift operations (<<, >>, >>>) use only first 5 bits of right-side argument
	 * e.g., 5 >> 43 is the same as 5 >> 11 because 43 % 32 == 43 & 31 == 11 */
	private static final int SHIFT_MASK = 31;
	/* BITS[i] is an integer with i'th bit set to 1 (and other bits are 0) */
	private static final int[] BITS = new int[32];
	
	/* fill BITS array
	 * one-time preparation, O(WORD_SIZE) */
	static {
		int bit = 1;
		for (int i = 0; i < 32; i = inc(i)) {
			BITS[i] = bit;
			bit = shiftLeft(bit, 1);
		}
	}
	
	/* operator ++
	 * O(1) */
	public static int inc(int a) {
		return a + 1;
	}
	
	/* operator --
	 * O(1) */
	public static int dec(int a) {
		return a + NEGATIVE_ONE;
	}
	
	/* operator +
	 * O(1) */
	public static int add(int a, int b) {
		return a + b;
	}
	
	/* operator - (binary subtraction)
	 * O(WORD_SIZE) */
	public static int subtract(int a, int b) {
		return a + negate(b);
	}
	
	/* operator - (unary minus)
	 * O(WORD_SIZE) */
	public static int negate(int n) {
		return bitNot(n) + 1;
	}
	
	/* absolute value
	 * O(WORD_SIZE) */
	public static int abs(int n) {
		return n < 0 ? negate(n) : n;
	}
	
	/* operator ~ (inverse bits)
	 * O(WORD_SIZE) */
	public static int bitNot(int n) {
		return traverseBits(n, 0, (bit, zero)->bit == 0 ? 1 : 0);
	}
	
	/* operator &
	 * O(WORD_SIZE) */
	public static int bitAnd(int a, int b) {
		return traverseBits(a, b, (aBit, bBit)->aBit == 1 && bBit == 1 ? 1 : 0);
	}
	
	/* operator |
	 * O(WORD_SIZE) */
	public static int bitOr(int a, int b) {
		return traverseBits(a, b, (aBit, bBit)->aBit == 1 || bBit == 1 ? 1 : 0);
	}
	
	/* operator ^
	 * O(WORD_SIZE) */
	public static int bitXor(int a, int b) {
		return traverseBits(a, b, (aBit, bBit)->aBit == bBit ? 0 : 1);
	}
	
	/* loop over 2 integers, bit by bit, and construct a new integer according to bits returned by a callback function
	 * O(WORD_SIZE) */
	private static int traverseBits(int a, int b, IntBinaryOperator callback) {
		int result = 0;
		for (int i = 31; i >= 0; i = dec(i)) {
			int aBit = getBit(a, 31);
			int bBit = getBit(b, 31);
			int newBit = callback.applyAsInt(aBit, bBit);
			if (newBit == 1) {
				result = result + BITS[i];
			}
			a = shiftLeft(a, 1);
			b = shiftLeft(b, 1);
		}
		return result;
	}
	
	/* get requested bit of an integer
	 * example: getBit(3, 0) == getBit(3, 1) == 1, other positions return 0
	 * O(WORD_SIZE) in worst case, O(1) if position==31 */
	public static int getBit(int n, int position) {
		if (position < 0) {
			throw new ArithmeticException("Negative bit address");
		}
		if (position > 31) {
			throw new IndexOutOfBoundsException(position);
		}
		for (int p = position; p < 31; p = inc(p)) {
			n = shiftLeft(n, 1);
		}
		return n < 0 ? 1 : 0;
	}
	
	/* return a new integer with requested bit set to a given value
	 * O(WORD_SIZE) */
	public static int setBit(int n, int position, int newBit) {
		if (newBit<0 || newBit>1) {
			throw new IllegalArgumentException("Bit value must be 0 or 1");
		}
		int oldBit = getBit(n, position);
		if (oldBit == newBit) {
			return n;
		}
		if (oldBit == 0) {
			return n + BITS[position];
		}
		return subtract(n, BITS[position]);
	}
	
	/* check if given integer is even (0, 2, -2, 4, -4, etc.)
	 * O(WORD_SIZE) */
	public static boolean isEven(int n) {
		return getBit(n, 0) == 0;
	}
	
	/* check if given integer is odd (1, -1, 3, -3, etc.)
	 * O(WORD_SIZE) */
	public static boolean isOdd(int n) {
		return getBit(n, 0) == 1;
	}
	
	/* operator <<
	 * O(WORD_SIZE) in worst case, O(1) if shift==1 */
	public static int shiftLeft(int n, int shift) {
		if (shift < 0 || shift > 31) {
			shift = bitAnd(shift, SHIFT_MASK);
		}
		for (int s = 0; s < shift; s = inc(s)) {
			n = n + n;
		}
		return n;
	}
	
	/* generic implementation for >> and >>> operators
	 * O(WORD_SIZE) */
	private static int shiftRightGeneric(int n, int shift, boolean unsigned) {
		if (shift < 0 || shift > 31) {
			shift = bitAnd(shift, SHIFT_MASK);
		}
		if (shift == 0) {
			return n;
		}
		boolean negative = !unsigned && n < 0;
		int result = 0;
		int position = 31;
		for (int i = 31 + shift; i >= 0; i = dec(i)) {
			int bit;
			if (i > 31) {
				bit = negative ? 1 : 0;
			} else {
				bit = getBit(n, 31);
			}
			if (bit == 1) {
				result = result + BITS[position];
			}
			position = dec(position);
			if (position < 0) {
				break;
			}
			if (i <= 31) {
				n = shiftLeft(n, 1);
			}
		}
		return result;
	}
	
	/* operator >>
	 * O(WORD_SIZE) */
	public static int shiftRight(int n, int shift) {
		return shiftRightGeneric(n, shift, false);
	}
	
	/* operator >>>
	 * O(WORD_SIZE) */
	public static int shiftRightUnsigned(int n, int shift) {
		return shiftRightGeneric(n, shift, true);
	}
	
	/* operator *
	 * O(WORD_SIZE) */
	public static int multiply(int a, int b) {
		int result = 0;
		for (int i = 0; i < 32; i = inc(i)) {
			result = shiftLeft(result, 1);
			int bit = getBit(b, 31);
			if (bit == 1) {
				result = result + a;
			}
			b = shiftLeft(b, 1);
		}
		return result;
	}
	
	/* operator /
	 * O(WORD_SIZE**2) */
	public static int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("/ by zero");
		}
		if (a == 0) {
			return 0;
		}
		if (b == Integer.MIN_VALUE) {
			return a == Integer.MIN_VALUE ? 1 : 0;
		}
		if (b < 0) {
			return negate(divide(a, negate(b)));
		}
		if (a == Integer.MIN_VALUE) {
			return dec(divide(a + b, b));
		}
		if (a < 0) {
			return negate(divide(negate(a), b));
		}
		int result = 0;
		while (a >= b) {
			int candidate = b;
			for (int i = 0; i < 32; i = inc(i)) {
				int shifted = shiftLeft(candidate, 1);
				if (shifted < 0 || shifted > a) {
					result = result + BITS[i];
					break;
				}
				candidate = shifted;
			}
			a = subtract(a, candidate);
		}
		return result;
	}
	
	/* operator % (see BigInteger.remainder)
	 * O(WORD_SIZE**2) */
	public static int remainder(int a, int b) {
		return subtract(a, multiply(divide(a, b), b));
	}
	
	/* always non-negative remainder (see BigInteger.mod)
	 * O(WORD_SIZE**2) */
	public static int mod(int a, int b) {
		a = remainder(a, b);
		if (a < 0) {
			a = a + abs(b);
		}
		return a;
	}
	
	public static void main(String[] args) {
		int minRange = -100;
		int maxRange = 100;
		int cycles = 100;
		
		for (int i = 0; i < cycles; i++) {
			int a = AssortedMethods.randomIntInRange(minRange, maxRange);
			int b = AssortedMethods.randomIntInRange(minRange, maxRange);
			int ans = subtract(a, b);
			if (ans != a - b) {
				System.out.println("ERROR");
			}
			System.out.println(a + " - " + b + " = " + ans);
		}
		for (int i = 0; i < cycles; i++) {
			int a = AssortedMethods.randomIntInRange(minRange, maxRange);
			int b = AssortedMethods.randomIntInRange(minRange, maxRange);
			int ans = multiply(a, b);
			if (ans != a * b) {
				System.out.println("ERROR");
			}
			System.out.println(a + " * " + b + " = " + ans);
		}
		for (int i = 0; i < cycles; i++) {
			int a = AssortedMethods.randomIntInRange(minRange, maxRange);
			int b = AssortedMethods.randomIntInRange(minRange, maxRange);
			System.out.print(a + " / " + b + " = ");
			int ans = divide(a, b);
			if (ans != a / b) {
				System.out.println("ERROR");
			}
			System.out.println(ans);
		}
	}

}
