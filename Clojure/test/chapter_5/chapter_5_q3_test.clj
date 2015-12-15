(ns chapter-5.chapter-5-q3-test
  (:require [clojure.test :refer :all]
            [chapter-5.chapter-5-q3 :refer :all]))

(deftest flip-bit-to-win-test
  (is (= 8  (flip-bit-to-win 2r11011101111)))
  (is (= 3  (flip-bit-to-win 2r10101010101)))
  (is (= 5  (flip-bit-to-win 2r11011011011)))
  (is (= 11 (flip-bit-to-win 2r11111111110)))
  (is (= 8  (flip-bit-to-win 2r11111110011)))
  (is (= 11 (flip-bit-to-win 2r11111101111))))