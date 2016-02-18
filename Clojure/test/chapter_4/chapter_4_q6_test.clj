(ns ^{:author "Leeor Engel"}
  chapter-4.chapter-4-q6-test
  (:require [clojure.test :refer :all]
            [data-structures.tree :refer :all]
            [chapter-4.chapter-4-q6 :refer :all]
            [clojure.zip :as zip]))

(deftest sucessor-test
  (let [tree (create-tree-zipper [4
                                  [3
                                   [2]]
                                  [6
                                   [5]
                                   [8]]])
        left-child (zip-left-child tree)
        right-child (zip-right-child tree)
        right-left-child (-> right-child zip/down)
        lowest (-> left-child zip/down)
        highest (-> right-child zip/down zip/right)]
    (is (= 5 (-> tree successor :data)))
    (is (= 4 (-> left-child successor :data)))
    (is (= 8 (-> right-child successor :data)))
    (is (= 6 (-> right-left-child successor :data)))
    (is (= 3 (-> lowest successor :data)))
    (is (nil? (-> highest successor :data))))

  (let [largest-right-subtree-node (create-tree-zipper [6
                                                        [3
                                                         [2] [4
                                                              []
                                                              [5]]]
                                                        []])
        lowest-left (-> largest-right-subtree-node
                        zip-left-child
                        zip-right-child
                        zip-left-child)]
    (is (= 6 (-> lowest-left successor :data))))

  (let [largest-right-subtree-node-2 (create-tree-zipper [10
                                                          [2
                                                           [0] [4
                                                                [3]
                                                                [5
                                                                 [6]
                                                                 [8]]]]
                                                          [12]])
        lowest-left (-> largest-right-subtree-node-2
                        zip-left-child
                        zip-right-child
                        zip-right-child
                        zip-right-child)]
    (is (= 10 (-> lowest-left successor :data)))))