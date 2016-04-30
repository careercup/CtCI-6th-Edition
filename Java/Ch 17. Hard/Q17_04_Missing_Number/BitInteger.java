package Q17_04_Missing_Number;

public class BitInteger {
	public static int INTEGER_SIZE;
	private boolean[] bits;
	public BitInteger() {
		bits = new boolean[INTEGER_SIZE];
	}
	/* Creates a number equal to given value. Takes time proportional 
	 * to INTEGER_SIZE. */
	public BitInteger(int value){
		bits = new boolean[INTEGER_SIZE];
		for (int j = 0; j < INTEGER_SIZE; j++){
			bits[INTEGER_SIZE - 1 - j] = (((value >> j) & 1) == 1);
		}
	}
	
	/** Returns k-th most-significant bit. */ 
	public int fetch(int k){
		if (bits[k]) return 1;
		else return 0;
	}
	
	/** Sets k-th most-significant bit. */
	public void set(int k, int bitValue){
		bits[k] = (bitValue != 0);
	}
	
	/** Sets k-th most-significant bit. */
	public void set(int k, char bitValue){
		bits[k] = (bitValue != '0');
	}
	
	/** Sets k-th most-significant bit. */
	public void set(int k, boolean bitValue){
		bits[k] = bitValue;
	}	
	
	public void swapValues(BitInteger number) {
		for (int i = 0; i < INTEGER_SIZE; i++) {
			int temp = number.fetch(i);
			number.set(i, this.fetch(i));
			this.set(i, temp);
		}
	}
		
	public int toInt() {
		int number = 0;
		for (int j = INTEGER_SIZE - 1; j >= 0; j--){
			number = number | fetch(j);
			if (j > 0) {
				number = number << 1;
			}
		}
		return number;
	}
}

