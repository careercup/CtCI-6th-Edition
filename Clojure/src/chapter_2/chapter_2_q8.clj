(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q8
  (:require [data-structures.mutable-linked-list :refer :all])
  (:import (clojure.lang Atom)
           (data_structures.mutable_linked_list SinglyLinkedList)))

(defn- skip-ahead [^Atom x num-skips]
  "Skips ahead and returns num-skips pointers ahead."
  (loop [^Atom n x
         skips 0]
    (if (= num-skips skips)
      n
      (recur (:next @n)
             (inc skips)))))

(defn get-collision-node [^Atom start-node ^Atom runner-start-node runner-steps]
  (loop [^Atom n start-node
         ^Atom runner (skip-ahead runner-start-node 1)]
    (if (= n runner)
      n
      (recur (:next @n)
             (skip-ahead runner runner-steps)))))

(defn get-cycle-begin-node [^SinglyLinkedList l]
  (let [collision-node (get-collision-node (:head l) (:head l) 2)]
    (get-collision-node (:head l) collision-node 1)))