(ns chapter-1.chapter-1-q2_test
  (:require [clojure.test :refer :all]
            [chapter-1.chapter-1-q2 :refer :all]))

(deftest permutations-test
  (is (permutations? nil nil))
  (is (permutations? "" ""))
  (is (permutations? "a" "a"))
  (is (not (permutations? "a" "b")))
  (is (permutations? "ab" "ba"))
  (is (permutations? "cab" "bac"))
  (is (permutations? "cabc" "bcac")))
