(ns ^{:author "Leeor Engel"}
chapter-4.chapter-4-q10
  (:require [data-structures.tree :refer :all]))

(defn- trees-equal? [t1 t2]
  (cond (and (nil? t1) (some? t2)) false
        (and (nil? t2) (some? t1)) false
        (not= (:data t1) (:data t2)) false
        (and (nil? t2) (nil? t1)) true
        :else (and (trees-equal? (:left t1) (:left t2))
                   (trees-equal? (:right t1) (:right t2)))))

(defn subtree? [t1 t2]
  (let [node (tree-find t1 (:data t2))]
    (if (nil? node)
      false
      (trees-equal? node t2))))