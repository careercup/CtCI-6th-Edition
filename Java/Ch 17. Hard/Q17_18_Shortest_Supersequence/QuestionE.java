package Q17_18_Shortest_Supersequence;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionE {

    public static Range shortestSupersequence(int[] big, int[] small) {
        Range range = null;
        /* Convert the small array to a Set. */
        final Set<Integer> smallSet = Arrays.stream(small).boxed().collect(Collectors.toSet());
        /* This Map stores the numbers from smallSet found in the big array
         * in order of appearance, alongside their most recent index. */
        final Map<Integer, Integer> numAtIdx = new LinkedHashMap<>();

        /* Walk through the big array, adding matching numbers and indices to the Map.
         * Elements already present in the Map are removed first to maintain insertion order. */
        for (int idx = 0; idx < big.length; idx++) {
            if (smallSet.contains(big[idx])) {
                numAtIdx.remove(big[idx]);
                numAtIdx.put(big[idx], idx);

                if (numAtIdx.size() == smallSet.size()) {
                    /* If we found all numbers, calculate the length of the range. */
                    final int start = numAtIdx.values().iterator().next();
                    final int candidateLength = idx - start + 1;

                    /* Instate the range if it's the first one found or in case it's shorter. */
                    if (range == null || range.length() > candidateLength) {
                        range = new Range(start, idx);

                        /* Stop early if the elements are adjacent. We can't do any better. */
                        if (range.length() == smallSet.size()) break;
                    }

                    /* Remove the range's leftmost element. */
                    numAtIdx.remove(big[start]);
                }
            }
        }

        return range;
    }

}
