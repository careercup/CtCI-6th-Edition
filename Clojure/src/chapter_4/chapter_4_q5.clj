(ns chapter-4.chapter-4-q5
  (:require [data-structures.tree :refer :all]))

;; O(n)
(defn valid-bst? [tree]
  (if (some? tree)
    (cond (and (some? (:left tree)) (< (:data tree) (:data (:left tree)))) false
          (and (some? (:right tree)) (> (:data tree) (:data (:right tree)))) false
          :else (and (valid-bst? (:left tree)) (valid-bst? (:right tree))))
    true))

;; Worse time-complexity O(n log n)
(defn alt-valid-bst? [tree]
  (let [in-order-traversal (in-order-walk tree)]
    (= (sort in-order-traversal) in-order-traversal)))