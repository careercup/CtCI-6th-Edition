(ns ^{:author "Leeor Engel"}
  chapter-4.chapter-4-q2
  (:require [data-structures.tree :refer :all]))

(defn minimal-tree [sorted-vec]
  (let [vec-size (count sorted-vec)
        half-size (int (/ vec-size 2))
        middle (get sorted-vec half-size)]
    (cond (= vec-size 1) (map->BinaryTreeNode {:data (first sorted-vec)})
          (= vec-size 2) (map->BinaryTreeNode {:data  (first sorted-vec)
                                               :right (map->BinaryTreeNode {:data (second sorted-vec)})})
          :else (map->BinaryTreeNode {:data  middle
                                      :left  (minimal-tree
                                               (subvec sorted-vec 0 half-size))
                                      :right (minimal-tree
                                               (subvec sorted-vec (inc half-size) vec-size))}))))