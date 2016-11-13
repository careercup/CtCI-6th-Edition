package Q17_18_Shortest_Supersequence;

public class Range {
	private int start;
	private int end;
	public Range(int s, int e) {
		start = s;
		end = e;
	}
	
	public int length() {
		return end - start + 1;
	}
	
	public boolean shorterThan(Range other) {
		if(other == null)
			return -1;
		return length() < other.length();
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	@Override
	public String toString() {
		return String.format("[%d, %d]", start, end);
	}
	
	@Override
	protected IndicesPair clone() {
		IndicesPair cloned = new IndicesPair();
		cloned.index1 = index1;
		cloned.index2 = index2;
		return cloned;
	}
}
