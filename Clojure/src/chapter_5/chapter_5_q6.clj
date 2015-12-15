(ns chapter-5.chapter-5-q6
  (:require [lib.bit-manipulation :refer :all]
            [lib.core :refer :all]))

(defn conversion [a b]
  (reduce (fn [to-flip [ai bi]] (if (not= ai bi) (inc to-flip) to-flip))
          0
          (map-all vector (least-signif-bit-seq a) (least-signif-bit-seq b))))