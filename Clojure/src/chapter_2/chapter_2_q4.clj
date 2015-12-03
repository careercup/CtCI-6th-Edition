(ns ^{:author "Leeor Engel"}
chapter-2.chapter-2-q4
  (:require [data-structures.linked-list :refer :all]))

(defn partition-list [l x]
  (let [[less-than greater-than] (reduce (fn [[less-than greater-than] n]
                                           (cond (< n x) [(conj less-than n) greater-than]
                                                 :else [less-than (conj greater-than n)])) ['() '()] l)]
    (concat less-than greater-than)))