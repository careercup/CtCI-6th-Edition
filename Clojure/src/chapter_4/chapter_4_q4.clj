(ns chapter-4.chapter-4-q4
  (:import (data_structures.tree BinaryTreeNode)))


(defn tree-height [^BinaryTreeNode node]
  (if (nil? node)
    0
    (+ 1 (tree-height (:left node)) (tree-height (:right node)))))

(defn tree-balanced? [tree]
  (let [root tree
        height-delta (- (tree-height (:left root)) (tree-height (:right root)))]
    (<= (Math/abs height-delta) 1)))