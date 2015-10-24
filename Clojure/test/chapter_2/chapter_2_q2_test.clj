(ns chapter-2.chapter-2-q2-test
  (:require [clojure.test :refer :all]
            [data-structures.linked-list :refer :all]
            [chapter-2.chapter-2-q2 :refer :all]))

(deftest get-kth-to-last-test
  ;(is (nil? (get-kth-to-last (create-linked-list 1 2 3) 0)))
  (is (lists-eq?
        (create-linked-list 3)
        (->SinglyLinkedList (get-kth-to-last (create-linked-list 1 2 3) 1))))
  (is (lists-eq?
        (create-linked-list 2 3)
        (->SinglyLinkedList (get-kth-to-last (create-linked-list 1 2 3) 2))))
  (is (lists-eq?
        (create-linked-list 1 2 3)
        (->SinglyLinkedList (get-kth-to-last (create-linked-list 1 2 3) 3)))))

(deftest get-kth-to-last-recursive-test
  (is (nil? (get-kth-to-last-recursive (create-linked-list 1 2 3) 0)))
  (is (lists-eq?
        (create-linked-list 3)
        (->SinglyLinkedList (get-kth-to-last-recursive (create-linked-list 1 2 3) 1))))
  (is (lists-eq?
        (create-linked-list 2 3)
        (->SinglyLinkedList (get-kth-to-last-recursive (create-linked-list 1 2 3) 2))))
  (is (lists-eq?
        (create-linked-list 1 2 3)
        (->SinglyLinkedList (get-kth-to-last-recursive (create-linked-list 1 2 3) 3)))))