(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q6
  (:require
    [data-structures.mutable-linked-list :refer :all])
  (:import (clojure.lang Atom)
           (data_structures.mutable_linked_list SinglyLinkedList)))

(defn palindrome? [^SinglyLinkedList l]
  (loop [^SinglyLinkedList reversed nil
         ^Atom n (:head l)]
    (if (nil? n)
      (lists-eq? reversed l)
      (recur (if (nil? reversed)
               (create-linked-list (:data @n))
               (add-node reversed (:data @n)))
             (:next @n)))))