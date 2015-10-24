(ns chapter-1.chapter-1-q9-test
  (:require [clojure.test :refer :all]
            [chapter-1.chapter-1-q9 :refer :all]))

(deftest rotation-test
  (is (rotation? "a" "a"))
  (is (rotation? "aa" "aa"))
  (is (not (rotation? "aa" "a")))
  (is (rotation? "ba" "ab"))
  (is (not (rotation? "ba" "bab")))
  (is (not (rotation? "waterbottle" "etbottlewat")))
  (is (rotation? "waterbottle" "erbottlewat"))
  (is (rotation? "watbottlewat" "twatbottlewa")))
