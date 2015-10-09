(ns chapter-1.chapter_1_q1_test
  (:require [clojure.test :refer :all]
            [chapter-1.chapter-1-q1 :refer :all]))

;; sorting

(deftest unique-chars-sorting-test
  (is (unique-chars-sorting nil))
  (is (unique-chars-sorting ""))
  (is (unique-chars-sorting "a"))
  (is (not (unique-chars-sorting "aa")))
  (is (unique-chars-sorting "ab"))
  (is (unique-chars-sorting "abcdef"))
  (is (not (unique-chars-sorting "aba")))
  (is (not (unique-chars-sorting "bcaa"))))

;; map lookup

(deftest unique-chars-map-lookup-test
  (is (unique-chars-map-lookup nil))
  (is (unique-chars-map-lookup ""))
  (is (unique-chars-map-lookup "a"))
  (is (not (unique-chars-map-lookup "aa")))
  (is (unique-chars-map-lookup "ab"))
  (is (unique-chars-map-lookup "abcdef"))
  (is (not (unique-chars-map-lookup "aba")))
  (is (not (unique-chars-map-lookup "bcaa"))))
