(ns ^{:author "Leeor Engel"}
  chapter-4.chapter-4-q4
  (:import (data_structures.tree BinaryTreeNode)))

(defn tree-height [^BinaryTreeNode node]
  (cond (nil? node) 0
        :else (+ 1 (-> node :left tree-height) (-> node :right tree-height))))

(defn tree-balanced? [tree]
  (let [height-delta (- (-> tree :left tree-height) (-> tree :right tree-height))]
    (<= (Math/abs height-delta) 1)))