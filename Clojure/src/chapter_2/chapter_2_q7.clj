(ns chapter-2.chapter-2-q7
  (:require
    [data-structures.mutable-linked-list :refer :all])
  (:import (clojure.lang Atom)
           (data_structures.mutable_linked_list SinglyLinkedList)))

(defn intersect? [^SinglyLinkedList l1 ^SinglyLinkedList l2]
  (loop [^Atom n1 (:head l1)
         ^Atom n2 (:head l2)
         ref-map {}]
    (cond (contains? ref-map n1) n1
          (contains? ref-map n2) n2
          :else (if (and (nil? n1) (nil? n2))
                  nil
                  (recur (if (nil? n1) nil (:next @n1))
                         (if (nil? n2) nil (:next @n2))
                         (cond (nil? n1) (assoc ref-map n2 1)
                               (nil? n2) (assoc ref-map n1 1)
                               :else (assoc ref-map n1 1 n2 1)))))))