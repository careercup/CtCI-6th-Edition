package Q10_08_Find_Duplicates;

class BitSet {
	int[] bitset;
	
	public BitSet(int size) {
		bitset = new int[(size >> 5) + 1]; // divide by 32
	}

	boolean get(int pos) {
		int wordNumber = (pos >> 5); // divide by 32
		int bitNumber = (pos & 0x1F); // mod 32
		return (bitset[wordNumber] & (1 << bitNumber)) != 0;
	}
	
	void set(int pos) {
		int wordNumber = (pos >> 5); // divide by 32
		int bitNumber = (pos & 0x1F); // mod 32
		bitset[wordNumber] |= 1 << bitNumber;
	}
}
