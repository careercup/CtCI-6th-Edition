(ns chapter-5.chapter-5-q1
  (:require [lib.bit-manipulation :refer :all]))

;;
;; Solution 1 - repeatedly shift off most significant bits of m and set the bit
;; at correct corresponding index in n
;;

(defn insertion-shifts [n m i j]
  (reduce (fn [new-n [next-digit idx]]
            (bit-update new-n idx (pos? next-digit)))
          n
          (map vector (most-signif-bit-seq m) (range j (dec i) -1))))

;;
;; Solution 2 - OR indexed-aligned m onto i-j bit cleared n
;;

(defn insertion-masks [n m i j]
  (let [n-j-to-i-cleared (clear-bits n j i)
        m-aligned (bit-shift-left m i)]
    (bit-or n-j-to-i-cleared m-aligned)))