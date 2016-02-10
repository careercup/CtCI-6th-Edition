(ns chapter-5.chapter-5-q3
  (:require [lib.bit-manipulation :refer :all]))

(defn flip-bit-to-win [n]
  (let [[last-sum highest-max _] (reduce (fn [[running-sum cur-max zero-buf] bits]
                                   (if (zero? (first bits))
                                     (let [new-zero-buf (into zero-buf bits)]
                                       (if (> (count new-zero-buf) 1)
                                         [0 (max running-sum cur-max) '()]
                                         [running-sum cur-max new-zero-buf]))
                                     [(+ running-sum (count bits)) cur-max zero-buf]))
                                 [0 0 '()]
                                 (partition-by zero? (least-signif-bit-seq n)))]
    (inc (max highest-max last-sum))))