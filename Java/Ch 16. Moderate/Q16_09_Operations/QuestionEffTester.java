package Q16_09_Operations;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.lang.reflect.Method;
import static Q16_09_Operations.QuestionEff.*;

public class QuestionEffTester {
	private static final int[] TEST_NUMBERS = {
		Integer.MIN_VALUE, -Integer.MAX_VALUE, -Integer.MAX_VALUE + 1,
		Integer.MIN_VALUE / 2 - 1, Integer.MIN_VALUE / 2, Integer.MIN_VALUE + 1,
		-1000, -300, -200, -100, -90, -85, -84, -83,
		-12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
		0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		83, 84, 85, 90, 100, 200, 300, 1000,
		Integer.MAX_VALUE / 2 - 3, Integer.MAX_VALUE / 2 - 2, Integer.MAX_VALUE / 2 - 1,
		Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2 + 1, Integer.MAX_VALUE / 2 + 2,
		Integer.MAX_VALUE / 2 + 3, Integer.MAX_VALUE - 1, Integer.MAX_VALUE,
	};
	
	private static void assertEquals(int expected, int actual) {
		if (expected == actual) {
			return;
		}
		String message = String.format("expected: <%d> but was: <%d>", expected, actual);
		throw new AssertionError(message);
	}
	
	private static <T> void assertThrows(Class<T> expectedType, Runnable runnable) {
		try {
			runnable.run();
		} catch (Exception e) {
			if (expectedType.isInstance(e)) {
				return;
			}
			throw new AssertionError("unexpected exception type thrown");
		}
		throw new AssertionError("nothing was thrown");
	}

	public void testBitNot() {
		for (int n : TEST_NUMBERS) {
			assertEquals(~n, bitNot(n));
		}
	}

	public void testGetBit() {
		for (int n : TEST_NUMBERS) {
			for (final int shift : IntStream.rangeClosed(-100, 200).toArray()) {
				if (shift < 0) {
					assertThrows(ArithmeticException.class, ()->getBit(n, shift));
				} else if (shift > 31) {
					assertThrows(IndexOutOfBoundsException.class, ()->getBit(n, shift));
				} else {
					assertEquals((n >>> shift) & 1, getBit(n, shift));
				}
			}
		}
	}

	public void testShiftLeft() {
		for (int n : TEST_NUMBERS) {
			for (final int shift : IntStream.rangeClosed(-100, 200).toArray()) {
				assertEquals(n << shift, shiftLeft(n, shift));
			}
		}
	}

	public void testShiftRight() {
		for (int n : TEST_NUMBERS) {
			for (final int shift : IntStream.rangeClosed(-100, 200).toArray()) {
				assertEquals(n >> shift, shiftRight(n, shift));
			}
		}
	}

	public void testShiftRightUnsigned() {
		for (int n : TEST_NUMBERS) {
			for (final int shift : IntStream.rangeClosed(-100, 200).toArray()) {
				assertEquals(n >>> shift, shiftRightUnsigned(n, shift));
			}
		}
	}

	public void testMultiply() {
		for (int a : TEST_NUMBERS) {
			for (int b : TEST_NUMBERS) {
				assertEquals(a * b, multiply(a, b));
			}
		}
	}

	public void testDivide() {
		for (int a : TEST_NUMBERS) {
			for (int b : TEST_NUMBERS) {
				if (b == 0) {
					assertThrows(ArithmeticException.class, ()->divide(a, b));
				} else {
					assertEquals(a / b, divide(a, b));
				}
			}
		}
	}

	public void testRemainder() {
		for (int a : TEST_NUMBERS) {
			for (int b : TEST_NUMBERS) {
				if (b == 0) {
					assertThrows(ArithmeticException.class, ()->remainder(a, b));
				} else {
					assertEquals(a % b, remainder(a, b));
				}
			}
		}
	}

	public void testMod() {
		for (int a : TEST_NUMBERS) {
			for (int b : TEST_NUMBERS) {
				if (b == 0) {
					assertThrows(ArithmeticException.class, ()->mod(a, b));
				} else {
					assertEquals(BigInteger.valueOf(a).mod(BigInteger.valueOf(b).abs()).intValue(), mod(a, b));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		QuestionEffTester tester = new QuestionEffTester();
		Method[] methods = QuestionEffTester.class.getDeclaredMethods();
		for (Method method : methods) {
			if (!method.getName().startsWith("test")) {
				continue;
			}
			System.out.println(method.getName());
			method.invoke(tester);
		}
	}
}