17.23 - Max Square Matrix
---
> Imagine you have a square matrix, where each cell (pixel) is either black or white. Design an algorithm to find the maximum subsquare such that all four borders are filled with black pixels.

---

### Preparing cells data

In [the previous solution](https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2017.%20Hard/Q17_23_Max_Black_Square/QuestionEff.java), we counted zeros below and to the right of each cell. We managed to do it using dynamic programming with quadratic time complexity - O(N<sup>2</sup>) where N is the length of the square matrix side.

Knowing how many zeros are located below and to the right shows us how big a potential square could be if its top left corner started at the given cell. See a picture below - we have several potential corners here:

<img src="https://user-images.githubusercontent.com/9422761/205371762-9c8a45f5-bf54-4957-be6c-60a6427872fe.svg" width="500">

If some cell has 5 zeros to the right and only 4 below, it means that the square starting at this cell can be of size 1-4. Thus, `min(zerosBelow, zerosRight)` shows us maximum size of a square candidate which top left corner is located at the current cell.

Similarly, we can make these calculations for zeros above and zeros to the left as well. This will provide information on potential bottom right corners of seeked squares.

When two opposite corners meet each other (i.e. their sides are long enough to reach the opposite sides), a square is detected. So, how to check if corners meet? In order to do that, let's switch to diagonals. A diagonal representation turns 2D problem into 1D.

<img src="https://user-images.githubusercontent.com/9422761/205378488-9029c254-b6da-44e7-987c-b0e3cb4d8727.svg" width="800">

We need to extract cells of each diagonal in a loop and treat them as a one-dimensional array. There are `2 * N - 1` diagonals. The size of the first one (in the top right corner) is 1. The one in the middle is the longest (of length N). And the bottom left corner also has length 1. Let's give them indexes from `-(N - 1)` to `(N - 1)`. The middle one will have index 0.

<img src="https://user-images.githubusercontent.com/9422761/205428017-eecaa278-f38d-48d3-af4d-a4cfd38ffef0.svg" width="300">

Now, let's concentrate on one of diagonals. For each diagonal, we've collected 2 arrays of corner sizes: one for top-left corners and another one - for bottom-right. We need to find intersection points and choose the biggest intersection (i.e. square). Once we have the biggest square for each diagonal, we'll simply take the maximum square of all diagonals.

<img src="https://user-images.githubusercontent.com/9422761/205428260-5652fc4f-9ffa-4c39-9de0-9d95054d862b.svg" width="800">

---

### A subtask: the longest intersection of intervals

This task can be formulated as:
> `A` and `B` are 2 equally sized arrays of integers. Index `start` of array `A` denotes the beginning of the interval `left`. The value `A[start]` is the length of the interval `left`. Index `end` of array `B` is the end of the interval `right`. The value `B[end]` is the length of the interval `right`. Find the longest intersection `[left.start, right.end]` among all possible intervals `left` and `right` such that
> `right.start <= left.start <= right.end <= left.end`

Check the following example on how this subtask relates to the initial problem of subsquares:
```text
Original matrix:
0       x
  0     x
    x x x x
    x 0 x
x x x x x x
    x   x 0

Squares on main diagonal:
{row=2, col=2, size=1}
{row=2, col=2, size=3}
{row=4, col=4, size=1}

Equivalent arrays of zeros to the right (A) and to the left (B):
A: 0 0 4 0 2 0
B: 0 0 1 0 5 0

Intervals:
i: 0 1 2 3 4 5  #
A:     x x x x (1)
           x x (2)
B: x x x x x   (3)
       x       (4)

Intersections:
(1)x(3) - {start=2, end=4, length=3}
(1)x(4) - {start=2, end=2, length=1}
(2)x(3) - {start=4, end=4, length=1}
(2)x(4) - no overlapping
^^ this is equivalent to the squares above
```

As usual, we can start from a naive brute-force approach: compare each `left` interval with every `right` interval and return the longest intersection:
```java
private static Interval findLongestIntersection(Interval[] a, Interval[] b) {
    Interval longest = null;
    for (Interval left : a) {
        for (Interval right : b) {
            if (right.start <= left.start && left.start <= right.end && right.end <= left.end) {
                Interval intersection = new Interval(left.start, right.end);
                longest = maxInterval(longest, intersection);
            }
        }
    }
    return longest;
}
```
This method takes O(N<sup>2</sup>) time. Can it be improved?

---

### Optimization: track opened intervals

We can notice that once we obtained `left`, there's no need to traverse the whole `B` array searching for overlapping `right` intervals. In the example above, intervals (2) and (4) don't intersect. So, checking (2), we could omit any intervals from `B` that had already ended before we reached the start of the interval (2). Let `openedRightIntervals` be a set of `right` intervals that have started by the moment we handle current index but haven't ended yet. Take a look at the example:
```text
                   i:   0    1     2      3    4   5   #
                   B:   x    x     x      x    x      (3)
                                   x                  (4)
openedRightIntervals:  [3]  [3]  [3, 4]  [3]  [3]  []
```
While iterating over array `A`, we can keep track of `openedRightIntervals` in linear time by adding all `right` intervals that start at some position and removing an interval ending at that position. Note that exactly one `right` interval ends at every index. But several `right` intervals can start at the same position. See:
```text
Matrix:
0   x   x
  0 x   x
x x x   x
      0 x
x x x x x

B: 0 0 3 0 5

Intervals:
x x x     (1) - {start=0, end=2, length=3}
x x x x x (2) - {start=0, end=4, length=5}
```
Despite that some indexes will contain a list of `right` intervals starting there, the total quantity of `right` intervals is N anyway, so the number of insertions and additional space remain linear.

---

### Optimization: take last interval

Another optimization is based on the fact that we don't need to list all intersections, we just need the longest one. Thus, finding the longest intersection for each `left` interval is enough. Eventually, we'll be able to take the longest one among them.

Which `right` interval produces the longest intersection for a given `left` interval? See the following examples of intervals and compare with the original matrix:
```text
Matrix:
0         x
  0 x     x   this is (left)
  x(1)    x     |
      0   x     |
        0 x x   v   x
x x x x x(2)x x x   x
        x x(3)      x
          x   0 x   x
 (left)-> x   x(4)  x
                  0 x
        x x x x x x(5)

Intervals:
i: 0 1 2 3 4 5 6 7 8 9 10
A:           x x x x     (left)
B:   x x                 (1)
   x x x x x x           (2)
           x x x         (3)
                 x x     (4)
           x x x x x x x (5)

(1) - no overlap at all
(2) - long interval (L=6), but overlap is short (L=1)
(3) - short interval (L=3), but it overlaps 50% (L=2)
(4) - it looks like an overlap, but check the original matrix - corners don't meet
      right.start = 7 > left.start = 5, but right.start should be <= left.start
(5) - long interval (L=7), covers "left" entirely, but check the original matrix
      corners don't touch each other because right.end = 10 > left.end = 8 (should be <=)
```
Summing it up, the longest overlap is produced by the last `right` interval met before the index `left.end` (among intervals which were opened at `left.start`, i.e. among those contained in `openedRightIntervals` set). So, we need to query the last `right.end <= left.end`. It can be done using a binary search tree, e.g., the Java implementation - TreeMap. Time complexity of this action is O(log N). We can also combine `openedRightIntervals` with this index thus turning it into a TreeSet:
```java
private static Interval findLongestIntersection(Interval[] a, Interval[] b) {
    /* Turn B intervals from {index = end, value = length} format
     * to {index = start, value = List of ends of B intervals starting at this index} */
    List[] rightStartPoints = endsToStarts(b);

    Interval longest = null;
    NavigableSet<Integer> openedRightIntervals = new TreeSet<>();
    for (Interval left : a) {
        /* Track B intervals opened up to left.start point */
        openedRightIntervals.addAll(rightStartPoints[left.start]);
        
        /* Find the last interval up to left.end point.
         * This interval gives the longest intersection for the interval "left". */
        Integer rightEnd = left.length == 0 ? null : openedRightIntervals.floor(left.end);
        
        /* Check if new intersection is the longest one among all intervals */
        Interval intersection = rightEnd == null ? null : new Interval(left.start, rightEnd);
        longest = maxInterval(longest, intersection);
        
        /* Remove B interval ending at the current index */
        openedRightIntervals.remove(left.start);
    }
    return longest;
}
```
Note that since `openedRightIntervals` set is a TreeSet now, insertion and removal will take O(log N) time. Total time of tracking `openedRightIntervals` becomes O(N * log N). Space remains O(N).

---

### Full algorithm

**Taking all these steps together:**
- for each cell, count zeros to the left, to the right, above and below this cell
- find the length a potential corner may have starting in this cell
  - top left corner's length = min(zeros right, zeros below)
  - bottom right corner's length = min(zeros left, zeros above)
- loop through diagonals
  - extract diagonal as one-dimensional array
  - prepare 2 arrays A and B
    - A contains lengths of top left corners
    - B contains lengths of bottom right corners
  - find longest intersection of intervals from A and B
  - turn it into subsquare
- find the biggest subsquare among all diagonals

**Find longest intersection of intervals from A and B:**
- rearrange array B to be indexed by the start of intervals instead of their end
- start tracking opened intervals of B
- loop through intervals from A
  - mark all intervals from B starting at this index as opened
  - find the last interval from B which ends before A interval end
  - calculate the intersection if such an interval is found
  - remove the interval of B ending at this index from the set of opened intervals
- find the longest intersection among all found intersections

Preparation steps take O(N<sup>2</sup>). Looping through diagonals is O(N) per se. For each diagonal, extraction and array preparations take O(N). The longest intersection subtask is O(N * log N) totally: looping is O(N), tracking of opened intervals is O(N * log N) in sum, last interval querying takes O(log N) per each iteration. **Total time:** O(N<sup>2</sup> * log N). **Total space:** O(N<sup>2</sup>) - we count zeros using copies of the matrix. Extra memory is spent on each iteration of diagonals loop and is allocated temporarily for that iteration only. It takes O(N), so it can be neglected.

Comparing to previous solutions, we managed to achieve an improvement:
- [Simple solution](https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2017.%20Hard/Q17_23_Max_Black_Square/Question.java): O(N<sup>4</sup>), space: O(1)
- [Pre-processing solution](https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2017.%20Hard/Q17_23_Max_Black_Square/QuestionEff.java): O(N<sup>3</sup>), space: O(N<sup>2</sup>)
- This (lookup) solution: O(N<sup>2</sup> * log N), space: O(N<sup>2</sup>)
