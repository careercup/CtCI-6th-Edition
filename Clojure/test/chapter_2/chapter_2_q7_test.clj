(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q7-test
  (:require [clojure.test :refer :all]
            [data-structures.mutable-linked-list :refer :all]
            [chapter-2.chapter-2-q7 :refer :all]))

(deftest intersect-test
  (is (nil? (intersect?
              (create-linked-list 1)
              (create-linked-list 1))))

  (is (nil? (intersect?
              (create-linked-list 4 5 1 2 3)
              (create-linked-list 1 2 3))))

  (let [l1 (create-linked-list 1 2 3)
        l2 (->SinglyLinkedList (create-node-ref 4 (:head l1)))]
    (is (lists-eq?
          (create-linked-list 1 2 3)
          (->SinglyLinkedList (intersect? l1 l2)))))

  (let [l1 (create-linked-list 1 2 3)
        l2 (->SinglyLinkedList (create-node-ref 3 (:head l1)))]
    (is (lists-eq?
          (create-linked-list 1 2 3)
          (->SinglyLinkedList (intersect? l1 l2)))))

  (let [l1 (create-linked-list 12 14 16)
        l2 (->SinglyLinkedList (create-node-ref 7 (create-node-ref 7 (create-node-ref 8 (:head l1)))))]
    (is (lists-eq?
          (create-linked-list 12 14 16)
          (->SinglyLinkedList (intersect? l1 l2))))))
