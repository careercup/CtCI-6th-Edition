(ns ^{:author "Leeor Engel"}
chapter-4.chapter-4-q10-test
  (:require [clojure.test :refer :all]
            [data-structures.tree :refer :all]
            [chapter-4.chapter-4-q10 :refer :all]))

(deftest subtree-test
  (let [t1 (create-tree [1])
        t2 (create-tree [3])]
    (is (not (subtree? t1 t2))))

  (let [t1 (create-tree [1
                         [2]])
        t2 (create-tree [3])]
    (is (not (subtree? t1 t2))))

  (let [t1 (create-tree [1
                         [2]])
        t2 (create-tree [2])]
    (is (subtree? t1 t2)))

  (let [t1 (create-tree [1
                         [2]])
        t2 (create-tree [1 [2]])]
    (is (subtree? t1 t2)))

  (let [t1 (create-tree [1
                         [2]])
        t2 (create-tree [2])]
    (is (subtree? t1 t2)))

  (let [t1 (create-tree [1
                         [2
                          [4]
                          [8 [10
                              [12]]]]
                         [3]])
        t2 (create-tree [8 [10
                            [12]]])]
    (is (subtree? t1 t2)))

  (let [t1 (create-tree [1
                         [2
                          [4]
                          [8 [10
                              [12]]]]
                         [3]])
        t2 (create-tree [3])]
    (is (subtree? t1 t2)))

  (let [t1 (create-tree [1
                         [3
                          [67]]
                         [2
                          [4]
                          [8
                           [10
                            [12]]
                           [14]]]])
        t2 (create-tree [8
                         [10
                          [12]]
                         [14]])]
    (is (subtree? t1 t2))))