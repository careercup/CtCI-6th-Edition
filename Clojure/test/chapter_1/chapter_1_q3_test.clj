(ns chapter-1.chapter_1_q3_test
  (:require [clojure.test :refer :all]
            [chapter-1.chapter-1-q3 :refer :all]))

(deftest url-ify-test
  (is (= (url-ify "test" 4) "test"))
  (is (= (url-ify "   " 1) "%20"))
  (is (= (url-ify "      " 2) "%20%20"))
  (is (= (url-ify " test  " 5) "%20test"))
  (is (= (url-ify "te st  " 5) "te%20st"))
  (is (= (url-ify "test   " 5) "test%20"))
  (is (= (url-ify "Mr John Smith    " 13) "Mr%20John%20Smith")))
