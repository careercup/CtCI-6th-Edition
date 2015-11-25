(ns chapter-1.chapter_1_q1_test
  (:require [clojure.test :refer :all]
            [chapter-1.chapter-1-q1 :refer :all]))

;; sorting

(deftest unique-chars-sorting-test
  (is (unique-coll-sort nil))
  (is (unique-coll-sort ""))
  (is (unique-coll-sort "a"))
  (is (not (unique-coll-sort "aa")))
  (is (unique-coll-sort "ab"))
  (is (unique-coll-sort "abcdef"))
  (is (not (unique-coll-sort "aba")))
  (is (not (unique-coll-sort "bcaa"))))

;; map lookup

(deftest unique-chars-map-lookup-test
  (is (unique-coll-set nil))
  (is (unique-coll-set ""))
  (is (unique-coll-set "a"))
  (is (not (unique-coll-set "aa")))
  (is (unique-coll-set "ab"))
  (is (unique-coll-set "abcdef"))
  (is (not (unique-coll-set "aba")))
  (is (not (unique-coll-set "bcaa"))))
