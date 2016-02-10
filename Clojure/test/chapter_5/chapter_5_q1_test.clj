(ns chapter-5.chapter-5-q1-test
  (:require [clojure.test :refer :all]
            [chapter-5.chapter-5-q1 :refer :all]))

(deftest insertion-shifts-test
  (is (= 2r10001001100 (insertion-shifts 2r10000000000 2r10011 2 6)))
  (is (= 2r10001001111 (insertion-shifts 2r10000000011 2r10011 2 6)))
  (is (= 2r10111001111 (insertion-shifts 2r10110000011 2r10011 2 6)))
  (is (= 2r10000001000 (insertion-shifts 2r10000000000 2r1 3 3)))
  (is (= 2r11111111111 (insertion-shifts 2r11111110111 2r1 3 3)))
  (is (= 2r10011000000 (insertion-shifts 2r10000000000 2r11 5 7)))
  (is (= 2r11000000000 (insertion-shifts 2r10000000000 2r1000000000 0 9))))

(deftest insertion-masks-test
  (is (= 2r10001001100 (insertion-masks 2r10000000000 2r10011 2 6)))
  (is (= 2r10001001111 (insertion-masks 2r10000000011 2r10011 2 6)))
  (is (= 2r10111001111 (insertion-masks 2r10110000011 2r10011 2 6)))
  (is (= 2r10000001000 (insertion-masks 2r10000000000 2r1 3 3)))
  (is (= 2r11111111111 (insertion-masks 2r11111110111 2r1 3 3)))
  (is (= 2r11000000000 (insertion-masks 2r10000000000 2r1000000000 0 9))))
