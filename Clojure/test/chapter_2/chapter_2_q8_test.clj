(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q8-test
  (:require [clojure.test :refer :all]
            [data-structures.mutable-linked-list :refer :all]
            [chapter-2.chapter-2-q8 :refer :all])
  (:import
    (clojure.lang Atom)
    (data_structures.mutable_linked_list SinglyLinkedList)))

(defn cycle-list [^SinglyLinkedList l cycle-point-data last-node-data]
  (let [^Atom cycle-node (find-node l cycle-point-data)
        ^Atom last-node (find-node l last-node-data)]
    (reset! last-node (create-node (:data @last-node) cycle-node))
    l))

(deftest get-cycle-begin-node-test

  (testing "cycle lists with start node as the head node"
    (let [cycle-begin-node (get-cycle-begin-node (cycle-list (create-linked-list 1) 1 1))]
      (is (= 1 (:data @cycle-begin-node))))

    (let [cycle-begin-node (get-cycle-begin-node (cycle-list (create-linked-list 1 2) 1 2))]
      (is (= 1 (:data @cycle-begin-node))))

    (let [cycle-begin-node (get-cycle-begin-node (cycle-list (create-linked-list 1 2 3) 1 3))]
      (is (= 1 (:data @cycle-begin-node))))

    (let [cycle-begin-node (get-cycle-begin-node (cycle-list (create-linked-list 1 2 3 4) 1 4))]
      (is (= 1 (:data @cycle-begin-node))
          (str "Expected: 1" ", Actual: " (:data @cycle-begin-node))))

    (let [cycle-begin-node (get-cycle-begin-node (cycle-list (create-linked-list 1 2 3 4 5) 1 5))]
      (is (= 1 (:data @cycle-begin-node))
          (str "Expected: 1" ", Actual: " (:data @cycle-begin-node)))))

  (testing "Cycle in the middle"
    (let [cycle-begin-node (get-cycle-begin-node (cycle-list (create-linked-list 1 2 3 4 5) 2 5))]
      (is (= 2 (:data @cycle-begin-node))
          (str "Expected: 2" ", Actual: " (:data @cycle-begin-node))))

    (let [cycle-begin-node (get-cycle-begin-node (cycle-list (create-linked-list 1 2 3 4 5) 3 5))]
      (is (= 3 (:data @cycle-begin-node))
          (str "Expected: 3" ", Actual: " (:data @cycle-begin-node))))

    (let [cycle-begin-node (get-cycle-begin-node (cycle-list (create-linked-list 1 2 3 4 5) 4 5))]
      (is (= 4 (:data @cycle-begin-node))
          (str "Expected: 4" ", Actual: " (:data @cycle-begin-node))))

    (let [cycle-begin-node (get-cycle-begin-node (cycle-list (create-linked-list 1 2 3 4 5) 5 5))]
      (is (= 5 (:data @cycle-begin-node))
          (str "Expected: 5" ", Actual: " (:data @cycle-begin-node))))))
