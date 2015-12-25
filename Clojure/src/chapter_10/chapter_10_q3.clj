(ns chapter-10.chapter-10-q3
  (:require [medley.core :refer :all]
            [lib.binary-search :refer :all]))

(defn- start-offset-idx
  "Returns the index of the smallest element in v."
  [v]
  (reduce (fn [[_ elem1] [idx2 elem2]]
            (if (> elem1 elem2)
              (reduced idx2)
              [idx2 elem2])) (indexed v)))

(defn rotated-array-search
  "Searches for element x in sorted but rotated vector v."
  [v x]
  (let [offset-idx (start-offset-idx v)]
    (if (vector? offset-idx)
      (binary-search v x)
      (let [min-val (get v 0)
            max-val (get v (dec offset-idx))]
        (if (<= min-val x max-val)
          (binary-search (subvec v 0 offset-idx) x)
          (if-let [res (binary-search (subvec v offset-idx) x)]
            (+ offset-idx res)
            nil))))))

