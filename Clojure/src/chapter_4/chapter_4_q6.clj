(ns ^{:author "Leeor Engel"}
  chapter-4.chapter-4-q6
  (:require [clojure.zip :as zip]
            [data-structures.tree :refer :all]))

(defn- smallest [zipper-node]
  "Returns the smallest node in a zipper of a BST"
  (if (-> zipper-node zip/children empty?)
    (zip/node zipper-node)
    (if (some? (zip-left-child zipper-node))
      (smallest (zip-left-child zipper-node))
      (smallest (zip-right-child zipper-node)))))

(defn- ancestor-successor [zipper-node node-data]
  (let [node (zip/node zipper-node)
        parent (zip-parent zipper-node)]
    (if (some? parent)
      (if (> (:data node) (-> parent zip/node :data))
        (ancestor-successor parent node-data)
        (zip/node parent))
      nil)))

(defn successor [zipper-node]
  "Given a zipper structured node reference, returns its successor."
  (let [node (zip/node zipper-node)]
    (if (some? (:right node))
      (smallest (zip-right-child zipper-node))
      (ancestor-successor zipper-node (:data node)))))