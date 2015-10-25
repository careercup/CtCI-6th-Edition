(ns chapter-1.chapter-1-q5-test
  (:require [clojure.test :refer :all]
            [chapter-1.chapter-1-q5 :refer :all]))

(deftest one-away-test
  (is (one-away? "pale" "ple"))
  (is (one-away? "pales" "pale"))
  (is (one-away? "pale" "bale"))
  (is (not (one-away? "pale" "paless")))
  (is (not (one-away? "pale" "balee")))
  (is (not (one-away? "pale" "bake")))
  (is (one-away? "spale" "pale"))
  (is (one-away? "pale" "pasle")))