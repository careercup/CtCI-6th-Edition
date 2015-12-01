(ns ^{:author "Leeor Engel"}
  chapter-4.chapter-4-q5-test
  (:require [clojure.test :refer :all]
            [data-structures.tree :refer :all]
            [chapter-4.chapter-4-q5 :refer :all]))

(deftest valid-bst-test
  (testing "single node"
    (let [tree (create-tree [1])]
      (is (valid-bst? tree))))

  (testing "two nodes"
    (let [tree-1 (create-tree [1
                               [2]])
          tree-2 (create-tree [1
                               [0]])
          tree-3 (create-tree [1
                               []
                               [2]])]
      (is (not (valid-bst? tree-1)))
      (is (valid-bst? tree-2))
      (is (valid-bst? tree-3))))

  (testing "balanced > 2 nodes"
    (let [tree-1 (create-tree [2
                               [1]
                               [3]])
          tree-2 (create-tree [2
                               [1]
                               [4
                                [3]]])
          tree-3 (create-tree [2
                               [1]
                               [3
                                [4]]])]
      (is (valid-bst? tree-1))
      (is (valid-bst? tree-2))
      (is (not (valid-bst? tree-3))))))

(deftest valid-bst-alt-test
  (testing "single node"
    (let [tree (create-tree [1])]
      (is (alt-valid-bst? tree))))

  (testing "two nodes"
    (let [tree-1 (create-tree [1
                               [2]])
          tree-2 (create-tree [1
                               [0]])
          tree-3 (create-tree [1
                               []
                               [2]])]
      (is (not (alt-valid-bst? tree-1)))
      (is (alt-valid-bst? tree-2))
      (is (alt-valid-bst? tree-3))))

  (testing "balanced > 2 nodes"
    (let [tree-1 (create-tree [2
                               [1]
                               [3]])
          tree-2 (create-tree [2
                               [1]
                               [4
                                [3]]])
          tree-3 (create-tree [2
                               [1]
                               [3
                                [4]]])]
      (is (alt-valid-bst? tree-1))
      (is (alt-valid-bst? tree-2))
      (is (not (alt-valid-bst? tree-3))))))