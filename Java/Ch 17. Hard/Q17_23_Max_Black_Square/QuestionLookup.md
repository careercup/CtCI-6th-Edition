17.23 - Max Square Matrix
---
> Imagine you have a square matrix, where each cell (pixel) is either black or white. Design an algorithm to find the maximum subsquare such that all four borders are filled with black pixels.

---

In [the previous solution](https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2017.%20Hard/Q17_23_Max_Black_Square/QuestionEff.java), we counted zeros below and to the right of each cell. We managed to do it using dynamic programming with quadratic time complexity - O(N<sup>2</sup>) where N is the length of the square matrix side.

Knowing how many zeros are located below and to the right shows us how big a potential square could be if its top left corner started at the given cell. See a picture below - we have several potential corners here:

<img src="https://user-images.githubusercontent.com/9422761/205371762-9c8a45f5-bf54-4957-be6c-60a6427872fe.svg" width="500">

If some cell has 5 zeros to the right and only 4 below, it means that the square starting at this cell can be of size 1-4. Thus, `min(zerosBelow, zerosRight)` shows us maximum size of a square candidate which top left corner is located at the current cell.

Similarly, we can make these calculations for zeros above and zeros to the left as well. This will provide information on potential bottom right corners of seeked squares.

When two opposite corners meet each other (i.e. their sides are long enough to reach the opposite sides), a square is detected. So, how to check if corners meet? In order to do that, let's switch to diagonals. A diagonal representation turns 2D problem into 1D.

<img src="https://user-images.githubusercontent.com/9422761/205378488-9029c254-b6da-44e7-987c-b0e3cb4d8727.svg" width="800">

We need to extract cells of each diagonal in a loop and treat them as a one-dimensional array. There are 2 * N - 1 diagonals. The size of the first one (in the top right corner) is 1. The one in the middle is the longest (of length N). And the bottom left corner also has length 1. Let's give them indexes from -(N - 1) to (N - 1). The middle one will have index 0.

<img src="https://user-images.githubusercontent.com/9422761/205428017-eecaa278-f38d-48d3-af4d-a4cfd38ffef0.svg" width="300">

Now, let's concentrate on one of diagonals. For each diagonal, we've collected 2 arrays of corner sizes: one for top-left corners and another one - for bottom-right. We need to find intersection points and choose the biggest intersection (i.e. square). Once we have the biggest square for each diagonal, we'll simply take the maximum square of all diagonals.

<img src="https://user-images.githubusercontent.com/9422761/205428260-5652fc4f-9ffa-4c39-9de0-9d95054d862b.svg" width="800">

This task can be formulated as:
> Given 2 arrays of non-negative integers `A` and `B` of equal length, find positions `i` and `j` such that `j - B[j] < i <= j < i + A[i]`. Return `max(j - i)` of all such `i` and `j`, or `null` if there are no such indicies.

In other words, if top left corner starts at `i` then it can reach the opposite corner at index `j` between `i` (incl.) and `i + A[i]` (excl.). And vice versa, if bottom right corner starts at `j`, the opposite corner (at index `i`) should be between `j - B[j]` (excl.) and `j` (incl.). If both conditions are met, a valid square is found. Its size is `j - i + 1`.

So, this is a task about intersecting intervals.

Let's take a look at the example:
```text
Matrix diagonal before extraction:

Top left corners (A): | Bottom right corners (B):
(count to the right)  | (count above)
4 x x x               | 1 x x x
  5 x x x x           |   2 x x x x
    0                 |     0
      2 x             |       1 x
        3 x x         |         2 x x
          0 x         |           0 x
            2 x       |             3 x
              0       |               0

1D subtask:
                     i:  0   1   2   3   4   5   6   7
                  A[i]:  4   5   0   2   3   0   2   0
          i + A[i] - 1:  3   5   1   4   6   4   7   6
i <= j <= i + A[i] - 1: 0-3 1-5 --- 3-4 4-6 --- 6-7 ---

                     j:  0   1   2   3   4   5   6   7
                  B[j]:  1   2   0   1   2   0   3   0
          j - B[j] + 1:  0   0   3   3   3   6   4   8
j - B[j] + 1 <= i <= j: 0-0 0-1 --- 3-3 3-4 --- 4-6 ---

Intersections:
i = 0: 0-3 includes j = 0 (0-0), 1 (0-1), 3 (3-3)
Filter out j = 3 (3-3) because lower bound 3 > i = 0
So, only j = 0 and j = 1 suit

i = 1: 1-5 includes j = 1 (0-1), 3 (3-3), 4 (3-4)
Filter out j = 3 (3-3) because lower bound 3 > i = 1
Filter out j = 4 (3-4) because lower bound 3 > i = 1
Only j = 1 suits

i = 3: 3-4 includes j = 3 (3-3), 4 (3-4), both suit

i = 4: 4-6 includes j = 4 (3-4), 6 (4-6), both suit

i = 6: 6-7 includes j = 6 (4-6) - it suits

Resulting pairs of [i, j]:
{0, 0}, {0, 1}, {1, 1}, {3, 3}, {3, 4}, {4, 4}, {4, 6}, {6, 6}
Note that all these pairs form valid sqares of sizes:
  1,      2,      1,      1,      2,      1,      3,      1
Maximim size is 3 of square formed by
top left corner at index 4 and bottom right corner on index 6
```

This is basically a naive brute force approach to solve this subtask. Its time complexity is O(N<sup>2</sup>). Can it be improved?
