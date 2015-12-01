(ns ^{:author "Leeor Engel"}
  chapter-4.chapter-4-q3-test
  (:require [clojure.test :refer :all]
            [data-structures.tree :refer :all]
            [chapter-4.chapter-4-q3 :refer :all]))

(deftest list-of-depths-test

  (let [tree (create-tree [1])
        actual (list-of-depths tree)]
    (is (= {0 '(1)} actual)))

  (let [tree (create-tree [1
                           [2]
                           [3]])
        actual (list-of-depths tree)]
    (is (= {0 '(1)
            1 '(2 3)} actual)))

  (let [tree (create-tree [1
                           [2
                            [5
                             [1]]]
                           [3]])
        actual (list-of-depths tree)]
    (is (= {0 '(1)
            1 '(2 3)
            2 '(5)
            3 '(1)} actual)))

  (let [tree (create-tree [1
                           [2
                            [5
                             [1]]]
                           [3
                            [6
                             [23]]
                            [10]]])
        actual (list-of-depths tree)]
    (is (= {0 '(1)
            1 '(2 3)
            2 '(5 6 10)
            3 '(1 23)} actual))))