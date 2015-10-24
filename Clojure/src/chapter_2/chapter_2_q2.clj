(ns chapter-2.chapter-2-q2
  (:require
    [data-structures.linked-list :refer :all])
  (:import (clojure.lang Atom)
           (data_structures.linked_list SinglyLinkedList)))

;; O(n+k)
(defn get-kth-to-last [^SinglyLinkedList l k]
  (let [len (length l)
        node-idx (- len k)]
    (loop [^Atom n (:head l)
           idx 0]
      (if (= node-idx idx)
        n
        (recur (:next @n)
               (inc idx))))))


(defn- get-kth-to-last-recur-helper [^Atom n k depth]
  (if (nil? (:next @n))
    (if (= depth (inc (- depth k)))
      [n depth]
      [nil depth])
    (let [[m length] (get-kth-to-last-recur-helper (:next @n) k (inc depth))]
      (if (and (nil? m) (= (- length k) (dec depth)))
        [n length]
        [m length]))))

;; O(n) time, O(n) space
(defn get-kth-to-last-recursive [^SinglyLinkedList l k]
  (let [[n _] (get-kth-to-last-recur-helper (:head l) k 1)]
    n))