(ns chapter-1.chapter-1-q4-test
  (:require [clojure.test :refer :all]
            [chapter-1.chapter-1-q4 :refer :all]))

(deftest palindrome-permutations-test
  (is (palindrome-permutation? "a"))
  (is (palindrome-permutation? "aa"))
  (is (palindrome-permutation? "aab"))
  (is (palindrome-permutation? "Tact Coa"))
  (is (not (palindrome-permutation? "Tactoa"))))
