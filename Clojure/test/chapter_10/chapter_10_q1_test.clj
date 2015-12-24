(ns chapter-10.chapter-10-q1-test
  (:require [clojure.test :refer :all]
            [chapter-10.chapter-10-q1 :refer :all]))

(deftest sorted-merge-test
  (is (= [10 22 34 47 61 84 90 100] (sorted-merge [22 34 61 84 100 nil nil nil]
                                              [10 47 90])))
  (is (= [1 2 3 4 5 6 7 8 9 10] (sorted-merge [2 4 6 8 10 nil nil nil nil nil]
                                              [1 3 5 7 9])))
  (is (= [1 2 3 4 5 6 7 8 9 10 nil] (sorted-merge [2 4 6 8 10 nil nil nil nil nil nil]
                                              [1 3 5 7 9]))))

