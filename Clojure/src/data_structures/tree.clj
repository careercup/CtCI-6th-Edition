(ns ^{:author "Leeor Engel"}
  data-structures.tree
  (:require [clojure.zip :as zip]))

(defrecord BinaryTreeNode [data left right])

(defn create-tree [tree-spec]
  "Creates a tree based on tree-spec and returns root node"
  (if (empty? tree-spec)
    nil
    (let [[data left right] tree-spec]
      (->BinaryTreeNode data (create-tree left) (create-tree right)))))

(defn tree-find [node data]
  "Returns the node containing data or nil if not found."
  (if (nil? node)
    nil
    (if (= (:data node) data)
      node
      (let [left-find (tree-find (:left node) data)
            right-find (tree-find (:right node) data)]
        (if (some? left-find)
          left-find
          right-find)))))

(defn in-order-walk [node]
  "returns a vector representing an in-order traversal."
  (if (some? node)
    (concat (in-order-walk (:left node))
            [(:data node)]
            (in-order-walk (:right node)))
    nil))

(defn pre-order-walk [node]
  "returns a vector representing a pre-order traversal."
  (if (some? node)
    (concat [(:data node)]
            (pre-order-walk (:left node))
            (pre-order-walk (:right node)))
    nil))

(defn post-order-walk [node]
  "returns a vector representing a post-order traversal."
  (if (some? node)
    (concat (post-order-walk (:left node))
            (post-order-walk (:right node))
            [(:data node)])
    nil))

;;
;; Zipper implementation for parent navigation
;; See: http://tech.puredanger.com/2010/10/22/zippers-with-records-in-clojure/
;;

(defn- branch? [_] true)
(defn- children [node] (remove nil? (seq [(:left node) (:right node)])))
(defn- make-node [node children] (->BinaryTreeNode (:data node) (first children) (second children)))

(defn create-tree-zipper [tree-spec]
  (let [root (create-tree tree-spec)]
    (zip/zipper branch? children make-node root)))

(defn zip-left-child [zipper-node]
  (-> zipper-node zip/down))

(defn zip-right-child [zipper-node]
  (-> zipper-node zip/down zip/right))

(defn zip-parent [zipper-node]
  (-> zipper-node zip/up))