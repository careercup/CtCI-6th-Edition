(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q3
  (:require [data-structures.mutable-linked-list :refer :all]))

(defn remove-middle-node [node]
  (let [next (:next @node)]
    (reset! node @next)))