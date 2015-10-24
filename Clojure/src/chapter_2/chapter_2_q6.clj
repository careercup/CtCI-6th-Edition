(ns chapter-2.chapter-2-q6
  (:require
    [data-structures.linked-list :refer :all])
  (:import (clojure.lang Atom)
           (data_structures.linked_list SinglyLinkedList)))

(defn palindrome? [^SinglyLinkedList l]
  (loop [^SinglyLinkedList reversed nil
         ^Atom n (:head l)]
    (if (nil? n)
      (lists-eq? reversed l)
      (recur (if (nil? reversed)
               (create-linked-list (:data @n))
               (add-node reversed (:data @n)))
             (:next @n)))))