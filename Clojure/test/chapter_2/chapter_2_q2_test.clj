(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q2-test
  (:require [clojure.test :refer :all]
            [data-structures.linked-list :refer :all]
            [chapter-2.chapter-2-q2 :refer :all]))

(deftest kth-to-last-test
  (is (= 3 (kth-to-last (create-linked-list [1 2 3]) 0)))
  (is (= 2 (kth-to-last (create-linked-list [1 2 3]) 1)))
  (is (= 1 (kth-to-last (create-linked-list [1 2 3]) 2)))
  (is (nil? (kth-to-last (create-linked-list [1 2 3]) 3))))

(deftest kth-to-last-recursive-test
  (is (= 3 (kth-to-last-recursive (create-linked-list [1 2 3]) 0)))
  (is (= 2 (kth-to-last-recursive (create-linked-list [1 2 3]) 1)))
  (is (= 1 (kth-to-last-recursive (create-linked-list [1 2 3]) 2)))
  (is (nil? (kth-to-last-recursive (create-linked-list [1 2 3]) 3))))