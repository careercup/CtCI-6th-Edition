(ns chapter-1.chapter-1-q4
  (:require [clojure.string :as s]))

(defn palindrome-permutation? [s]
  (let [occurences (frequencies (s/lower-case s))
        un-matched (filter #(and (not= (key %) \space) (odd? (val %))) occurences)
        count (count un-matched)]
    (if (> count 1) false true)))
