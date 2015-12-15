(ns chapter-5.chapter-5-q6-test
  (:require [clojure.test :refer :all]
            [chapter-5.chapter-5-q6 :refer :all]))

(deftest conversion-test
  (is (= 0 (conversion 2r1 2r1)))
  (is (= 0 (conversion 2r0 2r0)))
  (is (= 1 (conversion 2r0 2r1)))
  (is (= 1 (conversion 2r1 2r0)))
  (is (= 2 (conversion 2r10 2r01)))
  (is (= 2 (conversion 2r11101 2r01111)))
  (is (= 3 (conversion 2r10101 2r11110)))
  (is (= 3 (conversion 2r111 2r0))))