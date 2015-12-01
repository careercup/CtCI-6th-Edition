(ns data-structures.mutable-linked-list-test
  (:require [clojure.test :refer :all]
            [data-structures.mutable-linked-list :refer :all]))

(defmacro create-linked-nodes [data & more]
  (let [datas (into [data] more)]
    (loop [create-exprs (list 'create-node-ref (last datas))
           remaining (butlast datas)]
      (if (empty? remaining)
        create-exprs
        (recur (list 'create-node-ref (last remaining) create-exprs)
               (butlast remaining))))))

(deftest append-to-tail-test
  (is (lists-eq?
        (->SinglyLinkedList (create-linked-nodes 1 2))
        (append-to-tail (create-linked-list 1) 2)))

  (is (lists-eq?
        (->SinglyLinkedList (create-linked-nodes 1 2))
        (create-linked-list 1 2)))

  (is (lists-eq?
        (->SinglyLinkedList (create-linked-nodes 1 2 3))
        (create-linked-list 1 2 3))))

(deftest length-test
  (is (= 1 (length (create-linked-list 1))))
  (is (= 2 (length (create-linked-list 1 2))))
  (is (= 3 (length (create-linked-list 1 2 3))))
  (is (= 4 (length (create-linked-list 1 2 3 4)))))

(deftest delete-node-test
  ;; delete head, list is head only
  (is (= nil (delete-node (create-linked-list 1) 1)))

  ;; delete not found
  (is (not (delete-node (create-linked-list 1 2) 3)))

  ; delete old head
  (let [expected (create-linked-list 2)
        actual (delete-node (create-linked-list 1 2) 1)]
    (is (lists-eq? expected actual)
        (str "Was: " (to-vec (:head actual)))))

  ; delete last
  (let [expected (create-linked-list 1)
        actual (delete-node (create-linked-list 1 2) 2)]
    (is (lists-eq? expected actual)
        (str "Was: " (to-vec (:head actual)))))

  (let [expected (create-linked-list 1 2)
        actual (delete-node (create-linked-list 1 2 3) 3)]
    (is (lists-eq? expected actual)
        (str "Was: " (to-vec (:head actual)))))

  ;;;; delete middle
  (let [expected (create-linked-list 1 3)
        actual (delete-node (create-linked-list 1 2 3) 2)]
    (is (lists-eq? expected actual)
        (str "Was: " (to-vec (:head actual)))))

  (let [expected (create-linked-list 1 2 4)
        actual (delete-node (create-linked-list 1 2 3 4) 3)]
    (is (lists-eq? expected actual)
        (str "Was: " (to-vec (:head actual))))))