(ns chapter-8.chapter-8-q1-test
  (:require [clojure.test :refer :all]
            [chapter-8.chapter-8-q1 :refer :all]))

(deftest triple-step-count-test
  (is (= 1 (triple-step-count 1)))
  (is (= 2 (triple-step-count 2)))
  (is (= 4 (triple-step-count 3)))
  (is (= 7 (triple-step-count 4)))
  (is (= 13 (triple-step-count 5)))
  (is (= 927 (triple-step-count 12)))
  (is (= 181997601 (triple-step-count 32))))
