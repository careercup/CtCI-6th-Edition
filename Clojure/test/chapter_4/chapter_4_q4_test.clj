(ns ^{:author "Leeor Engel"}
  chapter-4.chapter-4-q4-test
  (:require [clojure.test :refer :all]
            [data-structures.tree :refer :all]
            [chapter-4.chapter-4-q4 :refer :all]))

(deftest tree-balanced-test
  (testing "single node"
    (let [tree (create-tree [1])]
      (is (tree-balanced? tree))))

  (testing "two nodes"
    (let [tree-1 (create-tree [1
                               [2]])
          tree-2 (create-tree [1
                               []
                               [2]])]
      (is (tree-balanced? tree-1))
      (is (tree-balanced? tree-2))))

  (testing "balanced > 2 nodes"
    (let [tree-1 (create-tree [1
                               [2]
                               [3]])
          tree-2 (create-tree [1
                               [2]
                               [3
                                [4]]])]
      (is (tree-balanced? tree-1))
      (is (tree-balanced? tree-2))))

  (testing "not balanced"
    (let [tree-1 (create-tree [1
                               [2
                                [3]]])
          tree-2 (create-tree [1
                               [2
                                [5
                                 [1]]]
                               [3]])
          tree-3 (create-tree [1
                               [2
                                [5
                                 [1]
                                 [15]]
                                [45]]
                               [3]])]
      (is (not (tree-balanced? tree-1)))
      (is (not (tree-balanced? tree-2)))
      (is (not (tree-balanced? tree-3))))))