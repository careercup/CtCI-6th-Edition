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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + start;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Range other = (Range) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Range [start=" + start + ", end=" + end + "]";
	}

	public boolean shorterThan(Range other) {
		return length() < other.length();
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
}
