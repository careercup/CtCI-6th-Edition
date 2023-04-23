package Q10_10_Rank_from_Stream;

import java.util.Comparator;

public class IntComparable implements Comparator<Integer>{
	 
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
}
