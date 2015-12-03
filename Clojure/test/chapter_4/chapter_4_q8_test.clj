(ns ^{:author "Leeor Engel"}
chapter-4.chapter-4-q8-test
  (:require [clojure.test :refer :all]
            [data-structures.tree :refer :all]
            [chapter-4.chapter-4-q8 :refer :all]
            [clojure.zip :as zip]))

(deftest first-common-ancestor-test

  (testing "equal depths"
    (let [tree (create-tree-zipper [4])
          n1 tree
          n2 tree]
      (is (= (zip/node n1) (first-common-ancestor n1 n2))))

    (let [tree (create-tree-zipper [4
                                    [2] [3]])
          left-child (zip-left-child tree)
          right-child (zip-right-child tree)]
      (is (= (zip/node tree) (first-common-ancestor left-child right-child))))

    (let [tree (create-tree-zipper [4
                                    [2
                                     [1] [nil]]
                                    [3
                                     [nil] [7]]])
          n1 (-> tree zip-left-child zip-left-child)
          n2 (-> tree zip-right-child zip-right-child)]
      (is (= (zip/node tree) (first-common-ancestor n1 n2)))))

  (testing "un-equal depths"
    (let [tree (create-tree-zipper [4
                                    [2
                                     [1
                                      [14] [nil]]
                                     [8]]
                                    [3
                                     [nil] [7]]])
          n1 (-> tree zip-left-child zip-left-child zip-left-child)
          n2 (-> tree zip-left-child zip-right-child)]
      (is (= (-> tree zip-left-child zip/node) (first-common-ancestor n1 n2))))

    (let [tree (create-tree-zipper [4
                                    [2
                                     [1
                                      [14 [24]] [nil]]
                                     [8]]
                                    [3
                                     [nil] [7]]])
          n1 (-> tree zip-left-child zip-left-child zip-left-child zip-left-child)
          n2 (-> tree zip-left-child zip-right-child)]
      (is (= (-> tree zip-left-child zip/node) (first-common-ancestor n1 n2))))))