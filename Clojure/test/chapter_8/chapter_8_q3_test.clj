(ns chapter-8.chapter-8-q3-test
  (:require [clojure.test :refer :all]
            [chapter-8.chapter-8-q3 :refer :all]))

(deftest magix-idx-distinct-test
  (is (distict-magic-idx? [0]))
  (is (not (distict-magic-idx? [1])))
  (is (distict-magic-idx? [-1 1]))
  (is (not (distict-magic-idx? [-2 -1 0])))
  (is (not (distict-magic-idx? [-2 -1 0 4 7 10])))
  (is (distict-magic-idx? [-2 -1 0 3 7 10]))
  (is (distict-magic-idx? [-2 -1 0 3]))
  (is (distict-magic-idx? [0 3 6 19]))
  (is (distict-magic-idx? [-1 0 1 3 7 10 345])))

;;
;; FOLLOW UP
;;

(deftest magix-idx-test
  (is (magic-idx? [0]))
  (is (not (magic-idx? [1])))
  (is (magic-idx? [-1 1]))
  (is (not (magic-idx? [-2 -1 0])))
  (is (not (magic-idx? [-2 -1 0 4 7 10])))
  (is (magic-idx? [-2 -1 0 3 7 10]))
  (is (magic-idx? [-2 -1 0 3]))
  (is (magic-idx? [0 3 6 19]))
  (is (magic-idx? [-1 0 1 3 7 10 345]))
  (is (not (magic-idx? [-2 -1 0 0 5 8])))
  (is (magic-idx? [-2 -1 0 0 4 8]))
  (is (magic-idx? [-10 -5 2 2 2 3 4 7 9 12 13])))
