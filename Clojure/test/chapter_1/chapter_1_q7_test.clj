(ns chapter-1.chapter-1-q7-test
  (:require [clojure.test :refer :all]
            [chapter-1.chapter-1-q7 :refer :all]))

(deftest rotate-matrix-test
  (are [m] (= (nth (iterate rotate-matrix m) 4) m)
           [[1]]
           [[1 2] [3 4]]
           [[1 2 3] [4 5 6] [7 8 9]]
           [[1 2 3 4] [5 6 7 8] [9 10 11 12] [13 14 15 16]]
           [[11 1 34 2 36] [44 56 6 78 87] [17 88 900 12 42] [23 81 564 35 78] [2 66 31 9 0]]))

(deftest rotate-matrix-in-place-test
  (are [m] (= (nth (iterate rotate-matrix-in-place m) 4) m)
           [[1]]
           [[1 2] [3 4]]
           [[1 2 3] [4 5 6] [7 8 9]]
           [[1 2 3 4] [5 6 7 8] [9 10 11 12] [13 14 15 16]]
           [[11 1 34 2 36] [44 56 6 78 87] [17 88 900 12 42] [23 81 564 35 78] [2 66 31 9 0]]))
