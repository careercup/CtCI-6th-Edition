(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q3-test
  (:require [clojure.test :refer :all]
            [data-structures.mutable-linked-list :refer :all]
            [chapter-2.chapter-2-q3 :refer :all]))

(deftest remove-middle-node-test
  (is (lists-eq?
        (create-linked-list 1 3)
        (let [l (create-linked-list 1 2 3)]
          (remove-middle-node (search l 2))
          l)))

  (is (lists-eq?
        (create-linked-list 1 2 4)
        (let [l (create-linked-list 1 2 3 4)]
          (remove-middle-node (search l 3))
          l)))

  (is (lists-eq?
        (create-linked-list 1 3 4)
        (let [l (create-linked-list 1 2 3 4)]
          (remove-middle-node (search l 2))
          l))))