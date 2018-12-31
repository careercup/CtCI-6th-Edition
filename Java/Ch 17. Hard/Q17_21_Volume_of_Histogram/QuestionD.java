package Q17_21_Volume_of_Histogram;

import java.util.Stack;

public class QuestionD {

	public static int computeHistogramVolume(int[] histogram) {
		int waterVolume = 0;
		if (histogram == null || histogram.length <= 1) {
			return waterVolume;
		}
		Stack<Bar> bars = new Stack<>();
		for (int barIndex = 0; barIndex < histogram.length; barIndex++) {
			if (histogram[barIndex] == 0) {
				continue;
			}
			Bar current = new Bar(barIndex, histogram[barIndex]);
			if (bars.isEmpty()) {
				bars.add(current);
				continue;
			}
			if (current.isSmallerThan(bars.peek())) {
				int diff = current.position - bars.peek().position - 1;
				int minHeight = Math.min(current.height, bars.peek().height);
				waterVolume += minHeight * diff;
				bars.add(current);
				continue;
			}
			Bar mid = null;
			while (!bars.isEmpty() && bars.peek().isSmallerThan(current)) {
				Bar top = bars.pop();
				int diff = current.position - top.position - 1;
				int minHeight = 0;
				if (mid != null) {
					minHeight = top.height - mid.height;
				} else {
					minHeight = Math.min(current.height, top.height);
				}
				waterVolume += minHeight * diff;
				mid = top;
			}
			if (!bars.isEmpty() && mid != null) {
				int minHeight = Math.min(bars.peek().height, current.height);
				minHeight = minHeight - mid.height;
				int diff = current.position - bars.peek().position - 1;
				waterVolume += minHeight * diff;
			}
			bars.add(current);
		}
		return waterVolume;
	}

}

class Bar {
	int position;
	int height;

	public Bar(int position, int height) {
		this.position = position;
		this.height = height;
	}

	boolean isSmallerThan(Bar other) {
		return this.height <= other.height;
	}
}