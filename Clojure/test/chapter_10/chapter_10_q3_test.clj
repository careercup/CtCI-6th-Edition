(ns chapter-10.chapter-10-q3-test
  (:require [clojure.test :refer :all]
            [chapter-10.chapter-10-q3 :refer :all]))

(deftest rotated-array-search-test
  (is (= 5 (rotated-array-search [15 16 19 20 25 1 3 4 5 7 10 14] 1)))
  (is (= 11 (rotated-array-search [15 16 19 20 25 1 3 4 5 7 10 14] 14)))
  (is (= 8 (rotated-array-search [15 16 19 20 25 1 3 4 5 7 10 14] 5)))
  (is (= 0 (rotated-array-search [15 16 19 20 25 1 3 4 5 7 10 14] 15)))
  (is (= 1 (rotated-array-search [15 16 19 20 25 1 3 4 5 7 10 14] 16)))
  (is (= 4 (rotated-array-search [15 16 19 20 25 1 3 4 5 7 10 14] 25)))
  (is (nil? (rotated-array-search [15 16 19 20 25 1 3 4 5 7 10 14] 27))))



